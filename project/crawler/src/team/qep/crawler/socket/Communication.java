package team.qep.crawler.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Communication{
	private static String IP = "127.0.0.1";
	private static int port = 12345;
	
	public static void main(String[] args){
		SendAndRecv("123");
	}
    public static int 	SendAndRecv(String str) {
    	   try{   
    		   //1.建立客户端socket连接，指定服务器位置及端口
               Socket socket =new Socket(IP,port);
               //2.发送信息
               OutputStream os=socket.getOutputStream();
               PrintWriter pw=new PrintWriter(os);
               pw.write(str);
               pw.flush();
               socket.shutdownOutput();
               
               //接受信息
               InputStream is=socket.getInputStream();
               BufferedReader br=new BufferedReader(new InputStreamReader(is));
               String reply=null;
               while((reply=br.readLine())!=null){
                   System.out.println("我是客户端-->服务器发送的信息："+reply);
               }
              
               
               //关闭资源
               br.close();
               is.close();
               pw.close();
               os.close();
               socket.close();
           } catch (UnknownHostException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
            return 1;
    }
}