package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8188;
        Socket clientSocket;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("New connection accepted");
                out.println("Hello, write your name please:");
                final String name = in.readLine();
                out.println("Please enter your age:");
                final int age = Integer.parseInt(in.readLine());
                if (age < 18) {
                    out.println(String.format("Welcome to the kids area, %s. Let's play!", name));
                } else {
                    out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                }
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter correct information.");
        }
    }
}