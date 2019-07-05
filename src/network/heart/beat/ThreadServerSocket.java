package network.heart.beat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
  
class ThreadServerSocket implements Runnable {  
  
    private Socket server;  
      
    private int BUFFER_SIZE = 1024;  
      
    public ThreadServerSocket(Socket i) {  
        server = i;  
    }  
      
    @Override  
    public void run() {  
        try {  
            InputStream in = server.getInputStream();  
            OutputStream out = server.getOutputStream();  
            byte[] recData = null;  
            while(true) {  
                recData = new byte[BUFFER_SIZE];  
                int r = in.read(recData);  
                if(r>-1) {  
                    String data = new String(recData);  
                    if(data.trim().equals("over")) {  
                        server.close();  
                        break;  
                    }  
                    System.out.println("读取到客户端发送来的数据："+data);  
                    out.write("这是服务端发给客户端的数据：".getBytes());  
                    out.write(recData);  
                }else {  
                    System.out.println("服务端数据读取完毕！");  
                    server.close();  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                server.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
    }  
      
} 
