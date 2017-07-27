package team.qep.crawler.view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import team.qep.crawler.basic.Default;
import team.qep.crawler.server.Task;
import team.qep.crawler.util.Operationstring;
import team.qep.crawler.util.Promptinformation;

public class UI implements MouseListener {
	private JFrame ctlJFrame = new JFrame();
	private Myjpanel ctlJPanel = new Myjpanel(Default.getImagePath(1));//主界面
	private Myjpanel logo = new Myjpanel(Default.getDynamicImagePath(1));//主界面
	private JButton closeWindow = new JButton("..."); 
	private JButton zoom = new JButton("..."); //缩放窗口

	private static Point mousePosition = new Point();// 全局的位置变量，用于表示鼠标在窗口上的位置

	private JLabel taskManagement = new JLabel("Task");
	private Myjpanel taskJPanel = new Myjpanel(team.qep.crawler.basic.Default.getImagePath(2));//任务面板
	private JTextArea distributionTask = new JTextArea();//分发任务集
	private JScrollPane distributionJSPanel = new JScrollPane(distributionTask);
	private Choice defaultTask = new Choice();//默认任务集
	private JButton startTask= new JButton("start");//开始任务
	private String[][] taskData ;////在运行任务
	private DefaultTableModel taskModel;
	private JTable viewJTable = new JTable();
	private JScrollPane viewJSPanel = new JScrollPane(viewJTable);
	private JButton endTask= new JButton("endTask");//结束任务
	
	private JLabel monitoringData = new JLabel("Data");
	private Myjpanel dateJPanel = new Myjpanel(team.qep.crawler.basic.Default.getImagePath(3));//数据面板
	//数据视图待添加  
	private JPanel lineChart;

	private JButton refreshData= new JButton("refreshData");//刷新数据
	private JButton browse = new JButton("SavePath");//浏览
	private JTextField savePath = new JTextField();//存储路径框
	private JButton downloadData= new JButton("Download");//存储数据
	private JButton emptydata= new JButton("Empty");//清空数据

	
	public UI(){
		this.init();
		this.setSize();
		this.listener();
		
		taskJPanel.add(startTask);
		taskJPanel.add(distributionJSPanel);
		taskJPanel.add(defaultTask);
		taskJPanel.add(viewJSPanel);
		taskJPanel.add(endTask);

		dateJPanel.add(refreshData);
		dateJPanel.add(lineChart);
		dateJPanel.add(browse);
		dateJPanel.add(savePath);
		dateJPanel.add(downloadData);
		dateJPanel.add(emptydata);

		
		ctlJPanel.add(taskJPanel);
		ctlJPanel.add(taskManagement);
		ctlJPanel.add(monitoringData);
		ctlJPanel.add(zoom);
		ctlJPanel.add(closeWindow);
		ctlJPanel.add(logo);
		ctlJFrame.setContentPane(ctlJPanel);
		ctlJFrame.setVisible(true);
	}
	
	public void init(){
		Init.initJFrame(ctlJFrame, "ctlJFrame", Default.JFrameX, Default.JFrameY);
		Init.initJPanel(ctlJPanel, "ctlJPanel",  Default.JFrameX,Default.JFrameY);
		Init.initJPanel(logo, "logo", 100,100);
		Init.initJButton(closeWindow, "closeWindow");
		Init.initJButton(zoom, "zoom");
		Init.initJLable(taskManagement, "taskManagement");
		taskManagement.setForeground(Color.red);
		taskManagement.setFont(new Font("微软雅黑",0,32));
		Init.initJLable(monitoringData, "monitoringData");
		monitoringData.setForeground(Color.white);
		monitoringData.setFont(new Font("微软雅黑",0,32));

		Init.initJPanel(taskJPanel, "taskJPanel",  Default.JPanelX, Default.JPanelY);
		Init.initJTextArea(distributionTask, "distributionTask");
		Init.initJScrollPane(distributionJSPanel, "distributionJSPanel");
		Init.initChoice(defaultTask, "defaultTask");
		Init.initJButton(startTask, "startTask");
		Init.initJTable(viewJTable, "viewJTable");
		taskData = Task.getRunningTask(5);
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
		lineChart = Crawlergraph.createLineChart();
		Init.initJButton(downloadData, "downloadData");
		Init.initJButton(emptydata, "emptydata");
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
		zoom.addMouseListener(this);
		closeWindow.addMouseListener(this);
		
		taskManagement.addMouseListener(this);
		startTask.addMouseListener(this);
		viewJTable.addMouseListener(this);
		endTask.addMouseListener(this);
		monitoringData.addMouseListener(this);
		refreshData.addMouseListener(this);
		browse.addMouseListener(this);
		downloadData.addMouseListener(this);
		emptydata.addMouseListener(this);
	}
	
