package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
public class AccountController {

    @GetMapping("/account")
    public Account getAccount() {

        Account account = new Account(
                1001,
                "Subhashini",
                "Savings",
                50000.00
        );

        return account;
    }
}