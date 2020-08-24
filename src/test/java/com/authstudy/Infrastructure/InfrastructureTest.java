/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authstudy.Infrastructure;

import Core.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author RichardDumser
 */
public class InfrastructureTest extends TestCase {
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    void testLoginMethod() throws SQLException{
        String user = "user";
        String pass = "password";
        String email = "mail@mail";
        int age = 18;
        
        ApplicationContext context = new AnnotationConfigApplicationContext(Infrastructure.Mapping.class);
        Infrastructure.IInfrastructure infra = spy((Infrastructure.IInfrastructure) context.getBean("infraBean"));
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockRs = mock(ResultSet.class);
        
        infra.setCon(mockConnection);
        doNothing().when(infra).connect();
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockRs);
        when(mockRs.getString("username")).thenReturn(user);
        when(mockRs.getString("password")).thenReturn(pass);
        when(mockRs.getString("email")).thenReturn(email);
        when(mockRs.getInt("age")).thenReturn(age);
        when(mockRs.next()).thenReturn(true).thenReturn(false);
        
        System.out.println(infra.login(user, pass).toString());
    }
    
    /*@Test
    void testRegisterMethod() throws SQLException{
        Core.User fakeUser = mock(User.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(Infrastructure.Mapping.class);
        Infrastructure.IInfrastructure infra = spy((Infrastructure.IInfrastructure) context.getBean("infraBean"));
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        
        infra.setCon(mockConnection);
        doNothing().when(infra).connect();
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeUpdate(anyString())).thenReturn(0);
        
        infra.register(fakeUser);
    }*/
}
