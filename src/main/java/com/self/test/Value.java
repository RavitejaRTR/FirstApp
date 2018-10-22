package com.self.test;

public class Value {
	private String id;
	private String quote;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	@Override
	public String toString() {
		return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
	}
	
}
