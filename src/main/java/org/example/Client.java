package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8188;
        try (Socket clientSocket = new Socket(host, port)) {
            while (true) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String resp = in.readLine();
                System.out.println(resp);
                String name = bufferedReader.readLine();
                out.println(name);
                String resp1 = in.readLine();
                System.out.println(resp1);
                int age = Integer.parseInt(bufferedReader.readLine());
                out.println(age);
                String resp2 = in.readLine();
                System.out.println(resp2);
                return;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            System.out.println("Please enter correct information.");
        }
    }
}
