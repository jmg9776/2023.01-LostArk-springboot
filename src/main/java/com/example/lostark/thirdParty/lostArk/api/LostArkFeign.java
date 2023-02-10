package com.example.lostark.thirdParty.lostArk.api;

import com.example.lostark.config.redis.RedisKeys;
import com.example.lostark.thirdParty.lostArk.param.LostArkAuctionParam;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@FeignClient(name="MasterFeign", url="https://developer-lostark.game.onstove.com", configuration = LostArkFeignConfig.class)
public interface LostArkFeign {
    @Cacheable(value = RedisKeys.TEST, key="#lostArkAuctionParam")
    @PostMapping("/auctions/items")
    LinkedHashMap AuctionSearch(@RequestBody LostArkAuctionParam lostArkAuctionParam);

    @Cacheable(value = RedisKeys.TEST, key="#itemCode")
    @GetMapping(value = "/markets/items/{itemCode}")
    ArrayList<LinkedHashMap> MarketSearch(@PathVariable("itemCode") Long itemCode);

    @Cacheable(value = RedisKeys.TEST, key="#data")
    @GetMapping(value = "/characters/{data}/siblings")
    ArrayList<LinkedHashMap> ExpeditionSearch(@PathVariable("data") String data);
}
