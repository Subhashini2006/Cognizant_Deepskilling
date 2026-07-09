package com.cognizant.loan.model;

public class Loan {

    private long loanNumber;
    private String loanType;
    private double loanAmount;
    private double emi;
    private int tenure;

    public Loan(long loanNumber, String loanType, double loanAmount, double emi, int tenure) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.emi = emi;
        this.tenure = tenure;
    }

    public long getLoanNumber() {
        return loanNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getEmi() {
        return emi;
    }

    public int getTenure() {
        return tenure;
    }
}