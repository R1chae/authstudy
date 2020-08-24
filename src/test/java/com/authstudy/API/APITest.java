/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authstudy.API;

import API.API;
import Core.User;
import Infrastructure.IInfrastructure;
import Infrastructure.RegistrationFailedException;
import java.util.UUID;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author RichardDumser
 */
@SpringBootTest(classes = API.class)
public class APITest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @MockBean
    private IInfrastructure infra;

    @Test
    void testLoginMethod() throws Exception {
        User fakeUser = mock(User.class);
        API api = spy(new API(infra));
        
        when(infra.login(anyString(), anyString())).thenReturn(fakeUser);
        String result = api.postLoginController("", "");
        verify(infra).login(anyString(), anyString());
        
        assertEquals("logged in as: " + fakeUser.getUsername(), result);
    }

    @Test
    void testRegistrationMethod(){
        API spy = spy(new API(infra));
        UUID uuid = UUID.randomUUID();
        UUID result = null;
        try{
            doNothing().when(infra).register(any());
            result = spy.postUserInfoController("@","user","password",18,uuid);
        } catch (RegistrationFailedException e){
            System.out.println("Registration failed");
        }
        assertEquals(uuid, result);
    }
    
    @Test
    void testGetUserMethod(){
        User fakeUser = mock(User.class);
        API spy = spy(new API(infra, fakeUser));
        User result = spy.getUserInfoController();
        assertEquals(fakeUser, result);
    }
}
