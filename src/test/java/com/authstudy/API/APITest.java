/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authstudy.API;

import API.API;
import Core.User;
import Infrastructure.IInfrastructure;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
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
    void testLoginAndGetUserMethod() throws Exception {
        User fakeUser = mock(User.class);
        API api = spy(new API(infra));
        when(infra.login(anyString(), anyString())).thenReturn(fakeUser);
        api.postLoginController("", "");
        verify(infra).login(anyString(), anyString());

        User result = api.getUserInfoController();
        assertEquals(fakeUser, result);
    }

    @Test
    void testRegistrationMethod() throws SQLException {
        API spy = spy(new API(infra));
        doNothing().when(infra).register(anyString(), anyString(), anyString(), anyInt());
        spy.postUserInfoController("","","",0);
        
        User result = spy.getUserInfoController();
        assertEquals("User{username=, password=, email=, age=0}", result.toString());
    }
    
    @Test
    void testGetUserMethod(){
        User fakeUser = mock(User.class);
        API spy = spy(new API(infra, fakeUser));
        User result = spy.getUserInfoController();
        assertEquals(fakeUser, result);
    }
}
