/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author CSE039
 */
public class client{
    public static void main(String[] args) {  
        try{
            Socket s=new Socket("localhost",6666);
            String str="hello";
            String str1="hello server";
            Scanner sc=new Scanner(System.in);
           
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF("hello server");

            while(!str.contentEquals("bye")){
                DataInputStream dis=new DataInputStream(s.getInputStream());
                str1=(String)dis.readUTF();
                System.out.println(str1);

                System.out.println("enter message for server");
                str=sc.nextLine();
                dout.writeUTF(str);
            }
           
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
      
}

