/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruofjava.test.service;

import com.guruofjava.test.dao.UserDAO;
import com.guruofjava.test.model.Users;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ArshiaAziz
 */
@Path("/")
@RequestScoped
@Transactional
public class UserController {
    @Inject
    private UserDAO userDAO;
    
    @GET
    @Path("add")
    public void addUser(@QueryParam("name")String name,
            @QueryParam("email")String email, @QueryParam("password")String password){
        Users temp = new Users(null, name, email, password);
        userDAO.addUser(temp);
    }
    
    @GET
    @Path("all")
    @Produces("application/json")
    public List<Users> get(){
        return userDAO.getAllUsers();
    }
}
