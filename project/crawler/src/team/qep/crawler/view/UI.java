package team.qep.crawler.view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import team.qep.crawler.basic.Default;
import team.qep.crawler.server.Task;
import team.qep.crawler.util.Operationstring;
import team.qep.crawler.util.Promptinformation;

public class UI implements MouseListener {
	private JFrame ctlJFrame = new JFrame();
	private Myjpanel ctlJPanel = new Myjpanel(Default.getImagePath(1));//主界面
	private JButton closeWindow = new JButton("..."); 
	private static Point mousePosition = new Point();// 全局的位置变量，用于表示鼠标在窗口上的位置

	private JLabel taskManagement = new JLabel("Task");
	private Myjpanel taskJPanel = new Myjpanel(team.qep.crawler.basic.Default.getImagePath(2));//任务面板
	private JTextArea distributionTask = new JTextArea();//分发任务集
	private JScrollPane distributionJSPanel = new JScrollPane(distributionTask);
	private JLabel prompt = new JLabel("ForkNumber:");
	private Choice processNumber = new Choice();//从机数
	private JButton startTask= new JButton("start");//开始任务
	private String[][] taskData ;////在运行任务
	private DefaultTableModel taskModel;
	private JTable viewJTable = new JTable();
	private JScrollPane viewJSPanel = new JScrollPane(viewJTable);
	private JButton endTask= new JButton("endTask");//结束任务
	
	private JLabel monitoringData = new JLabel("Data");
	private Myjpanel dateJPanel = new Myjpanel(team.qep.crawler.basic.Default.getImagePath(3));//数据面板
	//数据视图待添加  
	private JButton refreshData= new JButton("refreshData");//刷新数据
	private JButton browse = new JButton("SavePath");//浏览
	private JTextField savePath = new JTextField();//存储路径框
	private JButton downloadData= new JButton("Download");//存储数据

	
	public UI(){
		this.init();
		this.setSize();
		this.listener();
		
		taskJPanel.add(startTask);
		taskJPanel.add(distributionJSPanel);
		taskJPanel.add(prompt);
		taskJPanel.add(processNumber);
		taskJPanel.add(viewJSPanel);
		taskJPanel.add(endTask);

		dateJPanel.add(refreshData);
		dateJPanel.add(browse);
		dateJPanel.add(savePath);
		dateJPanel.add(downloadData);
		
		ctlJPanel.add(taskJPanel);
		ctlJPanel.add(taskManagement);
		ctlJPanel.add(monitoringData);
		ctlJPanel.add(closeWindow);
		ctlJFrame.add(ctlJPanel);
		ctlJFrame.setVisible(true);
	}
	
	public void init(){
		Init.initJFrame(ctlJFrame, "ctlJFrame", Default.JFrameX, Default.JFrameY);
		Init.initJPanel(ctlJPanel, "ctlJPanel",  Default.JFrameX,Default.JFrameY);
		Init.initJButton(closeWindow, "closeWindow");
		Init.initJLable(taskManagement, "taskManagement");
		taskManagement.setForeground(Color.red);
		taskManagement.setFont(new Font("微软雅黑",0,32));
		Init.initJLable(monitoringData, "monitoringData");
		monitoringData.setForeground(Color.white);
		monitoringData.setFont(new Font("微软雅黑",0,32));

		Init.initJPanel(taskJPanel, "taskJPanel",  Default.JPanelX, Default.JPanelY);
		Init.initJTextArea(distributionTask, "distributionTask");
		Init.initJScrollPane(distributionJSPanel, "distributionJSPanel");
		Init.initJLable(prompt, "prompt");
		prompt.setCursor(Cursor.getPredefinedCursor(0));
		prompt.setForeground(Color.green);
		prompt.setFont(new Font("微软雅黑",0,20));
		Init.initChoice(processNumber, "processNumber");
		Init.initJButton(startTask, "startTask");
		Init.initJTable(viewJTable, "viewJTable");
		taskData = Task.getRunningTask();
	    taskModel = new DefaultTableModel(taskData,Default.getTaskViewJColumnNames()){
			public boolean isCellEditable(int row,int column){ 
				return false;
			}  
		};
		viewJTable.setModel(taskModel);
		
		Init.initJScrollPane(viewJSPanel, "viewJSPanel");
		Init.initJButton(endTask, "endTask");

		Init.initJPanel(dateJPanel, "dateJPanel", Default.JPanelX, Default.JPanelY);
		Init.initJButton(refreshData, "refreshData");
		Init.initJButton(downloadData, "downloadData");
		Init.initJButton(browse, "browse");
		Init.initJTextField(savePath, "savePath");
	}
	public void listener(){
		ctlJFrame.addMouseListener(this);
		ctlJFrame.addMouseMotionListener(new MouseMotionAdapter() {
			// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent e) {
				Point tem = ctlJFrame.getLocation();
				ctlJFrame.setLocation(tem.x + e.getX() - mousePosition.x, tem.y + e.getY()- mousePosition.y);
			}
		});
		closeWindow.addMouseListener(this);
		
