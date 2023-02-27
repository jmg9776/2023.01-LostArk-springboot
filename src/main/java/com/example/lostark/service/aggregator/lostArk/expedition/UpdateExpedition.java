package com.example.lostark.service.aggregator.lostArk.expedition;

import com.example.lostark.model.entity.CharacterInfo;
import com.example.lostark.model.entity.Expedition;
import com.example.lostark.model.entity.Member;
import com.example.lostark.service.persist.CharacterInfoService;
import com.example.lostark.service.persist.ExpeditionService;
import com.example.lostark.service.persist.MemberService;
import com.example.lostark.thirdParty.lostArk.api.getData.LostArkExpedition;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateExpedition {
    private final MemberService memberService;
    private final CharacterInfoService characterInfoService;
    private final ExpeditionService expeditionService;
    private final LostArkExpedition lostArkExpedition;

    @Cacheable(value = "expeditionUpdate", key = "#uid")
    public void update(Long uid) {
        List<CharacterInfo> data;

        Optional<Member> memberOptional = memberService.findById(uid);
        Member member;
        if (memberOptional.isPresent()) {
            member = memberOptional.get();
        } else return;

        data = lostArkExpedition.getData(member.getCharacterName());

        if (data == null) return;
        List<CharacterInfo> characterInfoList = characterInfoService.saveAll(data);
        List<Expedition> expeditionList = expeditionService.findAllByUid(member.getUid());

        boolean flag;
        for (CharacterInfo target:characterInfoList) {
            flag = true;
            for (Expedition expedition: expeditionList) {
                if (target.getCharacterName().equals(expedition.getCharacterInfo().getCharacterName())) {
                    flag = false;
                    expeditionList.remove(expedition);
                    break;
                }
            }
            if (flag == true) {
                expeditionList.add(Expedition.builder()
                        .characterInfo(target)
                        .member(member).build());
            }
        }
        expeditionService.saveAll(expeditionList);
    }
}
