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
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Runner {

    static JSONObject object = new JSONObject();
    static JSONArray array = new JSONArray();
    Contact contactObj = new Contact();
//    Utilities utils = new Utilities();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many users ? ");
        int n = scan.nextInt();
        Runner runner = new Runner();
        while (n > 0) {
            n--;
            JSONObject jObj = runner.addContact();
            array.add(jObj);
        }
        writeToFile(array);
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
