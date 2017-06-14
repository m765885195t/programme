package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Aadministrator_UI implements MouseListener{
	private JButton add = new JButton("����û�");
	private JButton delete = new JButton("ɾ���û�");
	private JButton ctl = new JButton("�����û�");
	private JButton close = new JButton("close");
	private JButton pre_add = new JButton("<-");//������һ��
	private JButton pre_delete = new JButton("<-");//������һ��
	private JButton pre_ctl = new JButton("<-");//������һ��
	private JButton submit = new JButton("�ύ");
	private JTextField username = new JTextField();
	private JPasswordField userpass = new JPasswordField(); //�����
	//ѡ�����id
	private myJPanel_UI Adm_Jpanel = new myJPanel_UI(Default.Get_Path_Img_Adm());//�O�ñ���
	private myJPanel_UI Add_Jpanel = new myJPanel_UI(Default.Get_Path_Img_Adm());//�O�ñ���
	private myJPanel_UI Delete_Jpanel = new myJPanel_UI(Default.Get_Path_Img_Adm());//�O�ñ���
	private myJPanel_UI Ctl_Jpanel= new myJPanel_UI(Default.Get_Path_Img_Adm());//�O�ñ���
	
	private JFrame Adm_JF = new JFrame();
	
	public Aadministrator_UI(){
		Object[][] data={  
	            {"082520","��ƽ","03A01",80,90,95,(80+90+95)},  
	            {"082521","���","03A02",88,90,90,(88+90+90)}  
	    };
	    String[] rowName={"id","�û���","����"," "};  
		JTable JT = new JTable(data,rowName);
		JScrollPane JS = new JScrollPane(JT);
		JS.setBounds(0,20, 300, 280);
		
		this.Init();//��ʼ��
		this.setSize();//Ĭ��������ʼλ�����С
		this.listener();
		
		//�����
		Adm_Jpanel.add(add);
		Adm_Jpanel.add(delete);
		Adm_Jpanel.add(ctl);
		Adm_Jpanel.add(close);
		//������
		Add_Jpanel.add(username);
		Add_Jpanel.add(userpass);
		Add_Jpanel.add(pre_add);
		Add_Jpanel.add(submit);
		//ɾ�����
		Delete_Jpanel.add(JS);
		Delete_Jpanel.add(pre_delete);
		//�������
		Ctl_Jpanel.add(pre_ctl);
		
		Adm_JF.add(Adm_Jpanel);
		Adm_JF.setLocationRelativeTo(null);//��ʼλ��Ϊ��Ļ����
	}
	//����ļ���
	public void listener(){
		pre_add.addMouseListener(this);
		pre_delete.addMouseListener(this);
		pre_ctl.addMouseListener(this);
		
		close.addMouseListener(this);
		
		add.addMouseListener(this);
		ctl.addMouseListener(this);
		delete.addMouseListener(this);
		username.addMouseListener(this);
		userpass.addMouseListener(this);
		submit.addMouseListener(this);

	}
	//��������ĳ�ʼ��
	public void Init(){
		Init_UI.JFrameInit(Adm_JF,"Adm_JF",Default.Get_Window_X_Adm(),Default.Get_Window_Y_Adm());//ϵͳ����Ա�Ĵ��ڳ�ʼ��
		Init_UI.JPanelInit(Adm_Jpanel, "Adm_Jpanel",Default.Get_Window_X_Adm(),Default.Get_Window_Y_Adm());
		Init_UI.JPanelInit(Add_Jpanel, "Add_Jpanel",Default.Get_Window_X_Adm(),Default.Get_Window_Y_Adm());
		Init_UI.JPanelInit(Delete_Jpanel, "Delete_Jpanel",Default.Get_Window_X_Adm(),Default.Get_Window_Y_Adm());
		Init_UI.JPanelInit(Ctl_Jpanel, "Ctl_Jpanel",Default.Get_Window_X_Adm(),Default.Get_Window_Y_Adm());
		Init_UI.JButtonInit(close, "close");

		Init_UI.JButtonInit(add, "add");
		Init_UI.JTextFieldInit(username, "username");
		Init_UI.JTextFieldInit(userpass, "userpass");
		Init_UI.JButtonInit(pre_add, "pre_add");
		Init_UI.JButtonInit(submit,"submit");
		
		Init_UI.JButtonInit(delete, "delete");
//		Init_UI.JTableInit(JT, "JT");
		Init_UI.JButtonInit(pre_delete, "pre_delete");

		Init_UI.JButtonInit(ctl, "ctl");
		Init_UI.JButtonInit(pre_ctl, "pre_ctl");

	}
	//������������Ĵ�С����ʼλ��
	public void setSize(){
		close.setBounds(Default.Get_Window_X_Adm()-20, 0, 20, 20);
		
		add.setBounds(70, 70, 150, 30);
		pre_add.setBounds(0, 0, 20, 20);
		username.setBounds(70, 70, 150, 30);
		userpass.setBounds(70, 120, 150, 30);
		submit.setBounds(70, 170, 150, 30);
		
		delete.setBounds(70, 120, 150, 30);
//		JT.setBounds(0,0,200,200);
		pre_delete.setBounds(0, 0, 20, 20);
		
		ctl.setBounds(70, 170, 150, 30);
		pre_ctl.setBounds(0, 0, 20, 20);
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {// �������ʱִ�еĲ��� 
		if("add".equals( e.getComponent().getName())){
			Adm_JF.remove(Adm_Jpanel);
			Adm_JF.repaint();//ˢ��
			Adm_JF.add(Add_Jpanel);
		}else if("ctl".equals(e.getComponent().getName())){
			Adm_JF.remove(Adm_Jpanel);
			Adm_JF.repaint();//ˢ��
			Adm_JF.add(Ctl_Jpanel);
		}else if("delete".equals(e.getComponent().getName())){
			Adm_JF.remove(Adm_Jpanel);
			Adm_JF.repaint();//ˢ��
			Adm_JF.add(Delete_Jpanel);
		}else if("username".equals(e.getComponent().getName())){
			username.setText("");
			username.setForeground(Color.black);//����ǰ��ɫΪ��
		}else if("userpass".equals(e.getComponent().getName())){
			userpass.setText("");
			userpass.setForeground(Color.black);//����ǰ��ɫΪ��
		}else if("submit".equals( e.getComponent().getName())){
			if(server.ManageUser_Ser.add(username.getText(),String.valueOf(userpass.getPassword()))){
//				System.out.println("����"+String.valueOf(pass.getPassword()));
				int flag=JOptionPane.showConfirmDialog(null, "��ӳɹ�!!!  �Ƿ�������?", "ȷ��", JOptionPane.YES_NO_OPTION);
	            if(JOptionPane.YES_OPTION == flag){ 
	            	username.setText("");
	    			userpass.setText("");
	           }else{
	        	   Adm_JF.remove(Add_Jpanel);
	        	   Adm_JF.repaint();//ˢ��
	        	   Adm_JF.add(Adm_Jpanel);
	            } 
			}else{
				int flag=JOptionPane.showConfirmDialog(null, "���ʧ��!!!  �Ƿ�����������?", "ȷ��", JOptionPane.YES_NO_OPTION);
	            if(JOptionPane.YES_OPTION == flag){ 
	            	username.setText("");
	    			userpass.setText("");
	           }else{
	        	   Adm_JF.remove(Add_Jpanel);
	        	   Adm_JF.repaint();//ˢ��
	        	   Adm_JF.add(Adm_Jpanel);
	            } 
            
			}
			
		}else if("pre_add".equals( e.getComponent().getName()) || "pre_delete".equals( e.getComponent().getName()) || 
				 "pre_ctl".equals( e.getComponent().getName())){
			Adm_JF.remove(Add_Jpanel);
			Adm_JF.remove(Delete_Jpanel);
			Adm_JF.remove(Ctl_Jpanel);
			Adm_JF.repaint();//ˢ��
			Adm_JF.add(Adm_Jpanel);
		}else if("close".equals(e.getComponent().getName())){
			System.exit(0);//�˳�����
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {// ���������ϰ���ʱִ�еĲ���  
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {// ����ͷ�ʱִ�еĲ���  
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {// ���������ʱִ�еĲ��� 
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	//��������
	public static void main(String[] args){  
		new Aadministrator_UI();
	}
}
