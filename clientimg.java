/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;
//

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;



public class clientimg {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",6666);
        DataInputStream dis = new DataInputStream(s.getInputStream());
            FileOutputStream fos = new FileOutputStream("F:\\outs.jpg");
            byte[] buffer = new byte[40960];

            int filesize = 151230; 
            int read = 0;
            int totalRead = 0;
            int remaining = filesize;
           
            while((read = dis.read(buffer, 0, buffer.length)) > 0) {

                    fos.write(buffer, 0, read);
            }
            fos.close();
            dis.close();
        }

}