package network.heart.beat;

import java.io.IOException;  
import java.io.InputStream;
import java.io.OutputStream;  
import java.net.InetSocketAddress;  
import java.net.Socket;  
  
class ThreadClientSocket implements Runnable {  
  
    private static final String HOST = "127.0.0.1";  
  
    private static final int PORT = 1234;  
    
    private int BUFFER_SIZE = 1024;  
      
    private Socket client;  
  
    public ThreadClientSocket() {  
        client = new Socket();  
        try {  
            client.connect(new InetSocketAddress(HOST, PORT), 500);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    @Override  
    public void run() {  
        try {  
        	InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream(); 
            byte[] recData = null;  
            int counter = 0;  
            while (true) {  
                System.out.println("Thread-->"+Thread.currentThread().getName());  
                out.write("Heart Beat !".getBytes());  
                System.out.println(client + "================" + (counter++));  
                try {  
                    Thread.sleep(2000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                } 
                
                recData = new byte[BUFFER_SIZE];
            	int r = in.read(recData);  
                if(r>-1) {  
                    String data = new String(recData);  
                    if(data.trim().equals("over")) {  
                    	client.close();  
                        break;  
                    }  
                    System.out.println(data);  
                }else {  
                    System.out.println("客户端数据读取完毕！");  
                    client.close();  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
