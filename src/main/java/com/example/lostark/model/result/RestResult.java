package com.example.lostark.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // not null only
public class RestResult {
    private String status = "200";
    private Map<String, Object> data;
    public RestResult(Map<String, Object> data) {
        this.data = data;
    }
}