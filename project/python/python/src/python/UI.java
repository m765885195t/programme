package python;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.org.apache.xpath.internal.operations.And;

import jdk.nashorn.internal.objects.annotations.Where;


public class UI implements MouseListener{
	private JLabel title= new JLabel("进度",JLabel.CENTER);
	private JTextField url1 = new JTextField();
	private JTextField url2 = new JTextField();

	private JButton implement1 = new JButton("执行1");
	private JButton termination1 = new JButton("中断1");
	private JButton implement2 = new JButton("执行2");
    private JButton termination2 = new JButton("中断2");
	private JFrame UI_JF = new JFrame();
	private myJPanel_UI UI_JP = new myJPanel_UI(".\\test.jpg");
	private JButton close = new JButton();
	private JProgressBar UI_JPB1=new  JProgressBar();
	private JProgressBar UI_JPB2=new  JProgressBar();
	private static Point origin = new Point();
	private boolean flag1=false;
	private boolean flag2=false;
	public UI(){
		this.Init();
		this.setSize();
		this.listener();
		
		UI_JP.add(UI_JPB1);
		UI_JP.add(UI_JPB2);

		UI_JP.add(title);
		UI_JP.add(url1);
		UI_JP.add(url2);

		UI_JP.add(implement1);
		UI_JP.add(termination1);
		UI_JP.add(implement2);
		UI_JP.add(termination2);
		UI_JP.add(close);

		UI_JF.add(UI_JP);
		UI_JF.setVisible(true);
	}

