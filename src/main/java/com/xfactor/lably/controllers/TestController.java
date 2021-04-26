package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // http://localhost:8080/test/hello
    @RequestMapping("/hello")
    public String index() {
        return "Greetings from XFACTOR!!!";
    }

    // http://localhost:8080/test/hello/xfactor
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String index_greetings(@PathVariable String name) {
        return "Greetings :" + name;
    }

    // http://localhost:8080/test/hello2?id=16
    @GetMapping("/hello2")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }

}
