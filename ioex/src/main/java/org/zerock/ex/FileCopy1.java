package org.zerock.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy1 {

    //bad code
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2F4blog.net%2Fresources%2Fimg%2F4blog-widget.png%22&type=m10000_10000");

        InputStream in = url.openStream();

        System.out.println(in);

        OutputStream out = new FileOutputStream("/Users/khan/Downloads/copy1.jpeg");

        long start = System.currentTimeMillis();
        while(true){
            int data = in.read();

            if(data == -1){break;}
            out.write(data);
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
