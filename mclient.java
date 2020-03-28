/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class mclient{
    public static void main(String[] args) throws IOException {
        try{
            Scanner scn = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 6666);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            while (true){
                String received = dis.readUTF();
                System.out.println(received);
                
                if(received.equals("bye")){
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
                
                System.out.println("enter msg for server");
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);
                
                if(tosend.equals("bye"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
               
            }
             
            // closing resources
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
