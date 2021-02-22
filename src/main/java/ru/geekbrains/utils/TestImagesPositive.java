package ru.geekbrains.utils;

public enum TestImagesPositive {
    ImageBase("src/test/resources/picture/images.jpg"),
    ImageMin10("src/test/resources/picture/pict_min10.jpg"),
    Image10("src/test/resources/picture/pict_10.jpg"),
    ImageMin("src/test/resources/picture/pict_min.bmp");

    public final String path;

    TestImagesPositive(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
