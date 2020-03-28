
package cnprac;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;

public class HTTPClient {
    public static void main(String[] args) throws IOException 
    {
        Socket s2 = new Socket("localhost",6666);
        System.out.println(s2.getPort());
        System.out.println(s2.getLocalPort());
        DataInputStream din = new DataInputStream(s2.getInputStream());
        DataOutputStream dout = new DataOutputStream(s2.getOutputStream());
        String s=din.readUTF();
        URL url = new URL(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
           System.out.println(line);
        }
      }
}
