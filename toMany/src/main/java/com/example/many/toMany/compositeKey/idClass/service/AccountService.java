package com.example.many.toMany.compositeKey.idClass.service;

import com.example.many.toMany.compositeKey.idClass.entity.AccountId;
import com.example.many.toMany.compositeKey.idClass.entity.Accounts;
import com.example.many.toMany.compositeKey.idClass.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService implements InitializingBean {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        var account = Accounts.builder()
                .idempotencyKey("1e6c510e-379b-462d-8273-93e9019de312")
                .fromService("payment")
                .dynamicField("dynamic_fields")
                .templateId("paymentTemplate")
                .build();

        accountRepository.save(account);

        var transaction = Accounts.builder()
                .idempotencyKey("1e6c510e-379b-462d-8273-93e9019de312")
                .fromService("transaction")
                .dynamicField("dynamic_fields")
                .templateId("paymentTemplate")
                .build();

        accountRepository.save(transaction);

        var paymentRecord=accountRepository.findById(new AccountId("1e6c510e-379b-462d-8273-93e9019de312", "payment"));
        log.info("payment record {}", paymentRecord);
        var transactionRecord=accountRepository.findById(new AccountId("1e6c510e-379b-462d-8273-93e9019de312", "transaction"));
        log.info("transaction record {}", transactionRecord);



    }
}
