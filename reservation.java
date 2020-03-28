/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Surbhi
 */
public class reservation {
    public static void main(String[] args) throws InterruptedException {
        int[] res=new int[5];
        while(true){
            System.out.println("reserve your periods");
            Scanner sc=new Scanner(System.in);
            for(int i=0;i<5;i++){
                System.out.print("sender "+i+" ");
                res[i]=sc.nextInt();
            }
            for(int i=0;i<5;i++){
                if(res[i]==1){
                    System.out.println("sender "+i+" sending data");
                    sleep(3000);
                }
            }
        }
    }
    
}
