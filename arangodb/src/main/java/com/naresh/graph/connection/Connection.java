package com.naresh.graph.connection;

public interface Connection<T> {
	
	public T getConnection();
	
	public void closeConnection(T connection);
	
}
