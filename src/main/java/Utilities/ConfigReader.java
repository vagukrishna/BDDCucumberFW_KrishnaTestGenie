package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public Properties init_prop()
    {

        prop=new Properties();
        try {
            FileInputStream ip=new FileInputStream("src/test/resources/Config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop;
    }

}
