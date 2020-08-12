/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authstudy.authstudy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RichardDumser
 */
@RestController
public class API {
 
    @GetMapping("/GetUserInformation")
    public String getUserInfoController() {
        Core.User user = new Core.User("admin", "admin", "admin@admin.com", 4);
        return ("E-Mail: " + user.getEmail() + "</br>" + "Username: " + user.getUsername() + "</br>" + "Password: " + user.getPassword());
    }
    
    @PostMapping("/RegisterNewUser")
    public String postUserInfoController() {
        return "not implemented";
    }
    
    @PostMapping("/UserAuthentication")
    public String postLoginController() {
        return "not implemented";
    }
}