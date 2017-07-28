package team.qep.crawler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import team.qep.crawler.basic.Default;

//字符串转换工具
public class Operationstring {
	//将输入的任务集分割成字符数组
	public static String[] splitString(String string){
		ArrayList<String> strlist = new ArrayList<String>();
        String str[] = string.split("\n");
        for(int i=0 ; i<str.length ; i++){
        	String tem = str[i].replace(" ", "");
        	if(!tem.equals("")){
        		strlist.add(tem);
        	}
        }
		return (String[])strlist.toArray(new String[strlist.size()]);
	}
	//从正在运行的任务中提取url
	public static String[] extractString(String[][] string){
		if(string != null){
			ArrayList<String> strlist = new ArrayList<String>();
			for(int i=0 ; i<string.length ; i++){
				strlist.add(string[i][1]);
			}
			return (String[])strlist.toArray(new String[strlist.size()]);
		}else{
			System.out.println("das");
			return new String[]{};
		}
	}
	//得到正确的发布任务
	public static String[] differenceString(String[] string1,String[] string2){
		String[] defaultTask = Default.getDefaultUrl();
		ArrayList<String> strlist = new ArrayList<String>();
		
		for(int i=0 ; i<string1.length ; i++){
			//添加成功的url一定在默认任务集中，且不能在正在运行的任务中，格式一定要完整正确
			if(!inTheArray(string2,string1[i]) && inTheArray(defaultTask, string1[i])){
				strlist.add(string1[i]);
			}
		}
		
		if(!strlist.isEmpty()){
			return (String[])strlist.toArray(new String[strlist.size()]);
		}
		return null; 
	}
	//判断字符串数组中是否有某个字符串
	public static boolean inTheArray(String[] str,String string) {
		List<String> list=Arrays.asList(str);
		if(list.contains(string)){
			return true;
		}
		return false;
	}
	//返回该字符串在字符串数组中的下标
	public static int getIndex(String[] str,String string) {
		for(int i=0 ; i<str.length ; i++){
			if(str.equals(string)){
				return i;
			}
		}
		return -1;
	}
	//将字符数组转换为长字符串
	public static String toLangString(String[] str) {
		StringBuilder string = new StringBuilder();
		for(int i=0 ; i<str.length ; i++){
			string.append(str[i]+" ");
		}
		return string.toString();
	}
}
