package team.qep.crawler.basic;

public class Default {
	public static int JFrameX=1000;
	public static int JFrameY=618;
	public static int JPanelX=1000;
	public static int JPanelY=568;
	public static int refreshrate=1000;
	public static int EC_News=1;
	public static int News_Blog=2;
	public static String[] taskSet = new String[]{"www.taobao.com","blog.csdn.net","1","2","3","4"};
	public static void setRefreshrate(int refresh){
		refreshrate=refresh;
	}
	public static int getRefreshrate(){
		return refreshrate;
	}
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
		return new String[]{"Url","Status"};
	}
	//默认支持的任务集
	public static String[] getDefaultUrl(){
		return taskSet;
	}
}