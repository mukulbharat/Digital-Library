package com.example.many.toMany.compositeKey.embeddable.repository;

import com.example.many.toMany.compositeKey.embeddable.entity.Notification;
import com.example.many.toMany.compositeKey.embeddable.entity.NotificationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, NotificationId> {
}
