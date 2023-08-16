package org.example.Task2.FormatCreator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Task2.User;
import org.example.Task2.ContentReader.ContentReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FormatCreatorImpl implements FormatCreator {
    private final File fromFile;

    public FormatCreatorImpl(File fromFile) {
        this.fromFile = fromFile;
    }

    @Override
    public void toJson() throws IOException {
        List<User> userList = ContentReader.readContent(fromFile);
        new File("src/files/task2.json").createNewFile();
        File toFile = new File("src/files/task2.json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fw = new FileWriter(toFile)){
            fw.write(gson.toJson(userList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}