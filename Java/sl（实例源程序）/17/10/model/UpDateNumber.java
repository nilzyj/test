package com.model;

public class UpDateNumber {
	private int number;
	static int n;

	public  int getNumber() {
		return number;
	}

	public  void setNumber(int number) {
		this.number = number;
		n=number;
	}
	public static int getN(){
		return n;
	}

}
