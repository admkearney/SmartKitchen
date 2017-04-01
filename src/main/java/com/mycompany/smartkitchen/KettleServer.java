/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartkitchen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author adamk
 */
public class KettleServer {
    
     public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =new PrintWriter(socket.getOutputStream(), true);out.println("Kettle Is Now Boiling");
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }   
}
