package com.naresh.graph.controller;

import java.util.List;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.velocypack.VPackSlice;
import com.naresh.graph.connection.ArangoDBConnection;

public class RelationFinder {

	public void findRelationHierarchy(String sourceName, String destination) {

		ArangoDB arangoDB = null;
		try {
			arangoDB = ArangoDBConnection.getInstance().getConnection();
			String query = "FOR v, e IN ANY SHORTEST_PATH '" + sourceName + "' TO '" + destination
					+ "' GRAPH 'knows_graph' RETURN [v._key, e._key]";

			ArangoCursor<VPackSlice> cursor = arangoDB.db("test").query(query, null, null, VPackSlice.class);

			List<VPackSlice> list = cursor.asListRemaining();

			if (list.isEmpty()) {
				System.out.println("No Path Exist");
			} else {
				System.out.println("Path Exist with " + (list.size() - 1));
			}
		} finally {
			if (arangoDB != null) {
				ArangoDBConnection.getInstance().closeConnection(arangoDB);
			}
		}

	}

	public static void main(String args[]) {
		RelationFinder finder = new RelationFinder();
		finder.findRelationHierarchy("persons/569374", "persons/568681");
	}

}
