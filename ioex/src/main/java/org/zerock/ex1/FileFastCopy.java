package org.zerock.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileFastCopy {

    public static void main(String[] args) {

        //try with resource
        try(
            InputStream fin = new FileInputStream("/Users/khan/test/test.jpeg");
            OutputStream fos = new FileOutputStream("/Users/khan/test/copy.jpeg");
        ) {
            byte[] arr = new byte[1024*8]; //8kb

            while(true){
                int count = fin.read(arr); // 몇 개나 새로운 데이터를 읽었는가
                if(count == -1){break;}
                // -1 은 더이상 읽을 데이터가 없다는 뜻
                fos.write(arr, 0, count);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
