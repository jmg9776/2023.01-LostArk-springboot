package com.example.lostark.model.param;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class RefreshExpeditionParam {
    private String name;
    private Long uid;
}
