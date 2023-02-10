package com.example.lostark.model.param;

import com.example.lostark.model.entity.Member;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class MemberParam {
    private Long uid;
    private String id;
    private String pw;
    private String name;
    private String characterName;

    public Member toEntity(){
        return Member.builder()
                .uid(uid)
                .id(id)
                .pw(pw)
                .name(name)
                .characterName(characterName)
                .build();
    }
}
