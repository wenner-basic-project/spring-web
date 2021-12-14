package com.wenner.it.springweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WennerController {

    @RequestMapping
    public String sayHi() {
        return "hello!";
    }
}