	public void setSize(){
		zoom.setBounds(940,0, 30, 30);
		closeWindow.setBounds(970,0, 30, 30);
		taskManagement.setBounds(200,20, 100, 50);
		monitoringData.setBounds(700, 20, 100, 50);

		taskJPanel.setLocation(0, 100);
		distributionJSPanel.setBounds(50, 20, 250, 400);
		defaultTask.setBounds(30, 430, 300,30);
		defaultTask.add("Currently supporting task sets");
		for(String str:Default.getDefaultUrl()){
			defaultTask.add(str);
		}
		startTask.setBounds(50, 470, 200, 30);
		viewJSPanel.setBounds(550, 20, 400, 350);
		endTask.setBounds(700, 450, 120,30);

		dateJPanel.setLocation(0, 100);
		lineChart.setBounds(30,30,940,400);
		refreshData.setBounds(30, 450,110, 30);
		browse.setBounds(700,450, 100, 30);
		savePath.setBounds(500, 450, 200, 30);
		downloadData.setBounds(870, 450, 100, 30);
		emptydata.setBounds(200, 450, 100, 30);
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
	    	if(!distributionTask.getText().equals("")){
		    	String[] startTaskSet = Operationstring.differenceString(Operationstring.splitString(distributionTask.getText()), Operationstring.extractString(taskData));
	
		    	if(startTaskSet != null){
			    	if(Task.beginTask(1,startTaskSet)){
			    		for(int i=0 ; i<startTaskSet.length ; i++){
			    			System.out.println("正确的任务:"+startTaskSet[i]);
				    		int taskNumber = Integer.valueOf(String.valueOf(viewJTable.getValueAt(viewJTable.getRowCount()-1,0)))+1;
			    			taskModel.addRow(new String[]{String.valueOf(taskNumber),startTaskSet[i]});
			    		}
			    		Promptinformation.informationprompt("Successful submission has been done automatically with duplicate tasks and unsupported tasks.");
			    		distributionTask.setText("");
			    	}else{
			    		Promptinformation.errorPrompt("The task submission failed. Check network connections!");
			    	}
		    	}else{
		    		Promptinformation.informationprompt("Please enter the correct url with the currently supported url");
		    	}
	    	}else{
	    		Promptinformation.errorPrompt("Task set is empty, please check!!!");
	    	}
		}else if("endTask".equals(e.getComponent().getName())){
    		if(Promptinformation.confirmPrompt("Confirm termination task?")==0){
    			int selectedRow = viewJTable.getSelectedRow(); // 获得选中行索引
    			if(selectedRow!=-1){
    				System.out.println("选中的是:"+viewJTable.getValueAt(selectedRow, 1).toString());
    				if(Task.endTask(15,viewJTable.getValueAt(selectedRow, 1).toString())){
    					taskModel.removeRow(selectedRow); // 删除行
    		    		Promptinformation.informationprompt("successfully deleted");
    				}
    			}else{
		    		Promptinformation.informationprompt("Please select a task");
    			}
    		}
		}else if("refreshData".equals(e.getComponent().getName())){
				
				dateJPanel.remove(lineChart);
				lineChart = Crawlergraph.createLineChart();
				dateJPanel.add(lineChart);
				lineChart.setBounds(30,30,940,400);
				dateJPanel.updateUI();
		}else if("browse".equals(e.getComponent().getName())){
		     JFileChooser path = new JFileChooser();
		     path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		     int result  =path.showSaveDialog(ctlJFrame);
		     if(result == JFileChooser.APPROVE_OPTION){
		    	 savePath.setText(path.getSelectedFile().getAbsolutePath());
		     }
		}else if("downloadData".equals(e.getComponent().getName())){
	    	if(savePath.getText().equals("")){
	    		Promptinformation.informationprompt("Please select the save path");
	    	}
		}else if("emptydata".equals(e.getComponent().getName())){
			if(Promptinformation.confirmPrompt("Are you sure you want to empty the downloaded data, which is irrevocable?")==0){
				//清空操作
				
				Promptinformation.informationprompt("Has been emptied");
			}
		
		} else if("closeWindow".equals(e.getComponent().getName())){
	    	System.exit(0);//退出程序
		} else if("zoom".equals(e.getComponent().getName())){
			ctlJFrame.setExtendedState(JFrame.ICONIFIED);
		} else if("closeWindow".equals(e.getComponent().getName())){
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
		 if("endTask".equals(e.getComponent().getName())){
			 endTask.setBorder(BorderFactory.createLineBorder(new Color(245,245,245)));//按键边框色
			 endTask.setForeground(new Color(245,245,245));//按键上的字的颜色
			 endTask.setBackground(new Color(66,139,202));//按键背景色
		 }
	}

	public void mouseExited(MouseEvent e) {
		 if("endTask".equals(e.getComponent().getName())){
			 endTask.setBorder(BorderFactory.createLineBorder(new Color(51,153,204)));
			 endTask.setForeground(new Color(66,139,202));
			 endTask.setBackground(new Color(245,245,245));
		 }

	}
	public static void main(String[] args) {
		new UI();
	}

}
