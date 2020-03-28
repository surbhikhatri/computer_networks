/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class inet {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip=InetAddress.getLocalHost();
        System.out.println("host name:"+ip.getHostName());
        System.out.println("host Address:"+ip.getHostAddress());
    
    }
}
    

