package test;

import java.io.*;  

public class py {
	public static  void main(String args[]) throws IOException {
			new Thread(){
				public void run(){
					try {
						Runtime.getRuntime().exec("python E:\\project\\python\\1.py");
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}.start();
	}
}