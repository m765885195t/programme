package team.qep.crawler.server;

import java.util.ArrayList;
import java.util.Random;

import team.qep.crawler.basic.Default;
import team.qep.crawler.socket.Communication;
import team.qep.crawler.socket.Download;
import team.qep.crawler.util.ConvertJSON;
import team.qep.crawler.util.Operationstring;

public class Data {
	//刷新数据  得到数据爬取量生成折线图
	public static String[][] refreshData(int taskNumber){
		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber,""));
		String[] str = ConvertJSON.toStringArray(flag);
		
		ArrayList<String[]> list = new ArrayList<String[]>();
		for(int i=1 ; i<str.length; i+=4){
			list.add(new String[]{str[i+1],"E-Commerce",str[i]});
			list.add(new String[]{str[i+2],"News",str[i]});
			list.add(new String[]{str[i+3],"Blog",str[i]});
		}
//		
//		Random a = new Random();
//		ArrayList<String[]> list = new ArrayList<String[]>();
//		for(int i=0 ; i<9; i++){
//			list.add(new String[]{String.valueOf(i*a.nextInt()),"E-Commerce","07/18 "+String.valueOf(i*2+10)+":00"});
//			list.add(new String[]{String.valueOf(i*a.nextInt()),"News","07/18 "+String.valueOf(i*2+10)+":00"});
//			list.add(new String[]{String.valueOf(i*a.nextInt()),"Blog","07/18 "+String.valueOf(i*2+10)+":00"});
//		}
//		
		String[][] A = new String[list.size()][3];
		for(int i=0 ; i<list.size() ; i++){
			for(int j=0 ; j<3 ; j++){
				A[i][j] = list.get(i)[j];
			}
		}
		return A;
	}
	
	//清空数据
	public static boolean emptyData(int taskNumber,int urlstart,int urlend){//url起止范围
//		String flag = Communication.SendAndRecv(ConvertJSON.toJSON(taskNumber,""));
//		String[] str = ConvertJSON.toStringArray(flag);
//		if(str[1].equals("0")){
//			return false;
//		}
		return true;
	}
	
	//下载数据
	public static boolean downloadData(int taskNumber,int select,String pathName){//可选择下载那个类别
		if(Download.download(ConvertJSON.toJSON(taskNumber,""),pathName)){
			return true;
		}
		return false;
	}
	
}
