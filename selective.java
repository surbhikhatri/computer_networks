/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Surbhi
 */
public class selective {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the Window Size: ");
        int window = Integer.parseInt(br.readLine());

        boolean loop = true;
        int sent = 0;
        for(int i = 0; i < window; i++){
             System.out.println("Frame " + sent + " has been transmitted.");
             sent++;
             if(sent == window)
              break;
            }

        while(loop){
            System.out.println("Please enter the last Acknowledgement received.");
            int ack = Integer.parseInt(br.readLine());

            if(ack == window-1)
                loop = false;
            else{
                sent = ack;
                int x=sent+1;
                System.out.println("Frame " +x  + " has been transmitted.");
            }
        }
    }
}