	private void listener() {
		UI_JF.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point tem = UI_JF.getLocation();
				UI_JF.setLocation(tem.x + e.getX() - origin.x, tem.y + e.getY()- origin.y);
			}
		}); 
		UI_JF.addMouseListener(this);	
		close.addMouseListener(this);
		implement1.addMouseListener(this);
		termination1.addMouseListener(this);
		implement2.addMouseListener(this);
		termination2.addMouseListener(this);
	}

	private void setSize() {
		title.setBounds(50, 0, 200, 40);
		close.setBounds(265,0, 25, 25);
		url1.setBounds(20,166, 167, 30);
		implement1.setBounds(200,166, 50, 30);
		UI_JPB1.setBounds(20,226, 167, 30);
		termination1.setBounds(200,226, 50, 30);
		url2.setBounds(20,366, 167, 30);
		implement2.setBounds(200,366, 50, 30);
		UI_JPB2.setBounds(20,426, 167, 30);
		termination2.setBounds(200,426, 50, 30);	

	}

	private void Init() {
		Init_UI.JFrameInit(UI_JF, "UI_JF",290, 485);
		Init_UI.JPanelInit(UI_JP, "UI_JP",0,0,290,485);
		Init_UI.JLableInit(title, "title");
		title.setFont(new Font("",0,32));
		title.setForeground(Color.red);
		Init_UI.JTextFieldInit(url1, "url1");
		Init_UI.JTextFieldInit(url2, "url2");

		Init_UI.JButtonInit(implement1, "implement1");
		Init_UI.JButtonInit(termination1, "termination1");
			termination1.setEnabled(false);

		Init_UI.JButtonInit(implement2, "implement2");
		Init_UI.JButtonInit(termination2, "termination2");
			termination2.setEnabled(false);
		Init_UI.JProgressBarInit(UI_JPB1, "UI_JPB1");
		Init_UI.JProgressBarInit(UI_JPB2, "UI_JPB2");
//		 UI_JPB.setValue(0); // ���ý�������ֵ  
	        
	        
		Init_UI.JButtonInit(close, "close");
	}
	public void mouseClicked(MouseEvent e) {// �������ʱִ�еĲ��� 
		if("implement1".equals(e.getComponent().getName())){
			implement1.setEnabled(false);
			termination1.setEnabled(true);
			flag1 = false;
			 new Thread(){  
		            public void run(){
		               while(true){
		            	   int value = DB.getProgress1();
		            	   
		            	   if(value <500){
		            		   UI_JPB1.setMaximum(500);
		            		   UI_JPB1.setBackground(Color.red); //����ɫ 
		            	   }else if(value<1500){
		            		   UI_JPB1.setMaximum(1500);
		            		   UI_JPB1.setBackground(Color.GREEN); //����ɫ 
		            	   }else if(value<5000){
		            		   UI_JPB1.setMaximum(5000);
		            		   UI_JPB1.setBackground(Color.PINK); //����ɫ 
		            	   }else if(value<10000){
		            		   UI_JPB1.setMaximum(10000);
		            		   UI_JPB1.setBackground(Color.cyan); //����ɫ 
		            	   }else if(value<20000){
		            		   UI_JPB1.setMaximum(20000);
		            		   UI_JPB1.setBackground(Color.BLUE); //����ɫ 
		            	   }else if(value<50000){
		            		   UI_JPB1.setMaximum(50000);
		            		   UI_JPB1.setBackground(Color.lightGray); //����ɫ 
		            	   }else{
		            		   UI_JPB1.setMaximum(1000000000);
		            		   UI_JPB1.setBackground(Color.black); //����ɫ 
		            	   }
		            	   
			               UI_JPB1.setValue(value); // ���ý�������ֵ  
		                   UI_JPB1.setString("����ȡ��������"+String.valueOf(value)+"��");// ������ʾ��Ϣ  
		                   DB.insert();
		                   
		                   if(flag1){
		           				implement1.setEnabled(true);
		           				termination1.setEnabled(false);
		                	   break;
		                   }
		                }
		           }  
		     }.start(); //  �����������߳�

		}else if("termination1".equals(e.getComponent().getName())){
			flag1 = true;
		}else if("implement2".equals(e.getComponent().getName())){
			implement2.setEnabled(false);
			termination2.setEnabled(true);
			flag2 = false;
			 new Thread(){  
		            public void run(){  
		               while(true){
		            	   int value = DB.getProgress2();

		            	   if(value <500){
		            		   UI_JPB2.setMaximum(500);
		            		   UI_JPB2.setBackground(Color.red); //����ɫ 
		            	   }else if(value<1500){
		            		   UI_JPB2.setMaximum(1500);
		            		   UI_JPB2.setBackground(Color.GREEN); //����ɫ 
		            	   }else if(value<5000){
		            		   UI_JPB2.setMaximum(5000);
		            		   UI_JPB2.setBackground(Color.PINK); //����ɫ 
		            	   }else if(value<10000){
		            		   UI_JPB2.setMaximum(10000);
		            		   UI_JPB2.setBackground(Color.cyan); //����ɫ 
		            	   }else if(value<20000){
		            		   UI_JPB2.setMaximum(20000);
		            		   UI_JPB2.setBackground(Color.BLUE); //����ɫ 
		            	   }else if(value<50000){
		            		   UI_JPB2.setMaximum(50000);
		            		   UI_JPB2.setBackground(Color.lightGray); //����ɫ 
		            	   }else{
		            		   UI_JPB2.setMaximum(1000000000);
		            		   UI_JPB2.setBackground(Color.black); //����ɫ 
		            	   }
			               UI_JPB2.setValue(value); // ���ý�������ֵ  
		                   UI_JPB2.setString("����ȡ��������"+String.valueOf(value)+"��");// ������ʾ��Ϣ  
		                   DB.insert();
		                   
		                   if(flag2){
		           				implement2.setEnabled(true);
		           				termination2.setEnabled(false);
		                	   break;
		                   }
		                }
		           }  
		     }.start(); //  �����������߳�

		}else if("termination2".equals(e.getComponent().getName())){
			flag2 = true;
		}else if("close".equals(e.getComponent().getName())){
			System.exit(0);
		}
	}
	public void mousePressed(MouseEvent e) {
		// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
		if("UI_JF".equals(e.getComponent().getName())){
	    	origin.x = e.getX();
			origin.y = e.getY();
		}		
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public static void main(String[] args){
		new UI();
	}
}
