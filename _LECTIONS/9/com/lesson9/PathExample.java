package com.lesson9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;

public class PathExample {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("вася.txt");
        final Path lections = path.toAbsolutePath().getParent().resolve("_LECTIONS");
        System.out.println(lections.toAbsolutePath());

    /*    final Path resolve = lections.resolve("new file.txt");
        Files.move(resolve, lections.resolve("moved file.txt"), StandardCopyOption.REPLACE_EXISTING);*/

        Files.write(lections.resolve("moved file.txt"), "какой-то текст".getBytes(), StandardOpenOption.CREATE);


    }
}
