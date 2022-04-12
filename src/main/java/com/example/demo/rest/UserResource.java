package com.licenta.tmmbackend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skimanagement/api/v1")
public class UserResource {

    //TODO sa pun numele aplicatiei

    @GetMapping("/user")
    public String helloUser(){
        return "Welcome to APP NAME";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String securedUser(){
        return "Welcome admin ";

    }
}
