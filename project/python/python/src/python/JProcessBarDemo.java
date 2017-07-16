package python;
import java.awt.Color;  
import java.awt.FlowLayout;  
  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.JProgressBar;  
import javax.swing.border.EmptyBorder;  
  
  
  
public class JProcessBarDemo extends JFrame{  
  
    private static final long serialVersionUID = 1L;  
    private JProgressBar processBar;  
  
    public JProcessBarDemo(){  
        setTitle("������ʹ��");      //���ô������  
          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô����˳��Ĳ���  
          
        setBounds(100, 100, 250, 100);// ���ô����λ�úʹ�С  
          
        JPanel contentPane = new JPanel();   // �����������  
          
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �����������߿�  
          
        setContentPane(contentPane);// Ӧ��(ʹ��)�������  
          
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));// ����Ϊ��ʽ����  
          
        processBar = new JProgressBar();// ����������  
          
        processBar.setStringPainted(true);// ���ý������ϵ��ַ�����ʾ��false������ʾ  
          
        processBar.setBackground(Color.GREEN);  
      
        // �����߳���ʾ����  
        new Thread(){  
                          
            public void run(){  
                for (int i = 0; i < 101; i++) {  
                    try {  
                        Thread.sleep(100);  //   �õ�ǰ�߳�����0.1ms  
                    } catch (InterruptedException e) {  
                        // TODO: handle exception  
                        e.printStackTrace();  
                    }  
                    processBar.setValue(i); // ���ý�������ֵ  
                }  
                processBar.setString("�������");// ������ʾ��Ϣ  
            }  
        }.start(); //  �����������߳�  
          
        contentPane.add(processBar);// �������ӽ��ȿؼ�  
    }  
      
    public static void main(String[] args){  
        JProcessBarDemo JPBD = new JProcessBarDemo();  
        JPBD.setVisible(true);    
    }  
} 