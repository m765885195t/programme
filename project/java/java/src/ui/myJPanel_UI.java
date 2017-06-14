package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


public class myJPanel_UI extends JPanel {
	Image img;
	public myJPanel_UI(String path){ 
		img =Toolkit.getDefaultToolkit().getImage(path);//��Ҫע�������������·������ͼƬ,��ͼƬ�ļ�����������ļ������ļ��л���Ŀ�ĸ��ļ�����,��������þ���·���� 
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int imWidth = img.getWidth(this);
		int imHeight = img.getHeight(this); // ����ͼƬ�Ŀ�ȡ��߶�
		int FWidth = getWidth();
		int FHeight = getHeight();// ���崰�ڵĿ�ȡ��߶�
		int x = (FWidth - imWidth) / 2;
		int y = (FHeight - imHeight) / 2;// ����ͼƬ������,ʹͼƬ��ʾ�ڴ������м�
		g.drawImage(img, x, y, null);// ����ͼƬ
	} 
 }