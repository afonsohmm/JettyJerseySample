/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afonsohmm.jettyjerseysample.server.model;

import java.util.Date;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afonso
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JTask {

    private String id;
    private String title;
    private String description;
    private Date dueDate;

    public JTask() {
    }

    public static JTask of(String title, String description, Date dueDate) {
        UUID randomUUID = UUID.randomUUID();
        return new JTask(randomUUID.toString(), title, description, dueDate);
    }

    private JTask(String id, String title, String description, Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    

}
