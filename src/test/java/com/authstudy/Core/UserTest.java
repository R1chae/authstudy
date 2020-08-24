/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authstudy.Core;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RichardDumser
 */
public class UserTest extends TestCase {
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    void testCurrentUserFactoryAndToStringMethod(){
        String username = "user";
        String password = "password";
        String email = "mail@mail.com";
        int age = 18;
        
        StringBuilder sb = new StringBuilder("User{username=");
        sb.append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", age=").append(age);
        sb.append("}");
        String result = Core.User.currentUser(username, password, email, age).toString();
        
        assertEquals(sb.toString(), result);
    }
}
