package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
public class LoanController {

    @GetMapping("/loan")
    public Loan getLoan() {

        Loan loan = new Loan(
                1001,
                "Home Loan",
                500000.00,
                15000.00,
                36
        );

        return loan;
    }
}