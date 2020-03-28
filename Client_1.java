
package cnprac;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    
    public static void main(String[] args) {
        
        try {
            Socket s1 = new Socket("localhost",5000);
            DataInputStream d1 = new DataInputStream(System.in);
            DataOutputStream d2 = new DataOutputStream(s1.getOutputStream());
            DataInputStream in1 = new DataInputStream(s1.getInputStream());
            String line="";
                while(!line.equals("quit")){
                try {
                    line=d1.readLine();
                    d2.writeUTF(line);
                    if(line=="quit")
                        break;
                    line=in1.readUTF();
                    if(line=="quit")
                        break;
                    System.out.println(line);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

