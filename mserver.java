/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;
import java.io.*;
import java.util.*;
import java.net.*;
 
public class mserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = null;
            try{
                s = ss.accept();
                System.out.println("A new client is connected : " + s);
                
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                 
                System.out.println("Assigning new thread for this client");
                Thread t = new ClientThread(s, dis, dos);
                t.start();
                 
            }
            catch (IOException e){
                s.close();
            }
        }
    }
}
 
class ClientThread extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ClientThread(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
 
    @Override
    public void run() {
        String received;
        while (true) {
            try {
                System.out.println("type msg for client");
                Scanner sc=new Scanner(System.in);
                String s1=sc.nextLine();
                dos.writeUTF(s1);
                
                if(s1.equals("Bye")){
                    while(s!=null){
                        System.out.println("Client " + this.s + " sends exit...");
                        System.out.println("Closing this connection.");
                        this.s.close();
                        System.out.println("Connection closed");
                        break;
                    }
                }
                
                received = dis.readUTF();
                System.out.println(received);
                 
                if(received.equals("Bye")){
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
            } 
            catch (IOException e) {
                System.out.println(e);
            }
        }
         
        try
        {
            this.dis.close();
            this.dos.close();
             
        }
        catch(IOException e){
            System.out.println(e); 
        }
    }
}

