package team.qep.crawler.socket;

public class Download {
	//下载文件  参数保存路径
	 private void download(String path) {  
//	        try {  
//	            inputStream = cs.getMessageStream();  
//	        } catch (Exception e) {  
//	            System.out.print("接收消息缓存错误\n");  
//	            return;  
//	        }  
//	  
//	        try {  
//	            // 本地保存路径，文件名会自动从服务器端继承而来。  
//	            String savePath = "E:\\";  
//	            int bufferSize = 8192;  
//	            byte[] buf = new byte[bufferSize];  
//	            int passedlen = 0;  
//	            long len = 0;  
//	  
//	            savePath += inputStream.readUTF();  
//	            DataOutputStream fileOut = new DataOutputStream(  
//	                    new BufferedOutputStream(new FileOutputStream(savePath)));  
//	            len = inputStream.readLong();  
//	  
//	            System.out.println("文件的长度为:" + len + "\n");  
//	            System.out.println("开始接收文件!" + "\n");  
//	  
//	            while (true) {  
//	                int read = 0;  
//	                if (inputStream != null) {  
//	                    read = inputStream.read(buf);  
//	                }  
//	                passedlen += read;  
//	                if (read == -1) {  
//	                    break;  
//	                }  
//	                // 下面进度条本为图形界面的prograssBar做的，这里如果是打文件，可能会重复打印出一些相同的百分比  
//	                System.out.println("文件接收了" + (passedlen * 100 / len) + "%\n");  
//	                fileOut.write(buf, 0, read);  
//	            }  
//	            System.out.println("接收完成，文件存为" + savePath + "\n");  
//	  
//	            fileOut.close();  
//	        } catch (Exception e) {  
//	            System.out.println("接收消息错误" + "\n");  
//	            return;  
//	        }  
	 }
}
