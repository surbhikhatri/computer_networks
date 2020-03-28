/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import java.io.*;
import java.util.Scanner;
class cdma1{
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Scanner sc=new Scanner(System.in);
    
int keytable[][]=new int[4][8];
int in[]=new int[4];
int data[]=new int[4];
int temp[][]=new int[4][8];
int key3[]=new int[8];

    public void getinput()throws IOException{   
        System.out.println("enter data bits for all 4 stations");
        for(int i=0;i<4;i++)
            in[i]=sc.nextInt();
        
        System.out.println("enter chip sequence for all 4 stations");
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++)
                keytable[i][j]=sc.nextInt();
        }
    }

    public void transmit()throws IOException{
        
        for(int i=0;i<4;i++){
            if (in[i]==0)
                data[i]=-1;
            else
                data[i]=1;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                if(keytable[i][j]==0)
                    temp[i][j]=-1;    
                else
                    temp[i][j]=1;
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                keytable[i][j]=temp[i][j]*data[i]; 
            }
        }
        
        for(int i=0;i<8;i++)
            key3[i]=0;
        
        for(int j=0;j<8;j++){
            for(int i=0;i<4;i++){
                key3[j]=key3[j]+keytable[i][j];
            }
        }
       
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                keytable[i][j]=key3[j]*temp[i][j];
            }
        }
        
        
        int total[]=new int[8];
        for(int i=0;i<8;i++)
            total[i]=0;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
            total[i]=total[i]+keytable[i][j];
            }
        }

        System.out.println("Transformed keys are");
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++)
                System.out.print(temp[i][j]+" ");
            System.out.println("\n");
        }
        
//        for(int i=0;i<4;i++){
//                System.out.print(total[i]+" ");
//        }
        for(int i=0;i<4;i++){
            if(total[i]>=0)
                System.out.println("the data entered by "+i+"th transmitter is 1");
            else
                System.out.println("the data entered by "+i+"th transmitter is 0");
        }
    }
}
    class cdma{
        public static void main(String args[])throws IOException{
            cdma1 c=new cdma1();
            c.getinput();
            c.transmit();
        }
    }
