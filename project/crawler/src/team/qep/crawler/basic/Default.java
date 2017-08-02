package team.qep.crawler.basic;

public class Default {
	public static int JFrameX=1000;
	public static int JFrameY=618;
	public static int JPanelX=1000;
	public static int JPanelY=568;
	public static String[] taskSet = new String[]{"www.taobao.com","blog.csdn.net","1","2","3"};
	public static String getImagePath(int k){
		return "./image/"+k+".jpg";
	}
	public static String getDynamicImagePath(int k){
		return "./image/"+k+".gif";
	}
	public static String getDynamicIconPath(String path){
		return "./image/"+path+".png";
	}
	public static String[] getTaskViewJColumnNames(){
		return new String[]{"Task","Url"};
	}
	//默认支持的任务集
	public static String[] getDefaultUrl(){
		return taskSet;
	}
}