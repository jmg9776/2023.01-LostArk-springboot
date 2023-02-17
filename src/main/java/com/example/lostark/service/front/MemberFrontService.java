package com.example.lostark.service.front;

import com.example.lostark.model.entity.Member;
import com.example.lostark.model.param.MemberParam;
import com.example.lostark.model.result.RestResult;
import com.example.lostark.model.result.RestResultBuilder;
import com.example.lostark.service.persist.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// fixme 전체적으로 로그를 적절하게 찍어야할 것 같습니다. ^^
@AllArgsConstructor
@Service
public class MemberFrontService {
    private final MemberService memberService;
    private final RestResultBuilder resultBuilder = new RestResultBuilder();

    public RestResult sign(MemberParam memberParam) {
        Member account = memberService.save(memberParam.toEntity());
        return resultBuilder.resultBuilder("success",account);
    }
}
