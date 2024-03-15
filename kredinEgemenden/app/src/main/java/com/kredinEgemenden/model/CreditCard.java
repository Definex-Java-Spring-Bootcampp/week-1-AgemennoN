/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kredinEgemenden.model;

import com.kredinEgemenden.enums.ProductType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class CreditCard implements Product {
    private String name;
    private BigDecimal fee;
    private List<Campaign> campaignList;
    private Bank bank;
    private final ProductType productType = ProductType.CreditCard;
    
    public CreditCard(String name, BigDecimal fee) {
        this.name = name;
        this.fee = fee;
        this.campaignList = new ArrayList<>();
    }
    
    public CreditCard(String name, BigDecimal fee, List<Campaign> campaignList) {
        this.name = name;
        this.fee = fee;
        this.campaignList = campaignList;
    }

    public void addCampaign(Campaign campaign){
        if(this.campaignList.contains(campaign)){
            System.out.println(this.name + " Already has the Campaign " + campaign.getTitle());
            return;
        }
        this.campaignList.add(campaign);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    
    @Override
    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "name=" + name + ", fee=" + fee + ", campaignList=" + campaignList + ", bank=" + bank.getName() + '}';
    }
    
}
