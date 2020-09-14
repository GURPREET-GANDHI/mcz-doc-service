package com.mcz.docmanager.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mcz.docmanager.service.DocManagerService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication(scanBasePackages = "com.mcz.*")
public class DocmanagerApplication implements CommandLineRunner {

	@Value("${grpc.server.port}")
	private String grpcPort;

	public static void main(String[] args) {
		SpringApplication.run(DocmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("starting GRPC Server");
		Server server = ServerBuilder.forPort(Integer.parseInt(grpcPort)).addService(

				new DocManagerService()).build();

		server.start();
		System.out.println("server started at " + server.getPort() + "@@:" + grpcPort);
		server.awaitTermination();
	}

}
