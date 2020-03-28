
package cnprac;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws IOException
    {
        ServerSocket s1= new ServerSocket(6666);
        Socket s3= s1.accept();
        DataInputStream din = new DataInputStream(s3.getInputStream());
        DataOutputStream dout = new DataOutputStream(s3.getOutputStream());
        String s="https://docs.oracle.com/javase/7/docs/api/java/net/URL.html";
        dout.writeUTF(s);
    }
}
