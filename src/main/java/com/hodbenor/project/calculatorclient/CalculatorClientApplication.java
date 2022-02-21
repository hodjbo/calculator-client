package com.hodbenor.project.calculatorclient;

import com.hodbenor.project.calculatorclient.service.ClientCalculatorThread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalculatorClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication
				.run(CalculatorClientApplication.class, args);
		ctx.close();
	}
}