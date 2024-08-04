package com.demo.spring;

public class Lunchbox {
	private String item1;
	private String item2;

	public Lunchbox() {
		super();
	}

	public Lunchbox(String item1, String item2) {
		super();
		this.item1 = item1;
		this.item2 = item2;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

}
