package com.string.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface StringService {
    String getLongestString(List<String> stringList);

}
