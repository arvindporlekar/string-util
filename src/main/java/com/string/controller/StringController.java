package com.string.controller;

import com.string.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(StringController.ROOT)
@CrossOrigin("*")
public class StringController {
    public static final String ROOT = "/secured/api/";

    @Autowired
    private StringService stringService;

    //POST api to accept a list of strings and return the longest string from it. Use streams.
    @PostMapping("v1/strings")
    public ResponseEntity<String> get(List<String> stringList ) {
        if(CollectionUtils.isEmpty(stringList)) {
            throw new RuntimeException("invalid string.");
        }
        return new ResponseEntity<>("record is deleted successfully.", HttpStatus.OK);
    }

    //DELETE api to accept a list of strings and remove all the string which is having length more than 10.
}
