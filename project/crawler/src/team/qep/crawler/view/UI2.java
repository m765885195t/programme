package team.qep.crawler.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import team.qep.crawler.basic.Default;
import team.qep.crawler.server.Data;
import team.qep.crawler.server.Task;
import team.qep.crawler.util.Operationstring;
import team.qep.crawler.util.Promptinformation;

public class UI2 implements MouseListener {
	private JFrame ctlJFrame = new JFrame();
	private static Point mousePosition = new Point();// 全局的位置变量，用于表示鼠标在窗口上的位置
	private Timer refresh=null;
	private Myjpanel ctlJPanel = new Myjpanel("");//主面板
//	private Myjpanel logo = new Myjpanel(Default.getDynamicImagePath(21));//logo
	private JLabel date = new JLabel();
	private JLabel time = new JLabel();
	private Myjpanel sidebarJPanel = new Myjpanel("");//侧边栏面板
	private JButton closeWindow = new JButton();//关闭 
	private JButton zoom = new JButton(); //缩放窗口
	
	private boolean[] flag=new boolean[10];
	//组件图片使用标志下标为以下顺序从０开始---true正在使用
	/*0----task  1----log  2----download  3----help  4----setting
	 *5          6         7              8----zoom  9----close 
	 **/
	private JButton task = new JButton();//侧边栏--------任务
	private JButton log = new JButton();// -------log
	private JButton download  = new JButton();//------download
	private JButton help  = new JButton();//------help
	private JButton setting  = new JButton();//------setting

	private Myjpanel taskJPanel = new Myjpanel("");//任务面板
	private JTextArea distributionTask = new JTextArea();//分发任务集
	private JScrollPane distributionJSPanel = new JScrollPane(distributionTask);
	private JTable supportedJTable = new JTable(new DefaultTableModel(Operationstring.toTwoimensional(Default.taskSet),new String[]{"URL"}){
		public boolean isCellEditable(int row,int column){ 
			return false;
		}  
	});
	private JScrollPane supportedJSPanel = new JScrollPane(supportedJTable);
	
	private JButton startTask= new JButton();//开始任务
	private String[][] runData ;////在运行任务
	private DefaultTableModel runModel;
	private JTable runJTable = new JTable();
	private JScrollPane runJSPanel = new JScrollPane(runJTable);
	private JButton endTask= new JButton();//结束任务
	
	private Myjpanel logJPanel = new Myjpanel("");//log面板
	private JPanel lineChart=Crawlergraph.createLineChart();
	private JButton refreshData= new JButton();//刷新数据
	private JButton picture= new JButton();//刷新数据
	private JButton emptydata= new JButton();//清空数据

	
	private Myjpanel downloadPanel = new Myjpanel("");//download面板
	private JButton browse = new JButton("SavePath");//浏览
	private JTextField savePath = new JTextField();//存储路径框
	private JButton downloadData= new JButton("Download");//存储数据

	private Myjpanel helpPanel = new Myjpanel("");//download面板
	private Myjpanel settingPanel = new Myjpanel("");//download面板

	public UI2(){
		this.Init2();
		this.setSize();
		this.setColour();
		this.listener();
		this.info();
		flag[0]=true;
		task.setBackground(new Color(20,20,20));
		task.setIcon(new ImageIcon(Default.getDynamicIconPath("task1")));//任务icon

		
		sidebarJPanel.add(taskJPanel);
		sidebarJPanel.add(task);
		sidebarJPanel.add(log);
		sidebarJPanel.add(download);
		sidebarJPanel.add(help);
		sidebarJPanel.add(setting);
		
		taskJPanel.add(startTask);
		taskJPanel.add(distributionJSPanel);
		taskJPanel.add(supportedJSPanel);
		taskJPanel.add(runJSPanel);
		taskJPanel.add(endTask);
		
		logJPanel.add(refreshData);
		logJPanel.add(lineChart);
		logJPanel.add(picture);
		logJPanel.add(emptydata);
		
		downloadPanel.add(browse);
		downloadPanel.add(savePath);
		downloadPanel.add(downloadData);

		ctlJPanel.add(sidebarJPanel);
		ctlJPanel.add(taskJPanel);
		ctlJPanel.add(zoom);		
		ctlJPanel.add(closeWindow);	
		ctlJPanel.add(date);
		ctlJPanel.add(time);
//		ctlJPanel.add(logo);
		ctlJFrame.setContentPane(ctlJPanel);
		ctlJFrame.setVisible(true);
	}

