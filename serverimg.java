/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;


import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class serverimg {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket s2=ss.accept();
        FileInputStream f=new FileInputStream("C:\\Users\\Surbhi\\Desktop\\world.jpg");
        DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
        byte[] buffer = new byte[40960];
        while (f.read(buffer) > 0) {
            dos.write(buffer);
        }
        s2.close();
        f.close();
        dos.close();
    }
}