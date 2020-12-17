package com.string.controller;

import com.string.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping(StringController.ROOT)
@CrossOrigin("*")
public class StringController {
    public static final String ROOT = "/secured/api/";

    @Autowired
    private StringService stringService;

    //POST api to accept a list of strings and return the longest string from it. Use streams.
    @PostMapping("v1/strings")
    public ResponseEntity<String> get(@RequestBody List<String> stringList) {
        if (CollectionUtils.isEmpty(stringList)) {
            throw new RuntimeException("invalid string.");
        }
        String output = stringService.getLongestString(stringList);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    //DELETE api to accept a list of strings and remove all the string which is having length more than 10.
    @DeleteMapping("v1/strings")
    public ResponseEntity<?> delete(@RequestBody List<String> stringList) {
        if (CollectionUtils.isEmpty(stringList)) {
            throw new RuntimeException("invalid string.");
        }

        Predicate<String> predicate = (s -> s.length() > 10);

        List<String> strings = stringService.deleteStringHavingLengthPredict(stringList, predicate).orElse(Collections.singletonList("no data found"));
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }
}
