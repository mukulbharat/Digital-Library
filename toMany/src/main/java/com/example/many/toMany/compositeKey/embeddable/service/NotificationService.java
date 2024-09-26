package com.example.many.toMany.compositeKey.embeddable.service;

import com.example.many.toMany.compositeKey.embeddable.entity.Notification;
import com.example.many.toMany.compositeKey.embeddable.entity.NotificationId;
import com.example.many.toMany.compositeKey.embeddable.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService implements InitializingBean {

    @Autowired
    NotificationRepository repository;

    @Override
    public void afterPropertiesSet() throws Exception {
        // create a new paymentNotification object
        NotificationId paymentNotificationId =new NotificationId("1e6c510e-379b-462d-8273-93e9019de312", "payment");

        Notification paymentNotification= Notification.builder()
                .notificationId(paymentNotificationId)
                .templateId("paymentTemplate")
                .dynamicField("dynamic_fields")
                .build();
        //persist in DB
        repository.save(paymentNotification);

        //fetch from DB
        Notification persisted= repository.findById(paymentNotificationId).orElse(null);
        log.info("finding the persisted paymentNotification {} ", persisted);

        NotificationId orderNotificationId =new NotificationId("1e6c510e-379b-462d-8273-93e9019de312", "order");

        Notification orderNotification = Notification.builder()
                .notificationId(orderNotificationId)
                .templateId("orderTemplate")
                .dynamicField("dynamic_fields")
                .build();

        //persist in DB
        repository.save(orderNotification);

        //fetch from DB
        Notification orderNotificationInDB= repository.findById(orderNotificationId).orElse(null);
        log.info("finding the persisted paymentNotification {} ", orderNotificationInDB);

    }
}
