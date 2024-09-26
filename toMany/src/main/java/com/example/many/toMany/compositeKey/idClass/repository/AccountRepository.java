package com.example.many.toMany.compositeKey.idClass.repository;

import com.example.many.toMany.compositeKey.idClass.entity.AccountId;
import com.example.many.toMany.compositeKey.idClass.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, AccountId> {
}
