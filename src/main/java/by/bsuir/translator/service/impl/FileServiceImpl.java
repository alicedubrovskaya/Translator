package by.bsuir.translator.service.impl;

import by.bsuir.translator.service.FileService;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileServiceImpl implements FileService {

    @Override
    public String getFromFile(String filePath) {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        StringBuilder result = new StringBuilder();

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                result.append(line + "\n");
            }
        } catch (IOException e) {
        }
        return result.toString();
    }
}
