package com.example.many.toMany.compositeKey.embeddable.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
@ToString
public class NotificationId {

    private static final long serialVersionUID = -396258162445116435L;

    String idempotencyKey;
    String fromService;
}
