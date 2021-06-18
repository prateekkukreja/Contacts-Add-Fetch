import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import commons.Utilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Runner {

    static JSONObject object = new JSONObject();
    static JSONArray array = new JSONArray();
    Contact contactObj = new Contact();
//    Utilities utils = new Utilities();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Runner runner = new Runner();

        JSONObject jObj = runner.addContact();
        array.add(jObj);
        writeToFile(array);
        readFromFile();
    }

    private static void readFromFile() {
        String path = "/Users/prateek/CuCumberTest/ContactManagementSyste,/src/main/resources/DataFile.json";
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONArray jObj = (JSONArray) obj;

            Iterator<JSONObject> iter = jObj.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public JSONObject addContact() {

        object.put(contactObj.name, new Utilities().getSaltString());
        object.put(contactObj.mobile, new Utilities().getSaltString());
        object.put(contactObj.email, new Utilities().getSaltString());

        return object;
    }

    public static void writeToFile(JSONArray array) {

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            JsonParser jp = new JsonParser();
//            JsonElement je = jp.parse(array.toJSONString());
//            String prettyJsonString = gson.toJson(je);
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(array.toJSONString());
            mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/DataFile.json"), json);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
