package com.wsy;

public class Usecase3 extends Thread{

	public void run(){
		while(true){
		System.out.println("test");
		try{
			Thread.sleep(100);
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	public static void main(String[] args) {
		new Usecase3().start();

	}

}
