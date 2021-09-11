package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void main(String[] args) {

        getProperties();
        setProperties();

    }

    public static void getProperties() {

        try{
            InputStream input = new FileInputStream("src/main/java/config/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println(browser);

        }catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }

    public static void setProperties() {

        try {
            OutputStream output = new FileOutputStream("src/main/java/config/config.properties");
            prop.setProperty("browser", "firefox");
            prop.store(output, null);

        }catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }



    }
}
