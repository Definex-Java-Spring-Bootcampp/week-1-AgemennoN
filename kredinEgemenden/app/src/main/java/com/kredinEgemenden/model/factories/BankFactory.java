/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.enums.LoanType;
import com.kredinEgemenden.model.Bank;
import com.kredinEgemenden.model.CreditCard;
import com.kredinEgemenden.model.Loan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BankFactory {
    private static ArrayList<Bank> bankList = new ArrayList<>();
    
    public static Bank createBank(String name){
        Bank bank = checkIfBankExistbyName(name);
        if (bank != null){
            System.out.println("The Bank named " + name + " is already exist: ");
            return bank;
        }
        bank =  new Bank(name);
        bankList.add(bank);
        return bank;
    }
    
    public static Bank createBank(String name, HashMap<LoanType, List<Loan>> loanMap){
        Bank bank = checkIfBankExistbyName(name);
        if (bank != null){
            System.out.println("The Bank named " + name + " is already exist: ");
            return bank;
        }
        bank =  new Bank(name);
        bank.setLoanMap(loanMap);
        bankList.add(bank);
        return bank;
    }
    
    public static Bank createBank(String name, List<Loan> loanList){
        Bank bank = checkIfBankExistbyName(name);
        if (bank != null){
            System.out.println("The Bank named " + name + " is already exist: ");
            return bank;
        }
        bank =  new Bank(name);
        HashMap<LoanType, List<Loan>> loanMap = bank.getLoanMap();
        loanList.stream()
                .forEach(loan -> {
                    if (null != loan.getLoanType()) switch (loan.getLoanType()) {
                case CONSUMER_LOAN -> loanMap.get(LoanType.CONSUMER_LOAN).add(loan);
                case HOUSE_LOAN -> loanMap.get(LoanType.HOUSE_LOAN).add(loan);
                case VEHICLE_LOAN -> loanMap.get(LoanType.VEHICLE_LOAN).add(loan);
                default -> {
                        }
            }
                });
        
        bank.setLoanMap((HashMap<LoanType, List<Loan>>) loanMap);
        bankList.add(bank);
        return bank;
    }

    public static Bank createBank(String name, HashMap<LoanType, List<Loan>> loanMap, List<CreditCard> creditCards){
        Bank bank = checkIfBankExistbyName(name);
        if (bank != null){
            System.out.println("The Bank named " + name + " is already exist: ");
            return bank;
        }
        bank =  new Bank(name);
        bank.setLoanMap(loanMap);
        bank.setCreditCards(creditCards);
        bankList.add(bank);
        return bank;
    }
    
    private static Bank checkIfBankExistbyName(String bankName){
        Bank bank;
        bank = bankList.stream()
                .filter(b -> b.getName().equals(bankName))
                .findFirst()   // Find matching Bank (if any)
                .orElse(null); // Return null if no matching Bank is found 
        return bank;
    }
}
