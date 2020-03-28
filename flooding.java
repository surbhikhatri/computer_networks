/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

public class flooding {

   
static int k;
   static boolean packed_reached=false;

   static  int hopcount(int adjmat[][],int nodes){

        int hop=0;

        for(int i=1;i<nodes;i++){

            for(int j=1;j<nodes;j++){

                hop+=adjmat[i][j];

            }

        }

        hop-=nodes;

        hop=(hop%2==0)?(hop/2):(hop/2+1);        

        return hop;

    }
static void showMatrix(int adjmat[][],int nodes){
       for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(j==0){
                    System.out.print(adjmat[i][j]+"\t");
                }
                else
                    System.out.print(adjmat[i][j]+"  ");
            }
            System.out.println("\n");
        }

    }

    static void calculate(int adjmat[][],int nodes,int prev,int src,int dest,int hop){
         
        if(packed_reached)
           return;
        if(src==dest){
            System.out.println("Packet Reached destination with hop count= "+hop);
            packed_reached=true;
            return;
       }
        if(hop==0){
           System.out.println("Hop count Expired, Packet is discarded by node= "+src);
           return;
       }
    int count=0;
       for(int j=1;j<nodes;j++){

           if(adjmat[src][j]==1 && src!=j){
               if(j!=prev){
                    count++;
               }
           }
       }
       System.out.println("packets in iteration "+k+" are "+count);

       

       System.out.println("\n\n");

        for(int j=1;j<nodes;j++){

           if(adjmat[src][j]==1 && src!=j){

               if(j!=prev){
                   k++;
                   calculate(adjmat, nodes, src, j, dest, hop-1);

               }

           }

       }
   }

    

    

     public static void main(String[] args) {

        int adjadjmat[][]={{0,1,2,3,4,5,6},{1,1,1,0,0,1,0},{2,1,1,1,1,0,1},
                         {3,0,1,1,1,1,1},{4,0,1,1,1,1,0},{5,1,0,1,1,1,1},{6,0,1,1,0,1,1}};
        int nodes=7;

         showMatrix(adjadjmat, nodes);

         

         int src=1;

         int hop=hopcount(adjadjmat, nodes);

         int dest=5;

         calculate(adjadjmat, nodes, 0, src, dest, hop);

    }

}
