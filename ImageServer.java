
package cnprac;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

public class ImageServer {
   public static void main(String[] args) throws IOException {
        ServerSocket s1=new ServerSocket(6666);
        Socket s3=s1.accept();
        File f=new File("C:\\Users\\Surbhi\\Desktop\\sk.jpg");
        BufferedImage im=ImageIO.read(f);
        ImageIO.write(im, "jpg", s3.getOutputStream()); 
        System.out.println("Connection closed");    
        s3.close();
        s1.close();
    } 
}
