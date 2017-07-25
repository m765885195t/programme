package team.qep.crawler.server;

public class Task {
	public static String[][] getRunningTask(){
		return new String[][]{{"1","www.baidu.com"},
								{"1","www.sina.cn"},
								{"2","www.csdn.cn"},
								{"3","www.taobao.cn"},
								{"3","www.tmall.cn"}};
	}
	public static boolean beginTask(String[] issueTask,int processNumber){
		
		return true;
	}
}
