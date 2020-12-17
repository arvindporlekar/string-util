package com.string.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface StringService {
    String getLongestString(List<String> stringList);

    Optional<List<String>> deleteStringHavingLengthPredict(List<String> stringList, Predicate<String> predicate);

}
