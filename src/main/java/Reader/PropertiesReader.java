package Reader;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    // Constructor to load the properties file
    public PropertiesReader(String fileName) {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load properties file: " );
        }
    }

    /*[]* getProperty()--
     *                This Method is used to read the config file and Return the Value int Integer
     * @Parameter-
     *
     * @returnType- int
     * */
    public  String getProperty(String key) {

        return properties.getProperty(key);
    }



    /*[]* getIntProperty()--
    *                This Method is used to read the config file and Return the Value int Integer
    * @Parameter-
    *
    * @returnType- int
    * */
    public  int getIntProperty(String key) {

        return Integer.parseInt(properties.getProperty(key));
    }

    /*[]* getIntProperty()--
     *                This Method is used to read the config file and Return the Value int Integer
     * @Parameter-
     *
     * @returnType- int
     * */
    public  boolean getBooleanProperty(String key) {

        return Boolean.parseBoolean(properties.getProperty(key));
    }

    public  List<String> getPropertyAsList(String propertyKey) throws IOException {
//        Properties properties = new Properties();
//
//        // Load the properties file
//        try (FileInputStream input = new FileInputStream(filePath)) {
//            properties.load(input);
//        }

        // Read the specified property
        String propertyValue = properties.getProperty(propertyKey);

        // Check if propertyValue is not null and split it into a List<String>
        return propertyValue != null ? Arrays.asList(propertyValue.split(",")) : null;
    }


    }


