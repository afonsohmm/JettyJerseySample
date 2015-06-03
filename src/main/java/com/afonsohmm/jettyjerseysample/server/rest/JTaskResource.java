/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afonsohmm.jettyjerseysample.server.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.afonsohmm.jettyjerseysample.server.model.JTask;
import java.net.URI;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author afonso
 */
@Path("tasks")
public class JTaskResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JTask> getAll() {       
        return JTaskCache.getInstance().getTasks();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JTask task) {
        JTaskCache.getInstance().putTask(task);
        URI id = URI.create("tasks/" + task.getId());
        Response resp = Response.created(id).build();
        return resp;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getTask(@PathParam("id") String id) {
        Optional<JTask> task = JTaskCache.getInstance().getTask(id);
        Response resp = null;
        if (task.isPresent()) {
            resp = Response.ok(task.get()).build();
        } else {
            resp = Response.noContent().build();
        }
        return resp;
    }
    
    @PUT @Consumes(MediaType.APPLICATION_JSON)  
    @Path("{id}")  
    public Response update(JTask task) {  
        // Just replace the one there  
        System.out.println("Updating task: " + task);  
        JTaskCache.getInstance().putTask(task);  
        return Response.ok().build();  
    }  
      
    @DELETE  
    @Path("{id}")  
    public Response delete(@PathParam("id") String id) {  
        System.out.println("Deleting task: " + id);  
        Optional<JTask> task = JTaskCache.getInstance().getTask(id);
        JTaskCache.getInstance().removeTask(task.get());  
        return Response.ok().build();  
    }  
}
