# Digital-Library
This Spring Boot application provides a comprehensive digital library system, managing books, authors, users, and orders. It ensures efficient book loaning, tracking, and notification services.
Features
Library Service
Book management (create, update, delete)
Author management (create, update, delete)
User management (create, update, delete)
Order management (create, update, delete)
Book search by name or ISBN
User validation and loan eligibility check
Book availability tracking
Notification Service
Notification microservice using composite keys
Real-time notifications for book availability and order updates
Technical Details
Dependencies
Spring Boot Starter Web
MySQL Driver
Spring JPA
Lombok
Hibernate Envers
Annotations
@Entity, @Builder, @NoArgsConstructor, @AllArgsConstructor, @Getter, @Setter, @ToString
@Id, @GeneratedValue, @OneToMany, @CreationTimestamp, @UpdateTimestamp
@EmbeddedId, @JsonIgnoreProperties, @ToString.Exclude, @Slf4j
@Service, @Autowired, @Transactional, @RestController
@RequestMapping, @PostMapping, @RequestBody, @Valid
APIs
Book API (/v1/books)
Order API (/v1/orders)
User API (/v1/users)
Project Structure
The project consists of two packages:
library
Entities (Author, Book, Order, UserInfo)
Repositories (Book, Order, User)
Services (Author, Book, Catalogue, Inventory, Order, User)
Controllers (Book, Order, User)
Exceptions (Book, User, Order)
Enums (Book Status, User Status, Order Status, User Type)
notification
Notification microservice using composite keys
