package team.qep.crawler.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//自定义消息提示框
public class Promptinformation {
	public static void informationprompt(JFrame jf,String content){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(jf,content, "Prompt", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,options,options[0]); 
	}
	public static void errorPrompt(JFrame jf,String content){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(jf,content, "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null,options,options[0]); 
	}
	public static void warningPrompt(JFrame jf,String content){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(jf, content, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	}
	public static int confirmPrompt(JFrame jf,String content){
		Object[] options = {"YES","NO"};
		return JOptionPane.showOptionDialog(jf, content, "confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, options, options[0]);
	}
}
