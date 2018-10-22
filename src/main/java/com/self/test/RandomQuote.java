package com.self.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RandomQuote {
	private String type;
	private Value value;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
	public String toString() {
		return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
	}
	
}
