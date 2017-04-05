/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartkitchen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JOptionPane;

/**
 *
 * @author adamk
 */
public class KettleDiscovery {
    
    private static class SampleListener implements ServiceListener {

        @Override
        public void serviceAdded(ServiceEvent event) {
            ServiceInfo info = event.getInfo();
            int port = info.getPort();
            String serverAddress = info.getHostAddresses()[0];
            System.out.println("port = " + port + " host = " + serverAddress);
            try {
                System.out.println("Service added: " + event.getInfo());
                Socket s = new Socket(serverAddress, port);
                BufferedReader input
                        = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String answer = input.readLine();
                JOptionPane.showMessageDialog(null, answer);
            } catch (IOException ex) {
                Logger.getLogger(KettleDiscovery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
            System.out.println("Service removed: " + event.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent event) {
            System.out.println("Service resolved: " + event.getInfo());
        }
    }

    public static void main(String[] args)  {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
