/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afonsohmm.jettyjerseysample.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author afonso
 */
@Path("hello")  
public class JHelloResource {
    @GET @Produces("text/plain")  
    public String sayHello() {  
        return "Olá a partir do Resource!";  
    }  
    
}
