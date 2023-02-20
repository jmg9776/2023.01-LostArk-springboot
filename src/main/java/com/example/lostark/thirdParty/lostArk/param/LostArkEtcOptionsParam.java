package com.example.lostark.thirdParty.lostArk.param;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class LostArkEtcOptionsParam {
    int firstOption;
    int secondOption;
    int minValue;
}
