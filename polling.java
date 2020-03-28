/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import java.util.Scanner;

/**
 *
 * @author Surbhi
 */
public class polling {
    public static void main(String[] args) {
        System.out.println("1 primary 3 secondary");
        int mode=1;
        while(mode!=0){
            System.out.println("1. send  2.receive");
            Scanner sc=new Scanner(System.in);
            mode=sc.nextInt();
            switch(mode){
                case 1: for(int i=0;i<3;i++){
                            System.out.println("SEL "+i);
                            String ans=sc.next();
                            if(ans.equals("ack")){
                                System.out.println("send data to "+i);
                            }
                        }
                        break;
                case 2: for(int i=0;i<3;i++){
                            System.out.println("POLL "+i);
                            String ans=sc.next();
                            if(ans.equals("ack")){
                                System.out.println("RECEIVE data FRoM "+i);
                            }
                        }
                        break;
                case 0:break;

            }
        }
    }
    
}
