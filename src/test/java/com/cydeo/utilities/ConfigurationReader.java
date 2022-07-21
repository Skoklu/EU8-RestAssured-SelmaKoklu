package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    //public static String getProperty(String Key){return configFile.getProperty();}
}
