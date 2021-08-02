package org.zerock.ex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy2 {

    //bad code
    public static void main(String[] args) throws Exception{

        File file = new File("/Users/khan/Downloads/copy1.jpeg");

        Path filePath = file.toPath();

        OutputStream out = new FileOutputStream("/Users/khan/Downloads/copy2.jpeg");

        Files.copy(filePath, out);
    }
}