	private void info(){
		JLabel task1 = new JLabel("Supported");
		JLabel task2 = new JLabel("Release");
		JLabel task3 = new JLabel("Running");
		
		Init2.Init2JLable(task1, "task1");
		task1.setFont(new Font("微软雅黑",0,26));
		task1.setBounds(75, 10, 200, 50);
		task1.setForeground(new Color(0,255,255));
		
		Init2.Init2JLable(task2, "task2");
		task2.setFont(new Font("微软雅黑",0,26));
		task2.setBounds(350, 10, 200, 50);
		task2.setForeground(new Color(	230,210,250));
		
		Init2.Init2JLable(task3, "task3");
		task3.setFont(new Font("微软雅黑",0,25));
		task3.setBounds(680, 10, 200, 50);
		task3.setForeground(new Color(0,255,0));

		taskJPanel.add(task1);
		taskJPanel.add(task2);
		taskJPanel.add(task3);

	}
	
	private void Init2(){
		Init2.Init2JFrame(ctlJFrame, "ctlJFrame", Default.JFrameX, Default.JFrameY);
		Init2.Init2JPanel(ctlJPanel, "ctlJPanel");
//		Init2.Init2JPanel(logo, "logo", 100,100);
		Init2.Init2JButton(closeWindow, "closeWindow");
		Init2.Init2JButton(zoom, "zoom");
		Init2.Init2JLable(date, "date");
		Init2.Init2JLable(time, "time");
		date.setCursor(Cursor.getPredefinedCursor(0));
	    date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	    time.setCursor(Cursor.getPredefinedCursor(0));
	    new Timer().schedule(new TimerTask() {
            public void run() {       
                time.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));   
            }      
        },0,1000); 
		
		Init2.Init2JPanel(sidebarJPanel, "sidebarJPanel");
		Init2.Init2JButton(task, "task");
		Init2.Init2JButton(log, "log");
		Init2.Init2JButton(download, "download");
		Init2.Init2JButton(help, "help");
		Init2.Init2JButton(setting, "setting");
		
		Init2.Init2JPanel(taskJPanel, "taskJPanel");
		Init2.Init2JTable(supportedJTable, "supportedJTable");
		Init2.Init2JTextArea(distributionTask, "distributionTask");
		Init2.Init2JScrollPane(distributionJSPanel, "distributionJSPanel");
		Init2.Init2JButton(startTask, "startTask");
		Init2.Init2JTable(runJTable, "viewJTable");
		runData = Task.getRunningTask(5);
		runModel = new DefaultTableModel(runData,Default.getTaskViewJColumnNames()){
			public boolean isCellEditable(int row,int column){ 
				return false;
			}  
		};
		runJTable.setModel(runModel);
		Init2.Init2JScrollPane(runJSPanel, "runJSPanel");
		Init2.Init2JButton(endTask, "endTask");

		Init2.Init2JPanel(logJPanel, "logJPanel");
		Init2.Init2JButton(refreshData, "refreshData");
		Init2.Init2JButton(emptydata, "emptydata");
		Init2.Init2JButton(picture, "picture");
		
		Init2.Init2JPanel(downloadPanel, "downloadPanel");
		Init2.Init2JButton(downloadData, "downloadData");
		Init2.Init2JButton(browse, "browse");
		Init2.Init2JTextField(savePath, "savePath");

		Init2.Init2JPanel(helpPanel, "helpPanel");
		Init2.Init2JPanel(settingPanel, "settingPanel");

	}
	private void listener(){
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
		task.addMouseListener(this);
		log.addMouseListener(this);
		download.addMouseListener(this);
		help.addMouseListener(this);
		setting.addMouseListener(this);

		startTask.addMouseListener(this);
		runJTable.addMouseListener(this);
		endTask.addMouseListener(this);

		refreshData.addMouseListener(this);
		emptydata.addMouseListener(this);
		picture.addMouseListener(this);
		
		browse.addMouseListener(this);
		downloadData.addMouseListener(this);
		
		//帮助待补充
		//设置待补充
	}
	private void setColour(){
		for(int i=0 ; i<10 ; i++){
			flag[i]=false;
		}
		//面板色
		ctlJPanel.setBackground(new Color(20,20,20));
		sidebarJPanel.setBackground(new Color(90,90,90));
		taskJPanel.setBackground(new Color(20,20,20));
		logJPanel.setBackground(new Color(20,20,20));
		downloadPanel.setBackground(new Color(20,20,20));
		helpPanel.setBackground(new Color(20,20,20));
		settingPanel.setBackground(new Color(20,20,20));

		//按键色
		closeWindow.setBackground(new Color(20,20,20));
		zoom.setBackground(new Color(20,20,20));
		task.setBackground(new Color(90,90,90));
		log.setBackground(new Color(90,90,90));
		download.setBackground(new Color(90,90,90));
		help.setBackground(new Color(90,90,90));
		setting.setBackground(new Color(90,90,90));
		startTask.setBackground(new Color(192,192,192));
		endTask.setBackground(new Color(192,192,192));
		refreshData.setBackground(new Color(192,192,192));
		emptydata.setBackground(new Color(192,192,192));
		picture.setBackground(new Color(192,192,192));

		
		//图片
		closeWindow.setIcon(new ImageIcon(Default.getDynamicIconPath("close")));//任务icon
		zoom.setIcon(new ImageIcon(Default.getDynamicIconPath("zoom")));//任务icon
		task.setIcon(new ImageIcon(Default.getDynamicIconPath("task")));//任务icon
		log.setIcon(new ImageIcon(Default.getDynamicIconPath("log")));//任务icon
		download.setIcon(new ImageIcon(Default.getDynamicIconPath("download")));//任务icon
		help.setIcon(new ImageIcon(Default.getDynamicIconPath("help")));//任务icon
		setting.setIcon(new ImageIcon(Default.getDynamicIconPath("setting")));//任务icon
		startTask.setIcon(new ImageIcon(Default.getDynamicIconPath("start")));//任务icon
		endTask.setIcon(new ImageIcon(Default.getDynamicIconPath("end")));//任务icon
		refreshData.setIcon(new ImageIcon(Default.getDynamicIconPath("refresh")));//任务icon
		emptydata.setIcon(new ImageIcon(Default.getDynamicIconPath("empty")));//任务icon
		picture.setIcon(new ImageIcon(Default.getDynamicIconPath("picture")));//任务icon
	}
	private void setSize(){
		ctlJPanel.setBounds(0, 0, Default.JFrameX, Default.JFrameY);
		zoom.setBounds(940,0, 30, 30);
		closeWindow.setBounds(970,0, 30, 30);
		date.setBounds(740,0, 100, 30);
		time.setBounds(850,0, 100, 30);
		
		      sidebarJPanel.setBounds(0, 0,50, Default.JFrameY);
		               task.setBounds(0,  0, 50, 50);
		                log.setBounds(0,50,50, 50);
		           download.setBounds(0,100, 50, 50);
		     		   help.setBounds(0,Default.JFrameY-100, 50, 50);
		         	setting.setBounds(0,Default.JFrameY-50, 50, 50);

		         taskJPanel.setBounds( 50,  30, Default.JFrameX-50,Default.JFrameY);
		   supportedJSPanel.setBounds( 40,  70, 200, 470);
		distributionJSPanel.setBounds(280,  70, 230, 400);
		         runJSPanel.setBounds(550,  70, 358, 400);
		          startTask.setBounds(305, 500, 180,  40);
		            endTask.setBounds(640, 500, 180,  40);

  		          logJPanel.setBounds(50, 30,Default.JFrameX-50,Default.JFrameY);
		          lineChart.setBounds(10,20,930,460);
		        refreshData.setBounds(60, 505, 180,  40);
		            picture.setBounds(380, 505, 180,  40);
		          emptydata.setBounds(710, 505, 180,  40);
		
		
		      downloadPanel.setBounds(50, 30,Default.JFrameX-50,Default.JFrameY);
		             browse.setBounds(700,450, 100, 30);
		           savePath.setBounds(500, 450, 200, 30);
		       downloadData.setBounds(870, 450, 100, 30);
		
		          helpPanel.setBounds(50, 30,Default.JFrameX-50,Default.JFrameY);
		       settingPanel.setBounds(50, 30,Default.JFrameX-50,Default.JFrameY);
	}
	
	
	public void mouseClicked(MouseEvent e) {// 单击鼠标时执行的操作 
		if("task".equals(e.getComponent().getName())){
			this.setColour();
			task.setContentAreaFilled(true);
			flag[0]=true;
			task.setBackground(new Color(20,20,20));
			task.setIcon(new ImageIcon(Default.getDynamicIconPath("task1")));//任务icon
			ctlJPanel.remove(logJPanel);
	    	ctlJPanel.remove(downloadPanel);
	    	ctlJPanel.remove(helpPanel);
	    	ctlJPanel.remove(settingPanel);
	    	ctlJPanel.add(taskJPanel);
	    	ctlJPanel.updateUI();
	    }else if("log".equals(e.getComponent().getName())){
	    	this.setColour();
	    	log.setContentAreaFilled(true);
			flag[1]=true;
			log.setBackground(new Color(20,20,20));
			log.setIcon(new ImageIcon(Default.getDynamicIconPath("log1")));//任务icon
	    	
	    	ctlJPanel.remove(taskJPanel);
	    	ctlJPanel.remove(downloadPanel);
	    	ctlJPanel.remove(helpPanel);
	    	ctlJPanel.remove(settingPanel);
	    	ctlJPanel.add(logJPanel);
	    	ctlJPanel.updateUI();
	    }else if("download".equals(e.getComponent().getName())){
	    	this.setColour();
	    	download.setContentAreaFilled(true);
			flag[2]=true;
			download.setBackground(new Color(20,20,20));
			download.setIcon(new ImageIcon(Default.getDynamicIconPath("download1")));//任务icon
	    	
	    	ctlJPanel.remove(taskJPanel);
	    	ctlJPanel.remove(logJPanel);
	    	ctlJPanel.remove(helpPanel);
	    	ctlJPanel.remove(settingPanel);
	    	ctlJPanel.add(downloadPanel);
	    	ctlJPanel.updateUI();
	    }else if("help".equals(e.getComponent().getName())){
	    	this.setColour();
	    	help.setContentAreaFilled(true);
			flag[3]=true;
			help.setBackground(new Color(20,20,20));
			help.setIcon(new ImageIcon(Default.getDynamicIconPath("help1")));//任务icon

	    	ctlJPanel.remove(taskJPanel);
	    	ctlJPanel.remove(logJPanel);
	    	ctlJPanel.remove(downloadPanel);
	    	ctlJPanel.remove(settingPanel);
	    	ctlJPanel.add(helpPanel);
	    	ctlJPanel.updateUI();
	    }else if("setting".equals(e.getComponent().getName())){
	    	this.setColour();
	    	setting.setContentAreaFilled(true);
			flag[4]=true;
			setting.setBackground(new Color(20,20,20));
			setting.setIcon(new ImageIcon(Default.getDynamicIconPath("setting1")));//任务icon

	    	ctlJPanel.remove(taskJPanel);
	    	ctlJPanel.remove(logJPanel);
	    	ctlJPanel.remove(downloadPanel);
	    	ctlJPanel.remove(helpPanel);
	    	ctlJPanel.add(settingPanel);
	    	ctlJPanel.updateUI();
	    }else if("defaultTask".equals(e.getComponent().getName())){
//	    	System.out.println(defaultTask.getSelectedItem().toString());
	    	
	    }else if("startTask".equals(e.getComponent().getName())){
	    	if(!distributionTask.getText().equals("")){
		    	String[] startTaskSet = Operationstring.differenceString(Operationstring.splitString(distributionTask.getText()), Operationstring.extractString(runData));
		    	System.out.println(startTaskSet);
		    	if(startTaskSet.length != 0){
			    	if(Task.beginTask(1,startTaskSet)){
			    		int taskNumber;
			    		if(runJTable.getRowCount()==0){
			    			taskNumber =  1;
			    		}else{
			    			taskNumber = Integer.valueOf((String) runJTable.getValueAt(runJTable.getRowCount()-1,0))+1;
			    		}
			    		for(int i=0 ; i<startTaskSet.length ; i++){
			    			runModel.addRow(new String[]{String.valueOf(taskNumber),startTaskSet[i]});
			    		}
			    		Promptinformation.informationprompt(ctlJFrame,"Successful submission has been done automatically with duplicate tasks and unsupported tasks.");
			    		distributionTask.setText("");
			    	}else{
			    		Promptinformation.errorPrompt(ctlJFrame,"The task submission failed. Check network connections!");
			    	}
		    	}else{
		    		Promptinformation.informationprompt(ctlJFrame,"Please enter the correct url with the currently supported url");
		    	}
	    	}else{
	    		Promptinformation.errorPrompt(ctlJFrame,"Task set is empty, please check!!!");
	    	}
		}else if("endTask".equals(e.getComponent().getName())){
    		if(Promptinformation.confirmPrompt(ctlJFrame,"Confirm termination task?")==0){
    			int selectedRow = runJTable.getSelectedRow(); // 获得选中行索引
    			if(selectedRow!=-1){
    				System.out.println("选中的是:"+runJTable.getValueAt(selectedRow, 1).toString());
    				if(Task.endTask(8,runJTable.getValueAt(selectedRow, 1).toString())){
    					runModel.removeRow(selectedRow); // 删除行
    		    		Promptinformation.informationprompt(ctlJFrame,"successfully deleted");
    				}
    			}else{
		    		Promptinformation.informationprompt(ctlJFrame,"Please select a task");
    			}
    		}
		}else if("refreshData".equals(e.getComponent().getName())){
			if(refresh==null){
				refresh = new Timer();
				refresh.schedule(new TimerTask() {
					public void run() {       
		            	logJPanel.remove(lineChart);
		    			lineChart = Crawlergraph.createLineChart();
		    			logJPanel.add(lineChart);
		    			lineChart.setBounds(10,30,930,400);
		    			logJPanel.updateUI();
		    		}
				},0,10000); //数据刷新频率
			}else{
				logJPanel.remove(lineChart);
    			lineChart = Crawlergraph.createLineChart();
    			logJPanel.add(lineChart);
    			lineChart.setBounds(10,30,930,400);
    			logJPanel.updateUI();
			}
		}else if("picture".equals(e.getComponent().getName())){
			Crawlergraph.savePicture(Crawlergraph.getJFreeChart());
		}else if("browse".equals(e.getComponent().getName())){
		    JFileChooser path = new JFileChooser();
		    path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    int result  =path.showSaveDialog(ctlJFrame);
		    if(result == JFileChooser.APPROVE_OPTION){
		   	 	savePath.setText(path.getSelectedFile().getAbsolutePath());
		    }
		}else if("downloadData".equals(e.getComponent().getName())){
	    	if(savePath.getText().equals("")){
	    		Promptinformation.informationprompt(ctlJFrame,"Please select the save path");
	    	}else{
	    		Promptinformation.informationprompt(ctlJFrame,"Background download starts");
	    		new Thread(){
	    			public void run() {
	    	    		if(Data.downloadData(22,savePath.getText())){
	    	    		   try {
	    	    			   Thread.sleep(5000);
	    	    		   } catch (InterruptedException e) {
	    	    			   e.printStackTrace();
	    	    		   }
	    	    		   Promptinformation.informationprompt(ctlJFrame,"Download completed");
	    	    		}else{
		    	    		   Promptinformation.informationprompt(ctlJFrame,"download failed");
	    	    		}
					}
	    		}.start();
	    	}
		}else if("emptydata".equals(e.getComponent().getName())){
			if(Promptinformation.confirmPrompt(ctlJFrame,"Are you sure you want to empty the downloaded data, which is irrevocable?")==0){
				if(Data.emptyData(21)){
					Promptinformation.informationprompt(ctlJFrame,"Has been emptied");
				}else{
					//清空失败操作  网络异常
				}
			}
		}else if("zoom".equals(e.getComponent().getName())){
			zoom.setIcon(new ImageIcon(Default.getDynamicIconPath("zoom")));//任务icon
			ctlJFrame.setExtendedState(JFrame.ICONIFIED);
		}else if("closeWindow".equals(e.getComponent().getName())){
			System.exit(0);//退出程序
		} 
	}

	public void mousePressed(MouseEvent e) {// 鼠标在组件上按下时执行的操作  
		// 当鼠标按下的时候获得窗口当前的位置
		if("task".equals(e.getComponent().getName())){
			task.setContentAreaFilled(false);
		}else if("log".equals(e.getComponent().getName())){
			log.setContentAreaFilled(false);
		}else if("download".equals(e.getComponent().getName())){
			download.setContentAreaFilled(false);
		}else if("help".equals(e.getComponent().getName())){
			help.setContentAreaFilled(false);
		}else if("setting".equals(e.getComponent().getName())){
			setting.setContentAreaFilled(false);
		}else if("ctlJFrame".equals(e.getComponent().getName())){
			mousePosition.x = e.getX();
			mousePosition.y = e.getY();
		}
	}

	public void mouseReleased(MouseEvent e) {// 鼠标释放时执行的操作  	
	}

	public void mouseEntered(MouseEvent e) {// 鼠标进入组件时执行的操作 
		if("task".equals(e.getComponent().getName())){
			if(!flag[0]){
				task.setIcon(new ImageIcon(Default.getDynamicIconPath("task1")));//任务icon
			}
		}else if("log".equals(e.getComponent().getName())){
			if(!flag[1]){
				log.setIcon(new ImageIcon(Default.getDynamicIconPath("log1")));//任务icon
			}
		}else if("download".equals(e.getComponent().getName())){
			if(!flag[2]){
				download.setIcon(new ImageIcon(Default.getDynamicIconPath("download1")));//任务icon
			}
		}else if("help".equals(e.getComponent().getName())){
			if(!flag[3]){
				help.setIcon(new ImageIcon(Default.getDynamicIconPath("help1")));//任务icon
			}
		}else if("setting".equals(e.getComponent().getName())){
			if(!flag[4]){
				setting.setIcon(new ImageIcon(Default.getDynamicIconPath("setting1")));//任务icon
			}
		}else if("zoom".equals(e.getComponent().getName())){
			if(!flag[8]){
				zoom.setIcon(new ImageIcon(Default.getDynamicIconPath("zoom1")));//任务icon
			}
		}else if("closeWindow".equals(e.getComponent().getName())){
			if(!flag[4]){
				closeWindow.setIcon(new ImageIcon(Default.getDynamicIconPath("close1")));//任务icon
			}
		}else if("startTask".equals(e.getComponent().getName())){
			startTask.setBackground(new Color(255,255,255));
		 }else if("endTask".equals(e.getComponent().getName())){
			endTask.setBackground(new Color(255,255,255));
		 }
	}

	public void mouseExited(MouseEvent e) {//鼠标离开组件时执行的操作 
		if("task".equals(e.getComponent().getName())){
			if(!flag[0]){
				task.setIcon(new ImageIcon(Default.getDynamicIconPath("task")));//任务icon
			}
		}else if("log".equals(e.getComponent().getName())){
			if(!flag[1]){
				log.setIcon(new ImageIcon(Default.getDynamicIconPath("log")));//任务icon
			}
		}else if("download".equals(e.getComponent().getName())){
			if(!flag[2]){
				download.setIcon(new ImageIcon(Default.getDynamicIconPath("download")));//任务icon
			}
		}else if("help".equals(e.getComponent().getName())){
			if(!flag[3]){
				help.setIcon(new ImageIcon(Default.getDynamicIconPath("help")));//任务icon
			}
		}else if("setting".equals(e.getComponent().getName())){
			if(!flag[4]){
				setting.setIcon(new ImageIcon(Default.getDynamicIconPath("setting")));//任务icon
			}
		}else if("startTask".equals(e.getComponent().getName())){
			startTask.setBackground(new Color(	192,192,192));
		 }else if("endTask".equals(e.getComponent().getName())){
			endTask.setBackground(new Color(	192,192,192));
		 }else if("refreshData".equals(e.getComponent().getName())){
			 refreshData.setForeground(new Color(66,139,202));
			 refreshData.setBackground(new Color(245,245,245));
		 }else if("browse".equals(e.getComponent().getName())){
			 browse.setForeground(new Color(66,139,202));
			 browse.setBackground(new Color(245,245,245));
		 }else if("downloadData".equals(e.getComponent().getName())){
			 downloadData.setForeground(new Color(66,139,202));
			 downloadData.setBackground(new Color(245,245,245));
		 }else if("emptydata".equals(e.getComponent().getName())){
			 emptydata.setForeground(new Color(66,139,202));
			 emptydata.setBackground(new Color(245,245,245));
		 }else if("zoom".equals(e.getComponent().getName())){
			if(!flag[8]){
				zoom.setIcon(new ImageIcon(Default.getDynamicIconPath("zoom")));//任务icon
			}
		 }else if("closeWindow".equals(e.getComponent().getName())){
			if(!flag[9]){
				closeWindow.setIcon(new ImageIcon(Default.getDynamicIconPath("close")));//任务icon
			}
		 }
	}
	public static void main(String[] args){ 
		new UI2();
	}
}
