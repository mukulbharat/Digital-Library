package com.example.minor.project.service;

import com.example.minor.project.exception.BooksException;
import com.example.minor.project.exception.ExceptionCode;
import com.example.minor.project.models.entity.Books;
import com.example.minor.project.models.entity.Orders;
import com.example.minor.project.models.entity.enums.BookStatus;
import com.example.minor.project.models.entity.enums.OrderStatus;
import com.example.minor.project.models.request.CreateOrderRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class InventoryService {
    /*
    * placing new order
    *
    * USer(frm session)
    * -user Email/ phoneNumber/ PII
    *
    * identify book
    * -isbn or bookId
    *
    *
    * Order
    * -UserId
    * -BookId/ iSbn
    *
    * 1. Validate User(userPresent and Student or not or if User is Blocked) otherwise throw Exception
    * 2. Validate Book(available or not) otherwise throw Exception
    * 3.Quota (Check if user has max books allowed in active ), if more than allowed trying to be issued throws exception
    * 4. Order is placed in pending state
    * 5. Mark the book from available to unavailable and issue it to user
    * 6.Move the order to success state.
    * */

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    OrderService orderService;

    @Value("${student.book.quota:2}")
    Integer bookQuota;


    @Transactional
    public Orders placeOrder(CreateOrderRequest orderRequest){
        var student=userService.findActiveStudentById(orderRequest.getUserId());
        log.info("existing user {}", student);

        var book=bookService.getBookNotIssuedToUser(orderRequest.getBookId());
        log.info(" book {} ", book);
        // book already issued to another user
        if(book.getLoanedToUser() !=null){
            log.error(" book {} already issued to another user {}", book, book.getLoanedToUser().getId());
            throw new BooksException(ExceptionCode.BOOK_ALREADY_ISSUED);
        }

        //check the orderList of a user
        // of no of orders>3


       var existingOrders =student.getOrderList();
        if(Objects.nonNull(bookQuota) && existingOrders.size() > bookQuota){
            throw new BooksException((ExceptionCode.BOOK_QUOTA_EXHAUSTED));
          //  throw new BooksException(BOOK_QUOTA_EXHAUSTED);
        }

        // or check with no of books-> get the book count

           List<Books> books = new LinkedList<>();
           books.add(book);
        Orders order= Orders.builder()
                //.books(Collections.singletonList(book))
                .books(books)
                .createdBy(student)
                .orderStatus(OrderStatus.PENDING)
                .build();

        /*
        * save the order in pending state
        * */
        orderService.saveOrUpdate(order);
        book.setBookStatus(BookStatus.ISSUED);
        book.setMappedWithOrder(order);
        book.setLoanedToUser(student);

       // bookService.saveOrUpdate(book);

        order.setOrderStatus(OrderStatus.SUCCESS);

        orderService.saveOrUpdate(order);
        log.info(" order {} placed by {} ", order, student.getId());

        return order;


    }
}
