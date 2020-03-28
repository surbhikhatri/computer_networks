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
public class bitmap {
    public static void main(String[] args) {
        System.out.println("addresses of senders");
        int[][] a=new int[4][4];
        Scanner sc=new Scanner(System.in);
        
        for(int i=0;i<4;i++){
            System.out.println("address for sender "+i);
            for(int j=0;j<4;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                
                if(a[j][i]==0){
                    for(int k=0;k<4;k++){
                        a[j][k]=-1;
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]==1){
                    System.out.println("sender "+i+" will send the data first");
                    break;
                }
            }
        }
    }
}
