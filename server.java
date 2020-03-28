/*
 * Surbhi khatri
 * clients and a server
 * 01/08/2018
 */
package cn;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class server {
    public static void main(String[] args) throws IOException {
        String str="hi";
        String str1="hi";int i=0;
        Scanner sc=new Scanner(System.in); 
        Socket s = null;
            ServerSocket ss=new ServerSocket(6666);
           
        try{
            
                s=ss.accept();
                DataInputStream dis=new DataInputStream(s.getInputStream());
                str1=dis.readUTF();
                System.out.println(str1);

                while(!str.contains("bye")){

                    System.out.println("enter message for client");
                    str=sc.nextLine();
                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(str);

                    str1=(String)dis.readUTF();
                    System.out.println(str1);
                }
                s.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}