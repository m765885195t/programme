package team.qep.crawler.util;

import java.util.ArrayList;

//字符串转换工具
public class Operationstring {
	public static String[] splitString(String string){
		return null;
	}
	//从正在运行的任务中提取链接
	public static String[] extractString(String[][] string){
		ArrayList<String> strlist = new ArrayList<String>();
		for(int i=0 ; i<string.length ; i++){
			strlist.add(string[i][1]);
		}
		
		return (String[])strlist.toArray(new String[strlist.size()]);
	}
	public static String[] differenceString(String[] string,String[] string2){
		return null;
	}
	public static void main(String[] args){
		String[][] a =  new String[][]{{"1","www.baidu.com"},
			{"2","www.sina.cn"},
			{"3","www.csdn.cn"},
			{"4","www.taobao.cn"},
			{"5","www.tmall.cn"}};
			String[] b= extractString(a);
			for(int i=0 ; i<b.length ; i++){
				System.out.println(b[i]);
			}
	}
}
