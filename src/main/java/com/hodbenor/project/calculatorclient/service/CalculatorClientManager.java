package com.hodbenor.project.calculatorclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CalculatorClientManager {
    private String host;
    private int calcPort;
    private int keepAlivePort;
    public CalculatorClientManager(@Value("${host.ip}") String host,
                                   @Value("${host.calc.port}") int calcPort,
                                   @Value("${host.keepalive.port}") int keepAlivePort) {
        this.host = host;
        this.calcPort = calcPort;
        this.keepAlivePort = keepAlivePort;
    }

    @PostConstruct
    private void startServer() {
        ClientCalculatorThread clientCalculatorThread = new ClientCalculatorThread(host, calcPort);
        clientCalculatorThread.start();
        ClientKeepAliveThread clientThread = new ClientKeepAliveThread(host, keepAlivePort);
        clientThread.start();
    }
}
