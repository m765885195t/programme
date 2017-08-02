package team.qep.crawler.server;

import java.util.ArrayList;

import team.qep.crawler.basic.Default;
import team.qep.crawler.socket.Communication;
import team.qep.crawler.util.ConvertJSON;
import team.qep.crawler.util.Operationstring;

public class Task {
	//得到正在运行的任务集
	public static String[][] getRunningTask(int taskNumber){
//		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber,""));
//		String[] str = ConvertJSON.toStringArray(flag);
//		ArrayList<String[]> list = new ArrayList<String[]>();
//		for(int i=1 ; i<str.length ; i++){
//			list.add(new String[]{String.valueOf(i),Default.taskSet[Integer.valueOf(str[i])]});
//		}
//		String[][] A= new String[list.size()][2];
//		for(int i=0 ; i<list.size() ; i++){
//			for(int j=0 ; j<2 ; j++){
//				A[i][j] = list.get(i)[j];
//			}
//		}
//		return A;
		System.out.println("1");
//		return new String[][]{{"1","blog.csdn.net"}};
		return new String[][]{};
	}
	//发布任务集
	public static boolean beginTask(int taskNumber,String[] taskSet){
		System.out.println("2");
		StringBuilder S = new StringBuilder();
		for(int i=0 ; i<taskSet.length ; i++){
			S.append(Operationstring.getIndex(Default.getDefaultUrl(), taskSet[i])+",");
		}
		System.out.println(ConvertJSON.toJSON(taskNumber, 	Operationstring.deleteLastChar(S.toString(),','))+"转换后的发布url集");
		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber, 	Operationstring.deleteLastChar(S.toString(),',')));
		String[] str = ConvertJSON.toStringArray(flag);
		if(str[1].equals("0")){
			return false;
		}
		return true;
	}
	
	//终止任务
	public static boolean endTask(int taskNumber,String string){
		System.out.println("3");

		System.out.println(ConvertJSON.toJSON(taskNumber,String.valueOf(Operationstring.getIndex(Default.getDefaultUrl(), string)))+"转换后的终止任务");

		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber,String.valueOf(Operationstring.getIndex(Default.getDefaultUrl(), string))));
		String[] str = ConvertJSON.toStringArray(flag);
		if(str[1].equals("0")){
			return false;
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println("4");

		endTask(15,"www.taobao.com");
	}
}
