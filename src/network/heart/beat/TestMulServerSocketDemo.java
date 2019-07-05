package network.heart.beat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestMulServerSocketDemo {  
	  
    private static final int PORT = 1234;  
      
    //private static final int BUFFER_SIZE = 1024;  
      
    public static void main(String[] args) throws IOException {  
        int counter = 1;  
        ServerSocket ss = new ServerSocket(PORT);  
        while(true) {  
            Socket s = ss.accept();  
            System.out.println("第 "+(counter++)+" 个连接");  
            Thread t = new Thread(new TestThreadServerSocket(s));  
            t.start();  
        }  
    }  
  
} 
