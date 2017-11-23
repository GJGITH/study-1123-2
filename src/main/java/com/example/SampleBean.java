package com.example;

import org.springframework.stereotype.Component;

@Component//在合适的地方找写好的bean 
public class SampleBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SampleBean [name=" + name + "]";
	}

	/**
	 * 什么时候用@Component
	 */
}
