package com.naresh.graph.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.arangodb.ArangoDB;
import com.naresh.graph.connection.ArangoDBConnection;
import com.naresh.graph.edges.MyEdge;

public class EdgeInsertion {

	public static void main(String args[]) throws IOException {

		BufferedReader br = null;
		ArangoDB arangoDB = null;

		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\DELL\\Desktop\\edge.txt")));
			arangoDB = ArangoDBConnection.getInstance().getConnection();
			String st;
			StringBuilder builder = new StringBuilder();

			while ((st = br.readLine()) != null)
				builder.append(st);

			JSONParser parser = new JSONParser();

			Object object = parser.parse(builder.toString());
			if (object instanceof JSONArray) {
				JSONArray array = (JSONArray) object;
				for (int i = 0; i < array.size(); i++) {
					JSONObject jsonObject = (JSONObject) array.get(i);
					MyEdge edge = new MyEdge((String) jsonObject.get("_from"), (String) jsonObject.get("_to"),
							(String) jsonObject.get("vertex"));
					arangoDB.db("test").graph("knows_graph").edgeCollection("knows").insertEdge(edge);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
			if (arangoDB != null) {
				ArangoDBConnection.getInstance().closeConnection(arangoDB);
			}
		}
	}
}
