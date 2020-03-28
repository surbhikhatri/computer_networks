
package cn;
/*
author:surbhi khatri
*/
import java.util.Scanner;
public class crc {
    int data[];
    int poly[],n,m;
    int c[],rem[],send[];
    crc(){
        data= new int[50];
        poly= new int[50];
        c= new int [50];
        for(int i=0;i<n;i++)
            c[i]= 0;
        rem= new int [50];
        send= new int [50];
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of data");
        n= sc.nextInt();
        System.out.println("Enter the size of poly");
        m= sc.nextInt();
        System.out.println("Enter the data");
        for(int i=0;i<n;i++)
            data[i]= sc.nextInt();
        
        System.out.println("Enter the generated polynomial");
        for(int i=0;i<m;i++)
            poly[i]= sc.nextInt();
        
        for(int i=n;i<n+m-1;i++){
           data[i]=0;
        }
        
        for(int i=0;i<n+m-1;i++)
            rem[i]=data[i];
        System.out.println("rough crc");
        for(int i=0;i<n+m-1;i++)
            System.out.print(rem[i]);
        
        
        rem=division(rem,poly,n,m);
        System.out.println("CRC");
        for(int i=0;i<n+m-1;i++){
            c[i]=data[i]^rem[i];
        }
            
        for(int i=0;i<n+m-1;i++)
            System.out.print(c[i]);
        
        System.out.println("Data send to reciver");
        for(int i=0;i<n+m-1;i++)
            send[i]= sc.nextInt();
        send= division(send,poly,n,m);
        int counter=0; 
        
        for(int i=0;i<n+m-1;i++){
            if(send[i]==0)
                counter++;
            }
        if(counter==(n+m-1))
            System.out.println("ERROR NOT DETECTED");
        else
            System.out.println("error detected");
    }
    int[] division(int rem[],int div[],int n,int m){
        int cur=0;
        while(true){
            for(int i=0;i<m;i++){
                rem[i+cur]=rem[i+cur]^div[i];
            }
            cur=0;
            for(int i=0;i<n+m-1;i++){
                if(rem[i]==0)
                    cur= cur+1;
                else
                    break;
            }
            if(((n+m-1)-cur)<m)
                break;
        }
        return rem;  
    }
}
class demo{
    public static void main(String[] args) {
        crc c= new crc();
    }
}
