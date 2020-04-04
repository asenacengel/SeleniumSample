package EmreSamples.Configurations;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
    private static Properties configFile;

    public Configuration() {

        try{
            String path = System.getProperty("user.dir")+"/configuration.properties";
        FileInputStream input = new FileInputStream(path);
        configFile = new Properties();
        configFile.load(input);
        input.close();
        }catch (Exception exception){
            exception.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    public  String ReadValueByKey(String keyName) {
        return configFile.getProperty(keyName);
    }

    public String DefaultBrowserName(){
        return ReadValueByKey("browser");
    }

    public String DefaultUserName(){
        return ReadValueByKey("store_manager");
    }

    public String DefaultPassword(){
        return ReadValueByKey("password");
    }


}
