package com.example.lostark.thirdParty.lostArk.api.getData;

import com.example.lostark.model.entity.auction.AuctionProduct;
import com.example.lostark.thirdParty.lostArk.api.LostArkApiInterface;
import com.example.lostark.thirdParty.lostArk.api.LostArkFeign;
import com.example.lostark.thirdParty.lostArk.param.LostArkAuctionParam;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class LostArkAuction<E extends AuctionProduct> implements LostArkApiInterface<E,LostArkAuctionParam> {
    private ObjectMapper objectMapper = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    private final LostArkFeign lostArkFeign;
    private ArrayList<E> mapping(ArrayList<LinkedHashMap> data){
        ArrayList<AuctionProduct> auctionProducts = new ArrayList<>();
        for(LinkedHashMap target:data) {
            AuctionProduct auctionProduct = objectMapper.convertValue(target, AuctionProduct.class);
            auctionProducts.add(auctionProduct);
        }
        return (ArrayList<E>) auctionProducts;
    }
    @Override
    public ArrayList<E> getData(LostArkAuctionParam lostArkAuctionParam) {
        LinkedHashMap data = lostArkFeign.AuctionSearch(lostArkAuctionParam);
        return mapping((ArrayList<LinkedHashMap>) data.get("Items"));
    }
}
