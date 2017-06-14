package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
		jf.setVisible(true);//���ڿɼ�

	}

	//�ı����ʼ��
	public static void JTextAreaInit (JTextArea in,String str){
		in.setOpaque(false);//��Ϊ͸��
		in.setFont(new Font("serif",1,23));//���������ʽ
		in.setName(str);//�����ı��������
		in.setForeground(Color.gray);
		in.setEditable(false);//��������
		in.setFocusable(false);//�������
		in.setLineWrap(true);//�Զ�����

	}
	//---------�ı���ĳ�ʼ��
	public static void JTextFieldInit(JTextField username,String str){
//		username.setOpaque(false);//��Ϊ͸��
//		username.setBorder(null);//ȥ���߿�
		username.setFont(new Font("serif",0, 12));//���������ʽ
		username.setName(str);//�����ı��������
//		username.setForeground(Color.gray);//����ǰ��ɫΪ��
		username.setBackground(Color.white);//���ñ���ɫΪ��
//		username.setEditable(false);//��������
//		username.setFocusable(false);//�������
//		username.setDocument(new MyDocument(16));//�����������볤��

	}
	//---------�����ĳ�ʼ��
	public static void JPasswordField(JPasswordField password,String str){
//		password.setOpaque(false);//��Ϊ͸��
//		password.setBorder(null);//ȥ���߿�
		password.setFont(new Font("serif",0, 12));//���������ʽ
		password.setName(str);//�����ı��������
		password.setForeground(Color.gray);//����ǰ��ɫΪ��
		password.setBackground(Color.white);//���ñ���ɫΪ��
		password.setEchoChar((char)0);//����Ϊ����
//		password.setEditable(false);//��������
//		password.setFocusable(false);//�������
//		password.setDocument(new MyDocument(16));//�����������볤��

	}
	//��ǩ��ʼ��
	public static void JLableInit(JLabel jl,String str){
		jl.setName(str);//�����ı��������
		jl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//�����Ϊ��
		jl.setForeground(Color.white);
	}
	//---------������ʼ��
	public static void JButtonInit(JButton jb,String str){
		jb.setName(str);
		jb.setFocusable(false);//�������
		jb.setContentAreaFilled(false);//����͸��
//		jb.setIcon(new ImageIcon(""));//���ñ���
//		jb.setBorder(null);//ȥ���߿�
	}
	//---------����ʼ��
	public static void JPanelInit(JPanel jp,String str,int x,int y){
		jp.setOpaque(false);//�������͸��
		jp.setName(str);//���������
		jp.setSize(x,y);
		jp.setLayout(null);//������Ĳ��ַ�ʽ
	}
	//---------����ʼ��
	public static void JTableInit(JTable jt,String str){
//		jt.setOpaque(false);
		jt.setName(str);
	}
}
	

