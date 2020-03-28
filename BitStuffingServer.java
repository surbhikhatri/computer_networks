
package cnprac;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BitStuffingServer {
    public static void main(String[] args) throws IOException 
    { 
        ServerSocket skt = new ServerSocket(6789); 
        Socket socket = skt.accept();   
        DataInputStream dis = new DataInputStream(socket.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
        String s = dis.readUTF(); 
        System.out.println("Stuffed data from client: " + s);   
        System.out.println("Unstuffed data: "); 
        int cnt = 0; 
        for (int i = 8; i < s.length() - 8; i++) { 
            char ch = s.charAt(i); 
            if (ch == '1') { 
                cnt++; 
                System.out.print(ch); 
                if (cnt == 5) { 
                    i++; 
                    cnt = 0; 
                } 
            } 
            else { 
                System.out.print(ch); 
                cnt = 0; 
            } 
        } 
        System.out.println(); 
    } 
}
