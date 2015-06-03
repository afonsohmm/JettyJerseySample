/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afonsohmm.jettyjerseysample.client;

import java.net.URI;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.afonsohmm.jettyjerseysample.server.model.JTask;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author afonso
 */
public class JRestClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        List<URI> locations = new ArrayList<>();

        WebTarget target = client.target("http://localhost:8890").path("api").path("tasks");

        Response postResponse = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(JTask.of("Cliente de Teste 01", "Criando teste de tarefa 01", new Date())));
        locations.add(postResponse.getLocation());

        postResponse = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(JTask.of("Cliente de Teste 02", "Criando teste de tarefa 02", new Date())));
        locations.add(postResponse.getLocation());

        postResponse = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(JTask.of("Cliente de Teste 03", "Criando teste de tarefa 03", new Date())));
        locations.add(postResponse.getLocation());

        // Get na primeira tarefa
        WebTarget getTarget = client.target(locations.get(0));
        Response getResponse = getTarget.request(MediaType.APPLICATION_JSON).get();

        System.out.println("Get response: " + getResponse.getStatus());
        System.out.println("Get entity: " + getResponse.readEntity(JTask.class));

        // Update na segunda tarefa
        getTarget = client.target(locations.get(1));
        getResponse = getTarget.request(MediaType.APPLICATION_JSON).get();
        JTask aTask = getResponse.readEntity(JTask.class);
        aTask.setTitle("Update de Tarefa");
        client.target(locations.get(1)).request(MediaType.APPLICATION_JSON).put(Entity.json(aTask));

        // Delete na terceira tarefa
        client.target(locations.get(2)).request().delete();

        WebTarget allTarget = client.target("http://localhost:8890").path("api").path("tasks");

        GenericType<List<JTask>> genericType = new GenericType<List<JTask>>() {
        };

        List<JTask> all = allTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        for (JTask task : all) {
            System.out.println(task);
        }
    }

}
