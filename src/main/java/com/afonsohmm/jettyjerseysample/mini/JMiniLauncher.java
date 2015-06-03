/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afonsohmm.jettyjerseysample.mini;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 *
 * @author afonso
 */
public class JMiniLauncher {

    public static void main(String[] args) throws Exception {
        int port = 8889;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }
        Server server = new Server(port);
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(JHelloServlet.class, "/hello");
        server.setHandler(handler);

        server.start();
        server.join();
    }

}
