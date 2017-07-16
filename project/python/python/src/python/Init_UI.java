package python;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


//所有UI界面的默认初始化

public class Init_UI{
	//---------窗口的初始化方式
	public static void JFrameInit(JFrame jf,String str,int x,int y){//主窗口,窗口名,窗口大小
		jf.setLayout(null);//清除布局方式
//		jf.setResizable(false);//不可改变大小
		jf.setSize(x, y);
		jf.setName(str);//设置窗口名
		jf.setTitle(str);//窗口标题
		jf.setLocationRelativeTo(null);//起始位置为屏幕中央
		jf.setUndecorated(true);//去掉标题栏
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//隐藏当前窗口，并释放窗体占有的其他资源
//		jf.setVisible(true);//窗口可见

	}



	//---------文本框的初始化
	public static void JTextFieldInit(JTextField username,String str){
//		username.setOpaque(false);//设为透明
//		username.setBorder(null);//去掉边框
		username.setFont(new Font("微软雅黑",1, 21));//设置字体格式
		username.setName(str);//设置文本框的名字
		username.setForeground(Color.black);//设置前景色为灰
		username.setBackground(Color.white);//设置背景色为白
//		username.setEditable(false);//屏蔽输入
//		username.setFocusable(false);//消除光标
//		username.setDocument(new MyDocument(16));//限制密码输入长度

	}
	//---------密码框的初始化

	//标签初始化
	public static void JLableInit(JLabel jl,String str){
		jl.setName(str);//设置文本框的名字
//		jl.setFont(new Font("serif",0,20));
		jl.setFont(new Font("微软雅黑",0,20));

		jl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//进入框为手
		jl.setForeground(Color.white);
	}
	//---------按键初始化
	public static void JButtonInit(JButton jb,String str){
		jb.setName(str);	
		jb.setFocusable(false);//消除光标
//		jb.setContentAreaFilled(false);//按键透明
//		jb.setIcon(new ImageIcon(""));//设置背景
		jb.setBorder(null);//去掉边框
	}
	//---------面板初始化
	public static void JPanelInit(JPanel jp,String str,int x,int y,int size_X,int size_Y){
//		jp.setOpaque(false);//设置面板透明
		jp.setName(str);//设置面板名
		jp.setSize(size_X,size_Y);
		jp.setLocation(x, y);

		jp.setLayout(null);//清楚面板的布局方式
	}
	//进度条初始化
	public static void JProgressBarInit(JProgressBar jpb,String str){
//		jp.setOpaque(false);
		jpb.setName(str);
		jpb.setStringPainted(true);// 设置进度条上的字符串显示，false则不能显示  
		jpb.setVisible(true);
	}
}
	