		taskManagement.addMouseListener(this);
		startTask.addMouseListener(this);
		viewJTable.addMouseListener(this);
		endTask.addMouseListener(this);
		monitoringData.addMouseListener(this);
		refreshData.addMouseListener(this);
		browse.addMouseListener(this);
		downloadData.addMouseListener(this);
	}
	
	public void setSize(){
		closeWindow.setBounds(970,0, 30, 30);
		taskManagement.setBounds(200,20, 100, 50);
		monitoringData.setBounds(700, 20, 100, 50);

		taskJPanel.setLocation(0, 100);
		distributionJSPanel.setBounds(50, 20, 250, 400);
		prompt.setBounds(30, 430, 150,30);
		processNumber.setBounds(200, 430, 100,30);
		for(int i=1 ; i<Default.processNumber ; i++){
			processNumber.add(String.valueOf(i));
		}
		startTask.setBounds(50, 470, 200, 30);
		viewJSPanel.setBounds(550, 20, 400, 350);
		endTask.setBounds(700, 450, 200,30);

		dateJPanel.setLocation(0, 100);
		refreshData.setBounds(30, 30, 200, 30);
		browse.setBounds(700,300, 200, 30);
		savePath.setBounds(700, 200, 200, 30);
		downloadData.setBounds(700, 400, 200, 50);
	}
	
	
	public void mouseClicked(MouseEvent e) {// 单击鼠标时执行的操作 
	    if("taskManagement".equals(e.getComponent().getName())){
	    	taskManagement.setForeground(Color.red);
	    	monitoringData.setForeground(Color.white);
	    	ctlJPanel.remove(dateJPanel);
	    	ctlJPanel.add(taskJPanel);
	    	ctlJPanel.updateUI();
	    }else if("monitoringData".equals(e.getComponent().getName())){
	    	taskManagement.setForeground(Color.white);
	    	monitoringData.setForeground(Color.red);
	    	ctlJPanel.remove(taskJPanel);
	    	ctlJPanel.add(dateJPanel);
	    	ctlJPanel.updateUI();
	    }else if("startTask".equals(e.getComponent().getName())){
	    	String[] startTaskSet = Operationstring.differenceString(Operationstring.splitString(distributionTask.getText()), Operationstring.extractString(taskData));
	    	if(Task.beginTask(startTaskSet, Integer.valueOf(processNumber.getSelectedItem()))){
	    		int taskNumber = Integer.valueOf(String.valueOf(viewJTable.getValueAt(viewJTable.getRowCount()-1,0)))+1;
	    		for(int i=0 ; i<startTaskSet.length ; i++){
	    			taskModel.addRow(new String[]{String.valueOf(taskNumber),startTaskSet[i]});
	    		}

	    		Promptinformation.informationprompt("Task submission successful!   Repetitive tasks have been removed ");
	    		distributionTask.setText("");
	    	}else{
	    		Promptinformation.errorPrompt("The task submission failed. Check network connections!");
	    	}
		}else if("endTask".equals(e.getComponent().getName())){
    		if(Promptinformation.confirmPrompt("Confirm termination task?")==0){
    			int selectedRow = viewJTable.getSelectedRow(); // 获得选中行索引
    			if(selectedRow!=-1){
    		    	taskModel.removeRow(selectedRow); // 删除行
    			}
    		}
		}else if("refreshData".equals(e.getComponent().getName())){
	    	System.exit(0);//退出程序
		}else if("browse".equals(e.getComponent().getName())){
	    	System.exit(0);//退出程序
		}else if("downloadData".equals(e.getComponent().getName())){
	    	System.exit(0);//退出程序
		}else if("closeWindow".equals(e.getComponent().getName())){
	    	System.exit(0);//退出程序
		} 
	}

	public void mousePressed(MouseEvent e) {// 鼠标在组件上按下时执行的操作  
		// 当鼠标按下的时候获得窗口当前的位置
		if("ctlJFrame".equals(e.getComponent().getName())){
			mousePosition.x = e.getX();
			mousePosition.y = e.getY();
		}
	}

	public void mouseReleased(MouseEvent e) {// 鼠标释放时执行的操作  	
	}

	public void mouseEntered(MouseEvent e) {// 鼠标进入组件时执行的操作 
	}

	public void mouseExited(MouseEvent e) {
	}
	public static void main(String[] args) {
		new UI();
	}

}
