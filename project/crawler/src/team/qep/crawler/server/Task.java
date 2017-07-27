package team.qep.crawler.server;

public class Task {
	public static String[][] getRunningTask(){
		return new String[][]{{"1","www.baidu.com"},
								{"2","www.sina.cn"},
								{"3","www.csdn.cn"},
								{"4","www.taobao.cn"},
								{"5","www.tmall.cn"}};
//								return null;
	}
	public static boolean beginTask(String[] issueTask,int processNumber){
		
		return true;
	}
}
