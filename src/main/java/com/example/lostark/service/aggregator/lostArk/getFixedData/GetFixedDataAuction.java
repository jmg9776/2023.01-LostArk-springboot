package com.example.lostark.service.aggregator.lostArk.getFixedData;

import com.example.lostark.model.entity.auction.AuctionProduct;
import com.example.lostark.thirdParty.lostArk.api.getData.LostArkAuction;
import com.example.lostark.thirdParty.lostArk.param.LostArkAuctionParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFixedDataAuction implements GetFixedDataInterface<List<AuctionProduct>> {
    private final LostArkAuction lostArkAuction;

    private AuctionProduct getData(Integer i, String itemName) {
        final LostArkAuctionParam param = new LostArkAuctionParam();
        param.setItemName(itemName);
        param.setCategoryCode(210000);

        List<AuctionProduct> objectList = lostArkAuction.getData(param);

        AuctionProduct data = objectList.get(3);
        data.setId(Long.valueOf(i));
        data.getAuctionInfo().setId(Long.valueOf(i));
        data.getOptions().get(0).setId(Long.valueOf(i));

        return data;
    }

    @Override
    public List<AuctionProduct> get() {
        List<AuctionProduct> data = new ArrayList<>();
        for(int i=1;i<=10;i++) {
            data.add(getData(i, i+"레벨 멸화"));
            data.add(getData(i+10, i+"레벨 홍염"));
        }
        return data;
    }
}
