package com.example.lostark.service.aggregator.lostArk.getFixedData;

import com.example.lostark.model.entity.Market;
import com.example.lostark.thirdParty.lostArk.api.getData.LostArkMarket;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
@RequiredArgsConstructor
public class GetFixedDataMarket implements GetFixedDataInterface<List<Market>> {
    private final LostArkMarket lostArkMarket;
    private List<Market> param;
    public List<Market> get() {
        return lostArkMarket.getData(param);
    }
}
