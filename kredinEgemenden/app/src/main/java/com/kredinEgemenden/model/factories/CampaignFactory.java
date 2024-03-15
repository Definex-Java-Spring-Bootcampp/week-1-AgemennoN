

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.enums.SectorType;
import com.kredinEgemenden.model.Campaign;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CampaignFactory {
    public static List<Campaign> campaignList = new ArrayList<>();
    
    public static Campaign createCampaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector){
        Campaign campaign = new Campaign(title,  content,  dueDate,  createDate,  updateDate,  sector);
        campaignList.add(campaign);
        return campaign;
    }
}
