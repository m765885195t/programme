package team.qep.crawler.view;

import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
		   e.printStackTrace();
			}
		new UI();
	}

}
