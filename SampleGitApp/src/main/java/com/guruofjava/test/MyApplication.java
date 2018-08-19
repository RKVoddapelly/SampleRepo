/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruofjava.test;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 * @author ArshiaAziz
 */
//@LoginConfig(authMethod = "MP-JWT", realmName = "admin-realm")
@ApplicationScoped
@ApplicationPath("/")
public class MyApplication extends Application{
    public MyApplication(){
        super();
    }
}
