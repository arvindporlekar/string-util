package com.string.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringServiceImpl implements StringService {

    @Override
    public String getLongestString(List<String> stringList) {
        if(CollectionUtils.isEmpty(stringList)) {
            throw new IllegalArgumentException("invalid string list.");
        }


        return stringList
                .stream()
                .sorted(Comparator.comparing(String::length).reversed()).findAny().orElse("");
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("arvind");
        test.add("arvind arvind");
        test.add("arvind arvind arvind");
        test.add("arvind arvind arvind arvind");

        System.out.println(test
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findAny()
                .orElse(""));
    }
}
