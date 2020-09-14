package com.mcz.docservice.web;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mcz.docmanager.grpc.Document.APIResponse;
import com.mcz.docmanager.grpc.Document.StoreRequest;
import com.mcz.docmanager.grpc.documentGrpc;
import com.mcz.docmanager.grpc.documentGrpc.documentBlockingStub;
import com.mcz.docservice.service.Converter;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@RestController("mcz-secure-docs")
public class DocserviceWeb {

	private static final int http_ok = 200;

	@Autowired
	private Converter convertor;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/read/{id}")
	public String readDoc(@PathVariable String id) throws Exception {

		logger.info("requested doc" + id);
		RestTemplate restCall = new RestTemplate();
		ResponseEntity<String> docData = restCall.getForEntity("http://localhost:8080/read/" + id, String.class);
		if (docData.getStatusCodeValue() != http_ok) {
			System.out.println("@@" + docData.getStatusCodeValue());
			throw new Exception("Read Not avaialabe, please try later");
		}
		return docData.getBody();

	}

	@PostMapping("/store/fileType/{fileType}")
	public String store(@PathVariable(required = true) String fileType, @RequestBody(required = true) String document)
			throws Exception {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		document = convertor.convert(document, fileType);
		if (Objects.isNull(document)) {
			throw new Exception("Invalid data, please read documentation");
		}
		documentBlockingStub docStub = documentGrpc.newBlockingStub(channel);
		StoreRequest storeRequest = StoreRequest.newBuilder().setDocument(document).build();
		APIResponse response = docStub.store(storeRequest);

		System.out.println("@@ Response Code" + response.getResponseCode());
		System.out.println("@@ Response Message" + response.getResponseMessage());

		return response.getResponseMessage();
	}

	@PostMapping("/update/{id}")
	public String update(@RequestBody(required = true) String document) {

		return document;
	}
}
