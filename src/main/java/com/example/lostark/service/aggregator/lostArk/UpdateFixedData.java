package com.example.lostark.service.aggregator.lostArk;

import com.example.lostark.service.aggregator.lostArk.getFixedData.GetFixedDataAuction;
import com.example.lostark.service.aggregator.lostArk.getFixedData.GetFixedDataInterface;
import com.example.lostark.service.aggregator.lostArk.getFixedData.GetFixedDataMarket;
import com.example.lostark.service.persist.AuctionService;
import com.example.lostark.service.persist.DataAccessAbstract;
import com.example.lostark.service.persist.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateFixedData {
    private final AuctionService auctionService;
    private final MarketService marketService;
    private final GetFixedDataAuction auctionFixed;
    private final GetFixedDataMarket marketFixed;

    @Cacheable(value = "fixedUpdate", key="")
    public void updateAll() {
        updateFixed(auctionFixed, auctionService);
        marketFixed.setParam(marketService.findAll());
        updateFixed(marketFixed, marketService);
    }
    private void updateFixed(GetFixedDataInterface lostArkUpdate, DataAccessAbstract databaseAbstract) {
        databaseAbstract.saveAll((List) lostArkUpdate.get());
    }
}
