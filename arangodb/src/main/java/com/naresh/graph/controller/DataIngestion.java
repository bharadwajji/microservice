package com.naresh.graph.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.arangodb.ArangoDB;
import com.arangodb.entity.BaseDocument;
import com.naresh.graph.connection.ArangoDBConnection;

public class DataIngestion {

	public static void main(String args[]) throws IOException {

		BufferedReader br = null;
		ArangoDB arangoDB = null;
		
		try{
			br = new BufferedReader(new FileReader(new File("C:\\Users\\DELL\\Desktop\\mock_data.txt")));
			arangoDB = ArangoDBConnection.getInstance().getConnection();
			String st;
			StringBuilder builder = new StringBuilder();

			while ((st = br.readLine()) != null)
				builder.append(st);
			
			JSONParser parser = new JSONParser();
			
			Object object = parser.parse(builder.toString());
			if(object instanceof JSONArray) {
				JSONArray array = (JSONArray) object;
				
				for(int i=0;i<array.size();i++) {
					BaseDocument document = new BaseDocument();
					JSONObject jsonObject = (JSONObject) array.get(i);
					
					if(jsonObject.containsKey("_id")) {
						document.setId((String) jsonObject.get("_id"));
					}
					if(jsonObject.containsKey("_key")) {
						document.setKey((String) jsonObject.get("_key"));
					}
					
					for(Object key : jsonObject.keySet()) {
						document.addAttribute((String) key,(String) jsonObject.get((String) key));
					}
					arangoDB.db("test").collection("persons").insertDocument(document);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) {
				br.close();
			}
			if(arangoDB!=null) {
				ArangoDBConnection.getInstance().closeConnection(arangoDB);
			}
		}
	}
}
