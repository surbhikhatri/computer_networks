
package cn;


import  java.util.*;
class Cn{
    public static void main(String[] args) {
        String text;
        char s;
        int key;
        int k=0,i,j;
        char b[][];
        Scanner sc= new Scanner (System.in);
        System.out.print("Enter the Plain text\n");
        text=sc.nextLine();
        System.out.print(" Enter the no of rails");
        key=sc.nextInt();
        
        b=new char[text.length()][key];
        for(i=0;i<key;i++){
            for(j=0;j<text.length();j++){
                b[j][i]='#';
            }
         }
        i=0;j=0;

        for(;k<text.length();){
            while(j<key){
                if(k==text.length())
                   break;
                b[i][j]=text.charAt(k);
                j++;
                i++;
                k++;
            }   
            j--;
            while(j>0){
                j--;
                if(k==text.length())
                    break;
                b[i][j]=text.charAt(k);
                i++;
                k++;
            }
            j++;
        }
        System.out.println("Cipher Text");
        for(i=0;i<key;i++){
            for(j=0;j<text.length();j++){
                if(b[j][i]!='#')
                System.out.print(b[j][i]);
            }
        }
        System.out.println("\nDecyrpted form");
        for(i=0;i<text.length();i++){
            for(j=0;j<key;j++){
                if(b[i][j]!='#')
                    System.out.print(b[i][j]);
            }
        }
    }
}
