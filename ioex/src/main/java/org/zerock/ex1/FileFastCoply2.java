package org.zerock.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class FileFastCoply2 {

        public static void main(String[] args) {

            //try with resource
            try(
                    InputStream fin = new FileInputStream("/Users/khan/test/sample.txt");
                    OutputStream fos = new FileOutputStream("/Users/khan/test/samplecopy2.txt");
            ) {
                byte[] arr = new byte[6];

                while(true){
                    int count = fin.read(arr); // 몇 개나 새로운 데이터를 읽었는가
                    System.out.println("COUNT: " + count);
                    System.out.println(Arrays.toString(arr));

                    if(count == -1){break;}
                    // -1 은 더이상 읽을 데이터가 없다는 뜻
                    fos.write(arr);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }

        }

}
