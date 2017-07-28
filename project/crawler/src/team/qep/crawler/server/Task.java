package team.qep.crawler.server;

import java.util.ArrayList;

import team.qep.crawler.basic.Default;
import team.qep.crawler.socket.Communication;
import team.qep.crawler.util.ConvertJSON;
import team.qep.crawler.util.Operationstring;

public class Task {
	//得到正在运行的任务集
	public static String[][] getRunningTask(int taskNumber){
		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber,""));
		String[] str = ConvertJSON.toStringArray(flag);
		ArrayList<String[]> list = new ArrayList<String[]>();
		if(str.length!=1){
			for(int i=1 ; i<str.length ; i++){
				System.out.println(str[i]);
				list.add(new String[]{String.valueOf(i+1),Default.taskSet[Integer.valueOf(str[i])]});
			}
			String[][] A= new String[list.size()][2];
			for(int i=0 ; i<list.size() ; i++){
				for(int j=0 ; j<2 ; j++){
					A[i][j] = list.get(i)[j];
				}
			}
			return A;
		}
		return null;
	}
	//发布任务集
	public static boolean beginTask(int taskNumber,String[] taskSet){
		StringBuilder S = new StringBuilder();
		for(int i=0 ; i<taskSet.length ; i++){
			S.append(Operationstring.getIndex(Default.getDefaultUrl(), taskSet[i])+",");
		}
		System.out.println(S.toString()+"asdasd");
		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber, S.toString()));
		String[] str = ConvertJSON.toStringArray(flag);
		if(str[1].equals("0")){
			return false;
		}
		return true;
	}
	//删除任务
	public static boolean endTask(int taskNumber,String string){
		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber, string));
		String[] str = ConvertJSON.toStringArray(flag);
		if(str[1].equals("0")){
			return false;
		}
		return true;
	}
}
