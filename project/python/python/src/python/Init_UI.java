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


//����UI�����Ĭ�ϳ�ʼ��

public class Init_UI{
	//---------���ڵĳ�ʼ����ʽ
	public static void JFrameInit(JFrame jf,String str,int x,int y){//������,������,���ڴ�С
		jf.setLayout(null);//������ַ�ʽ
//		jf.setResizable(false);//���ɸı��С
		jf.setSize(x, y);
		jf.setName(str);//���ô�����
		jf.setTitle(str);//���ڱ���
		jf.setLocationRelativeTo(null);//��ʼλ��Ϊ��Ļ����
		jf.setUndecorated(true);//ȥ��������
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ص�ǰ���ڣ����ͷŴ���ռ�е�������Դ
//		jf.setVisible(true);//���ڿɼ�

	}



	//---------�ı���ĳ�ʼ��
	public static void JTextFieldInit(JTextField username,String str){
//		username.setOpaque(false);//��Ϊ͸��
//		username.setBorder(null);//ȥ���߿�
		username.setFont(new Font("΢���ź�",1, 21));//���������ʽ
		username.setName(str);//�����ı��������
		username.setForeground(Color.black);//����ǰ��ɫΪ��
		username.setBackground(Color.white);//���ñ���ɫΪ��
//		username.setEditable(false);//��������
//		username.setFocusable(false);//�������
//		username.setDocument(new MyDocument(16));//�����������볤��

	}
	//---------�����ĳ�ʼ��

	//��ǩ��ʼ��
	public static void JLableInit(JLabel jl,String str){
		jl.setName(str);//�����ı��������
//		jl.setFont(new Font("serif",0,20));
		jl.setFont(new Font("΢���ź�",0,20));

		jl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//�����Ϊ��
		jl.setForeground(Color.white);
	}
	//---------������ʼ��
	public static void JButtonInit(JButton jb,String str){
		jb.setName(str);	
		jb.setFocusable(false);//�������
//		jb.setContentAreaFilled(false);//����͸��
//		jb.setIcon(new ImageIcon(""));//���ñ���
		jb.setBorder(null);//ȥ���߿�
	}
	//---------����ʼ��
	public static void JPanelInit(JPanel jp,String str,int x,int y,int size_X,int size_Y){
//		jp.setOpaque(false);//�������͸��
		jp.setName(str);//���������
		jp.setSize(size_X,size_Y);
		jp.setLocation(x, y);

		jp.setLayout(null);//������Ĳ��ַ�ʽ
	}
	//��������ʼ��
	public static void JProgressBarInit(JProgressBar jpb,String str){
//		jp.setOpaque(false);
		jpb.setName(str);
		jpb.setStringPainted(true);// ���ý������ϵ��ַ�����ʾ��false������ʾ  
		jpb.setVisible(true);
	}
}
	

