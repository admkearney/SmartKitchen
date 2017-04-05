package com.mycompany.smartkitchen;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

/**
 * Adapted from jmDNSTutorial on moodle
 * @author adamk
 */
public class KettleServer {
  
        public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(9090);
            try {
                
                // Create a JmDNS instance
                JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
                
                // Register a service
                ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "DateServer", 9090, "can't be empty?");
                jmdns.registerService(serviceInfo);
                System.out.println("Kettle service is registered");
                while (true) {
                    Socket socket = listener.accept();
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.println("Kettle is now boiling");
                        
                        
                    } finally {
                        socket.close();
                    }
                }
            } finally {
                listener.close();
            }
        }   catch (IOException ex) {
            Logger.getLogger(KettleServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
