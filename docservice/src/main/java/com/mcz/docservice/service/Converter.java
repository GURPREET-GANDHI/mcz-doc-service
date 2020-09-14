package com.mcz.docservice.service;

import java.io.IOException;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

@Service
public class Converter {

	private static final String CSV_TYPE = "CSV";
	private static final String XML_TYPE = "XML";

	public String convert(String json, String type) throws JSONException, IOException {
		String convertedFile = null;
		if (XML_TYPE.equalsIgnoreCase(type)) {

			convertedFile = convertToXML(json, "root");
			return convertedFile;

		} else if (CSV_TYPE.equalsIgnoreCase(type)) {

			convertedFile = convertToCSV(json);
			return convertedFile;

		}
		System.out.println("@@ Type" + type + "@@ DATA:");
		System.out.println(convertedFile);
		return null;
	}

	private String convertToCSV(String json) throws IOException {
		JSONObject jsonObject = new JSONObject(json);
		JSONArray docs = jsonObject.getJSONArray("file");
		String csv = CDL.toString(docs);
		return csv;

	}

	private String convertToXML(String json, String root) throws JSONException {
		JSONObject jsonObject = new JSONObject(json);
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<" + root + ">" + XML.toString(jsonObject)
				+ "</" + root + ">";
		return xml;
	}

}
