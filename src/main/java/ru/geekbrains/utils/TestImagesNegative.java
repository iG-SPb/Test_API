package ru.geekbrains.utils;

public enum TestImagesNegative {
    ImageZero("src/test/resources/picture/pict_zero.jpg"),
    ImageMax10("src/test/resources/picture/pict_max10.jpg"),
    ImageNon("src/test/resources/picture/pict_not.jpg");

    public final String path;

    TestImagesNegative(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
