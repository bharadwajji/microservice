package com.naresh.graph.connection;

import com.arangodb.ArangoDB;

public class ArangoDBConnection implements Connection<ArangoDB> {

	private static final ArangoDBConnection arangoDBConnection = new ArangoDBConnection();
	
	private ArangoDBConnection() {
		
	}
	
	public static ArangoDBConnection getInstance() {
		return arangoDBConnection;
	}
	
	public ArangoDB getConnection() {
		return new ArangoDB.Builder().host("localhost", 8529).user("root").password("ilovepapa12?").build();
	}

	public void closeConnection(ArangoDB arangoDB) {
		arangoDB.shutdown();
	}

}
