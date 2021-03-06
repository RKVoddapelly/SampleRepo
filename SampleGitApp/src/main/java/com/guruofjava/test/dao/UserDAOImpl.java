/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruofjava.test.dao;

import com.guruofjava.test.model.Users;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author ArshiaAziz
 */
@Named
@ApplicationScoped
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;
    
    @ConfigProperty(name = "max.users.per.page",defaultValue = "4")
    private int maxUsers;
    
    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u")
                .setMaxResults(maxUsers)
                .getResultList();
    }

    @Override
    public void addUser(Users user) {
        entityManager.persist(user);
    }
    
    
}
