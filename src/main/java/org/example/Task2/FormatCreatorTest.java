package org.example.Task2;

import org.example.Task2.FormatCreator.FormatCreator;
import org.example.Task2.FormatCreator.FormatCreatorImpl;

import java.io.File;
import java.io.IOException;

public class FormatCreatorTest {
    public static void main(String[] args) throws IOException {
        FormatCreator jsonFormatCreator = new FormatCreatorImpl(new File("src/files/task2.txt"));
        jsonFormatCreator.toJson();
    }
}
