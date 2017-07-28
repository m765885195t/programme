package team.qep.crawler.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import team.qep.crawler.basic.recvFlag;

//数据转换为JSON
public class ConvertJSON {
	//str转为json字符串
	public static String toJSON(int taskNumber,String content){
		JsonObject json = new JsonObject();
		json.addProperty("motian", "0");
		json.addProperty("task",String.valueOf(taskNumber));
		json.addProperty("content", content);
		return new String("["+json.toString()+"]");
	}
	//json数组字符转为string[]
	public static String[] toStringArray(String json){
		Gson gson = new Gson();  
		ArrayList<String> list = new ArrayList<String>();  
        list = gson.fromJson(json, new TypeToken<ArrayList<String>>(){}.getType());  
        return (String[])list.toArray(new String[list.size()]);
	}
	public static void main(String[] args){
		String[] str = toStringArray("[\"motian\",\"0\",\"mt\",\"110\"]");

		for(String s:str){
			System.out.println(str.toString());
		}
	}
}
