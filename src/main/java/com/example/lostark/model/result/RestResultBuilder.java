package com.example.lostark.model.result;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public class RestResultBuilder<T extends Class> {

    private final T target;
    private final String name;
    private final ModelMapper modelMapper = new ModelMapper();

    public Map<String, Object> resultBuilder(Object data) {
        final Object mapper = modelMapper.map(data, target);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(name, mapper);
        return result;
    }

    public Map<String, Object> listResultBuilder(List<Object> dataList) {
        Object temp;
        Map<String, Object> result = new LinkedHashMap<>();
        List<Object> arrayList = new ArrayList<>();
        dataList = (List<Object>) dataList.get(0);

        for (int i=0;i<dataList.size();i++) {
            temp = modelMapper.map(dataList.get(i), target);
            arrayList.add(temp);
        }
        result.put(name, arrayList);
        return result;
    }
}
