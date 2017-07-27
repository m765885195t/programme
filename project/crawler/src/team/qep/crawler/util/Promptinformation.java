package team.qep.crawler.util;

import javax.swing.JOptionPane;

//自定义消息提示框
public class Promptinformation {
	public static void informationprompt(String content){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null,content, "Prompt", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,options,options[0]); 
	}
	public static void errorPrompt(String content){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null,content, "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null,options,options[0]); 
	}
	public static void warningPrompt(String content){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null, content, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	}
	public static int confirmPrompt(String content){
		Object[] options = {"YES","NO"};
		return JOptionPane.showOptionDialog(null, content, "confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, options, options[0]);
	}
}
