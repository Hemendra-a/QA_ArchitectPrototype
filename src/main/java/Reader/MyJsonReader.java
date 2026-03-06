package Reader;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;

public class MyJsonReader {

    public static HashMap<String, Object> readJsonObject(Path filePath) {
        try {
            InputStream inputStream = Files.newInputStream(filePath);
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
            return new Gson().fromJson(reader, HashMap.class);
        }
        catch (FileNotFoundException e)
        {e.printStackTrace();}
        catch (IOException e)
        {e.printStackTrace();}

        return (HashMap) Collections.emptyMap();
    }

    public static HashMap<String, Object> readJsonObject(String jsonObjectString) {
        return new Gson().fromJson(jsonObjectString, HashMap.class);

    }
    public static  <T> T readJsonObject(Object jsonObjectString, Class<T> tClass) {
        return new Gson().fromJson(new Gson().toJson( jsonObjectString), tClass);

    }

    public static  <T> T readJsonObject(String jsonObjectString, Class<T> tClass) {
        return new Gson().fromJson(jsonObjectString, tClass);

    }
    public static HashMap<String, Object> readJsonObjectOfGivenKey(Path filePath, String key){

        HashMap<String, Object> hashMap = readJsonObject(filePath);

        return readJsonObject(hashMap.get(key).toString());

    }

}

