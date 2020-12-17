package com.string.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StringServiceImpl implements StringService {

    @Override
    public String getLongestString(List<String> stringList) {
        if (CollectionUtils.isEmpty(stringList)) {
            throw new IllegalArgumentException("invalid string list.");
        }
        return stringList
                .stream()
                .sorted(Comparator.comparing(String::length)
                        .reversed())
                .findAny()
                .orElse("No string found.");
    }

    @Override
    public Optional<List<String>> deleteStringHavingLengthPredict(List<String> stringList, Predicate<String> predicate) {
        if (CollectionUtils.isEmpty(stringList)) {
            throw new IllegalArgumentException("invalid string list.");
        }
        return Optional.of(stringList
                .stream()
                .filter(predicate)
                .collect(Collectors.toList()));
    }


}
