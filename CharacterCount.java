
package cnprac;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the frame");
        String frame  = sc.next();
        char c;
        int n,count=0;
        String s = "";
        for(int i = 0; i<frame.length();i++){
            c = frame.charAt(i);
            if(Character.isDigit(c)){
                n = Integer.parseInt(String.valueOf(c));
                System.out.println(s);
                s = "";
                count++;
            }
            else
                s = s+String.valueOf(c);
        }
        System.out.println(s);
        System.out.println("No. of Frames are "+count);
    }
}
