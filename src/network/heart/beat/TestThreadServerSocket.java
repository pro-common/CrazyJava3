package network.heart.beat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
  
class TestThreadServerSocket implements Runnable {  
  
    private Socket server;  
      
    public TestThreadServerSocket(Socket i) {  
        server = i;  
    }  
      
    @Override  
    public void run() {  
        try {  
            InputStream in = server.getInputStream();  
            OutputStream out = server.getOutputStream();  
            Scanner sc = new Scanner(in);  
            PrintWriter pw = new PrintWriter(out,true/*autoFlush*/);  
            pw.println("Hello ! Enter BYE to Exit.");  
            while(sc.hasNextLine()) {  
                String line = sc.nextLine();  
                pw.println("Echo:"+line);  
                if(line.trim().equals("BYE")) {  
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
  

