package com.mcz.docmanager.service;

import java.util.Base64;

import com.mcz.docmanager.grpc.Document.APIResponse;
import com.mcz.docmanager.grpc.Document.StoreRequest;
import com.mcz.docmanager.grpc.Document.UpdateRequest;
import com.mcz.docmanager.grpc.documentGrpc.documentImplBase;
import com.mcz.docmanager.repository.JdbcTemplate;

import io.grpc.stub.StreamObserver;

public class DocManagerService extends documentImplBase {

	private static final int HTTP_OK = 200;
	private static final int INTERNAL_SERVER_ERROR = 500;

	@Override
	public void store(StoreRequest request, StreamObserver<APIResponse> responseObserver) {
		APIResponse.Builder response = APIResponse.newBuilder();
		String document = request.getDocument();
		System.out.println("@@Store Called" + document);

		JdbcTemplate repo = new JdbcTemplate();
		try {
			String encodedDoc = Base64.getEncoder().encodeToString(document.getBytes());

			long id = repo.save(encodedDoc);
			response.setResponseCode(HTTP_OK).setResponseMessage("Doc Saved Successfully. Doc Id: " + id);
		} catch (Exception e) {
			response.setResponseCode(INTERNAL_SERVER_ERROR)
					.setResponseMessage("Problems in saving File " + e.getMessage());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void update(UpdateRequest request, StreamObserver<APIResponse> responseObserver) {
//		super.update(request, responseObserver);
		System.out.println("Update Called");
	}

}
