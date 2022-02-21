package com.hodbenor.project.calculatorclient.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

@Slf4j
public class ClientCalculatorThread extends Thread {
    private final String host;
    private final int port;
    ClientCalculatorThread(String host, int port) {
        this.host = host;
        this.port = port;
    }
    @Override
    public void run() {
        /*
         * start 3 sec after object construct to verify that the application upload complete
         */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            try (Socket socket = new Socket(host, port);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             Scanner scannerServer = new Scanner(socket.getInputStream());
             Scanner scannerClient = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("insert operation:");
                String input = scannerClient.nextLine();
                printWriter.println(input);
                if (input.equalsIgnoreCase("exit")) break;
                System.out.println("Answer:" + scannerServer.nextLine());
            }
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        System.out.println("bye-bye");
    }
}
