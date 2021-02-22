package ru.geekbrains.utils;

import lombok.experimental.UtilityClass;
import java.io.File;
import java.io.IOException;

@UtilityClass
public class FileEncodingUtils {

    private static String inputImageFilePath;

    public byte[] getFileContent() {
        File inputFile = new File(inputImageFilePath);

        byte[] fileContent = new byte[0];
        try {
            fileContent = org.apache.commons.io.FileUtils.readFileToByteArray(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public static void setInputImageFilePath(String inputImageFilePath) {
        FileEncodingUtils.inputImageFilePath = inputImageFilePath;
    }
}
