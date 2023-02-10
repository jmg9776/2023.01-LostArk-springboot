package com.example.lostark.thirdParty.lostArk.api.getData;

import com.example.lostark.model.entity.Market;
import com.example.lostark.thirdParty.lostArk.api.LostArkApiInterface;
import com.example.lostark.thirdParty.lostArk.api.LostArkFeign;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class LostArkMarket<E extends Market> implements LostArkApiInterface<E, List<E>> {
    private ObjectMapper objectMapper = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    private final LostArkFeign lostArkFeign;
    protected E mapping(Long id, LinkedHashMap data) {
        data.put("avgPrice", ((Map.Entry)((LinkedHashMap)((ArrayList)((Map.Entry)data.entrySet().toArray()[3])
                .getValue()).get(0))
                .entrySet().toArray()[1]).getValue());
        E market = (E) objectMapper.convertValue(data, Market.class);
        market.setId(id);
        return market;
    }
    @Override
    public ArrayList<E> getData(List<E> market) {
        LinkedHashMap temp;
        Market data;
        ArrayList<E> result = new ArrayList<>();

        for(E target:market) {
            temp = lostArkFeign.MarketSearch(target.getId()).get(0);
            data = mapping(target.getId(),temp);
            target.setName(data.getName());
            target.setAvgPrice(data.getAvgPrice());
            result.add(target);
        }
        return result;
    }
}
