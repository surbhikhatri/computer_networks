
package cnprac;

public class CNprac {
    public static void main(String[] args) {
        String str1 = "geekspractice"; 
        String str2 = "nerdspractise";
        System.out.println(hammingDist (str1, str2)); 
    }    
    static int hammingDist(String str1, String str2) 
    { 
        int i = 0, count = 0; 
        while (i < str1.length()) 
        { 
            if (str1.charAt(i) != str2.charAt(i)) 
                count++; 
            i++; 
        } 
        return count; 
    }  
}