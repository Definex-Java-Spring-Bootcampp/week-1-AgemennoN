/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kredinEgemenden.model;
import com.kredinEgemenden.enums.LoanType;
import com.kredinEgemenden.model.factories.CreditCardFactory;
import com.kredinEgemenden.model.factories.LoanFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Bank {
    
    private String name;
    private HashMap<LoanType, List<Loan>> loanMap;
    private List<CreditCard> creditCards;
    private final LoanFactory loanFactory = LoanFactory.getInstance();
    private final CreditCardFactory creditCardsFactory = CreditCardFactory.getInstance();

    
    public Bank(String name) {
        this.name = name;
        this.creditCards = new ArrayList<>();
        this.loanMap = new HashMap<>();
        this.loanMap.put(LoanType.VEHICLE_LOAN, new ArrayList<>());
        this.loanMap.put(LoanType.CONSUMER_LOAN, new ArrayList<>());
        this.loanMap.put(LoanType.HOUSE_LOAN, new ArrayList<>());
    }

    public Product findLoanByName(LoanType lType, String name) {
        Loan loan = loanMap.get(lType).stream()
                                      .filter(l -> l.getName().equals(name))
                                      .findFirst()
                                      .orElse(null);
        return loan;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<LoanType, List<Loan>> getLoanMap() {
        return loanMap;
    }

    public void setLoanMap(HashMap<LoanType, List<Loan>> loanMap) {
        this.loanMap = loanMap;
    }
    
    public void addLoan(LoanType type, Loan loan){
        this.loanMap.get(type)
                    .add(loan);
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    
    public CreditCard newCreditCard(String name, BigDecimal fee){
        CreditCard cc = this.creditCardsFactory.createCreditCard(name, fee, this);
        return cc;
    }

    public LoanFactory getLoanFactory() {
        return loanFactory;
    }

    public CreditCardFactory getCreditCardsFactory() {
        return creditCardsFactory;
    }
    

    @Override
    public String toString() {
        return "Bank{" + "name=" + name + ", loanMap=" + loanMap + ", creditCards=" + creditCards + '}';
    }
    
}
