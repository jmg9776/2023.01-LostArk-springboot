package com.example.lostark.thirdParty.lostArk.param;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class LostArkAuctionParam {
    private Integer categoryCode;
    private String sort;
    private String sortCondition;
    private String itemGrade;
    private Integer itemTier;
    private String itemName;
    private Integer pageNo;
    private Integer itemGradeQuality;
    private List<LostArkEtcOptionsParam> lostArkEtcOptionsParams;
    public LostArkAuctionParam() {
        this.sort="BUY_PRICE";
        this.sortCondition="DESC";
        this.itemGrade=null;
        this.itemTier=3;
        this.pageNo=0;
        this.itemGradeQuality=null;
        this.lostArkEtcOptionsParams=null;
    }
}
