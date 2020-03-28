/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;
import java.util.*;

public class onetime {
    public static void main(String[] args) {
        String s;
        byte b[];
        int k[];
        b=new byte[100];
        String key="";
        String s3="";
        Random r= new Random();
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Plain Text\n");
        s= sc.nextLine();
        String s2="";
        b=s.getBytes();
        
        for(int i=0;i<b.length;i++){
            int p=b[i];
            String s1=Integer.toBinaryString(p);
            s2=s2.concat(s1);
        }
        System.out.println("ASCII value of plain text");
        System.out.println(s2);
        k= new int[s2.length()];
        
        for(int i=0;i<s2.length();i++)
            k[i]=r.nextInt(2);
        
        
        for(int i=0;i<k.length;i++){
            String s1=String.valueOf(k[i]);
            key=key.concat(s1);
        }
        System.out.println("Key");
        System.out.println(key);
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)==(key.charAt(i)))
            s3=s3.concat("0");
            else
                s3=s3.concat("1");
            }
        System.out.println("Cipher Text");
        System.out.println(s3);
        String s4="";
        for(int i=0;i<s3.length();i++){
            if(s3.charAt(i)==(key.charAt(i)))
            s4=s4.concat("0");
            else
            s4=s4.concat("1");
        }
        System.out.println("DECRYPTED MESSAGE");
        System.out.println(s4);
//        for(int j=0;j<s4.length();j++){
//            while(j!=8)
//        
        //int c=Integer.parseInt(s4,2);
        //String ans=new Character((char)c).toString();
        
        System.out.println(s);
        
        
    }
}
