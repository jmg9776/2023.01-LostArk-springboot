package com.example.lostark.thirdParty.lostArk.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
public interface LostArkApiInterface<E,F> {
    public ArrayList<E> getData(F data);
}
