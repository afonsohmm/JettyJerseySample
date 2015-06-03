/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afonsohmm.jettyjerseysample.server.rest;

import com.afonsohmm.jettyjerseysample.server.model.JTask;
import java.util.ArrayList;
import java.util.HashMap;  
import java.util.List;
import java.util.Map;  
import java.util.Optional;  
/**
 *
 * @author afonso
 */
public class JTaskCache {  
    
    private static JTaskCache instance;
    
    public static JTaskCache getInstance(){
        if(instance == null)
            instance = new JTaskCache();
        return instance;
    }
      
    private Map<String, JTask> tasks;  
  
    private JTaskCache() {  
        tasks = new HashMap<>();  
    }  
      
    public Optional<JTask> getTask(String id) {  
        return Optional.ofNullable(tasks.get(id));  
    }  
      
    public void putTask(JTask task) {  
        tasks.put(task.getId(), task);  
    }  
      
    public void removeTask(JTask task) {  
        tasks.remove(task.getId());  
    }  
      
    public List<JTask> getTasks() {  
        return new ArrayList(tasks.values());  
    }  
    
}
