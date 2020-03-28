
package cnprac;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class MTServer{
    Socket s2= null;
    public MTServer(){
        try {
            ServerSocket a = new ServerSocket(5000);
            System.out.println(a);
            while(true)
            {
                s2=a.accept();
                System.out.println(s2);
                SocketThread ms1= new SocketThread(s2);   
            }
        } catch (IOException ex) {
            Logger.getLogger(MTServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private class SocketThread extends Thread{
        Socket soc;
        DataInputStream in1= null;
        DataInputStream d1=null;
        DataOutputStream d2= null;
        SocketThread(Socket st){
            try {
                this.soc=st;
                in1 = new DataInputStream(st.getInputStream());
                d2 = new DataOutputStream(st.getOutputStream());
                d1 = new DataInputStream(System.in);
                start();

            } catch (IOException ex) {
                Logger.getLogger(SocketThread.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.out.println("");
            }

        }
        @Override
        public void run()
        {
            String line1="";
                while(!line1.equals("quit"))
                {
                try {
                    line1=in1.readUTF();
                    System.out.println(line1);
                    if(line1.equals("quit"))
                        break;
                    line1=d1.readLine();
                    d2.writeUTF(line1);
                } catch (IOException ex) {
                    Logger.getLogger(SocketThread.class.getName()).log(Level.SEVERE, null, ex);
                }

                }
        }
    }
}
public class Server {
    public static void main(String[] args) {
        MTServer mt1 = new MTServer();
    }
}
