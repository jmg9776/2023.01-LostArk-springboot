package com.example.lostark.model.result;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public class RestResultBuilder {
    public RestResult resultBuilder(String name, Object data) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(name, data);
        return new RestResult(result);
    }
}
