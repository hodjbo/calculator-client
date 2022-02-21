package com.hodbenor.project.calculatorclient.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

@Slf4j
public class ClientKeepAliveThread extends Thread {
    private final String host;
    private final int port;
    ClientKeepAliveThread(String host, int port) {
        this.host = host;
        this.port = port;
    }
    @Override
    public void run() {
        try (Socket socket = new Socket(host, port);
             Scanner scannerServer = new Scanner(socket.getInputStream());
        ) {
            while (true) {
                String input = scannerServer.nextLine();
                System.out.println(input);
            }
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
