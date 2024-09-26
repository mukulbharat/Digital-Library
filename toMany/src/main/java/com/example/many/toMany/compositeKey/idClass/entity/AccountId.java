package com.example.many.toMany.compositeKey.idClass.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountId implements Serializable {
    private static final long serialVersionUID = -396258162445116435L;

    String idempotencyKey;
    String fromService;
}
