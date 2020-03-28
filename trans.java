/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import java.util.Scanner;

public class trans {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the text");
        String str= sc.nextLine();
        System.out.println("enter the key");
            int n= sc.nextInt();
            char b[][]= new char[n][str.length()];
            int k=0,j=0,i=0; 
            for(i=0;i<n;i++)
            {
                for(j=0;j<str.length();j++)
                {
                    b[i][j]='#';
                }
            }
            i=0;j=0;
            for(;k<str.length();){
                while(j<n){   
                    if(k==str.length())
                       break;
                    b[j][i]=str.charAt(k);
                    j++;k++;i++;
                }
                j--;
                while(j>0){
                    j--;
                    if(k==str.length())
                       break;
                    b[j][i]=str.charAt(k);
                    i++;
                    k++;
                }
                j++;    
            }
            for(i=0;i<n;i++){
                for(j=0;j<str.length();j++)
                {if(b[i][j]!='#')
                        System.out.print(b[i][j]);
            }
        }
        for(j=0;j<str.length();j++){
                for(i=0;i<n;i++)
                {if(b[i][j]!='#')
                        System.out.print(b[i][j]);
            }
        }
        
    }
}