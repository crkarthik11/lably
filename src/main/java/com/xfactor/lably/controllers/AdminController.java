package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public String hello_world() {
        return "Hello world!!!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from AdminController!!!";
    }

    @GetMapping("/greet/{text}")
    public String greet(@PathVariable String text) {
        return "Greetings from " + text;
    }

    @GetMapping("/greet2")
    public String greet2(@RequestParam String name, @RequestParam String age, @RequestParam String city) {
        return "Greetings from " + " " + name + " " + age + " " + city;
    }

    @GetMapping("/greet3")
    public HashMap<String, String> greet3(@RequestParam String name, @RequestParam String age,
            @RequestParam String city) {
        HashMap<String, String> resp = new HashMap<>();
        resp.put("name", name);
        resp.put("age", age);
        resp.put("city", city);
        return resp;
    }

}