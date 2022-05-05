package main.java.helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class UtilsHelpers {
    public static String getProperties(String fileName, String propertyName) throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/properties/urlProperties/" + fileName;
        FileReader file = new FileReader(filePath);
        Properties properties = new Properties();
        properties.load(file);
        String property = properties.getProperty(propertyName);
        return property;
    }
}
