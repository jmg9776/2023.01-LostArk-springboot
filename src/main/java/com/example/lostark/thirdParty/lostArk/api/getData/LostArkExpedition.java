package com.example.lostark.thirdParty.lostArk.api.getData;

import com.example.lostark.model.entity.CharacterInfo;
import com.example.lostark.thirdParty.lostArk.api.LostArkApiInterface;
import com.example.lostark.thirdParty.lostArk.api.LostArkFeign;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class LostArkExpedition <E extends CharacterInfo> implements LostArkApiInterface<E, String> {
    private ObjectMapper objectMapper = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    private final LostArkFeign lostArkFeign;
    protected ArrayList<E> mapping(ArrayList<LinkedHashMap> data) {
        ArrayList<CharacterInfo> arrayList = new ArrayList<>();
        for (LinkedHashMap target : data) {
            target.replace("ItemAvgLevel", target.get("ItemAvgLevel").toString().replace(",", ""));
            target.replace("ItemMaxLevel", target.get("ItemMaxLevel").toString().replace(",", ""));
            arrayList.add(objectMapper.convertValue(target, CharacterInfo.class));
        }
        return (ArrayList<E>) arrayList;
    }
    @Override
    public ArrayList<E> getData(String name) {
        ArrayList<LinkedHashMap> data = lostArkFeign.ExpeditionSearch(URLEncoder.encode(name));
        return mapping(data);
    }
}
