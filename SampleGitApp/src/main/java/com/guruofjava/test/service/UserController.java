/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruofjava.test.service;

import com.guruofjava.test.dao.UserDAO;
import com.guruofjava.test.model.Users;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.jwt.JsonWebToken;

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

    //@Inject
    //private JsonWebToken jsonWebToken;
    @GET
    @Path("add")
    public void addUser(@QueryParam("name") String name,
            @QueryParam("email") String email, @QueryParam("password") String password) {
        
        Users temp = new Users(null, name, email, password);
        userDAO.addUser(temp);

        /*boolean createUser = jsonWebToken.getClaim("create.users");

        if (createUser) {
            Users temp = new Users(null, name, email, password);
            userDAO.addUser(temp);
        }else{
            System.out.println("########## Cannot create user");
        }*/
    }

    @GET
    @Path("all")
    //@RolesAllowed("read-users")
    @Produces("application/json")
    @Timeout(500)
    public List<Users> get() {
        return userDAO.getAllUsers();
    }
}
