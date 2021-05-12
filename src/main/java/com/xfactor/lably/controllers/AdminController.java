package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.xfactor.lably.entity.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();

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

    @GetMapping("/register")
    public Admin register(@RequestParam String name, @RequestParam String username, @RequestParam String password,
            @RequestParam String department) {
        // HashMap<String, String> resp = new HashMap<>();
        // resp.put("name", name);
        // resp.put("username", username);
        // resp.put("password", password);
        // resp.put("department", department);
        // return resp;
        Admin admin1 = new Admin();
        admin1.setName(name);
        admin1.setUsername(username);
        admin1.setPassword(password);
        admin1.setDepartment(department);
        return admin1;
    }

    @PostMapping("/registerAdmin")
    public Admin registerPost(@RequestBody Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        // Save admin to db
        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAllAdmins")
    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    @GetMapping("/getAdminByUserName")
    public Admin getAdminByUserName(@RequestParam String username) {
        Admin resAdmin = null;
        for (Admin admin : admins) {
            if (admin.getUsername().equalsIgnoreCase(username)) {
                resAdmin = admin;
            }
        }
        return resAdmin;
    }

}