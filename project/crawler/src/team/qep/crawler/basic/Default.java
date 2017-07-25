package team.qep.crawler.basic;

public class Default {
	public static int JFrameX=1000;
	public static int JFrameY=618;
	public static int JPanelX=1000;
	public static int JPanelY=568;
	public static int processNumber=10;

	public static String getImagePath(int k){
		return "./image/"+k+".jpg";
	}
	public static String getDynamicImagePath(int k){
		return "./image/"+k+".gif";
	}
	public static String[] getTaskViewJColumnNames(){
		return new String[]{"TaskNumber","url"};
	}
}