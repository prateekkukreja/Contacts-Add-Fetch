import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cliftonlabs.json_simple.Jsoner;
import commons.Utilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.rmi.CORBA.Util;
import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    //    Contact contact = new Contact();
    static JSONArray jArr = new JSONArray();
    String path = System.getProperty("user.dir") + "/src/main/resources/DataFile.json";
    static String name = "";
    static String mobile = "";

    public static void main(String[] args) {

        Runner runner = new Runner();
        Scanner scan = new Scanner(System.in);
        runner.writeData();

        System.out.println("Enter input : name or mobile");
        String inp = scan.next();
        System.out.println("Enter value to search");
        String searchVal = scan.next();
        if (inp.toLowerCase(Locale.ROOT).contains("name")) {
            runner.getContactByName(searchVal);
        } else if (inp.toLowerCase(Locale.ROOT).contains("mobile")) {
            runner.getContactByMobile(searchVal);
        }
    }

    private void getContactByMobile(String mobile) {
        try {
            List<String> list = new ArrayList<>();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);
            for (int i = 0; i < parser.size(); i++) {
                if (parser.get(i).get("mobile").toString().equals(mobile) || parser.get(i).get("mobile").toString().contains(mobile))
                    list.add(parser.get(i).get("mobile").toString());
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getContactByName(String name) {
        try {
            List<String> list = new ArrayList<>();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);
            for (int i = 0; i < parser.size(); i++) {
                if (parser.get(i).get("name").toString().equals(name) || parser.get(i).get("name").toString().contains(name))
                    list.add(parser.get(i).get("name").toString());
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeData() {
        JSONArray jArr = new JSONArray();

        try {
            Utilities utils = new Utilities();
            int size = utils.getInt();

            for (int i = 0; i < size; i++) {
                JSONObject contacts = new JSONObject();
                Contact contact = new Contact();

                utils = new Utilities();
                String name = utils.getRandValString();
                Long mobile = utils.getRandValInt();
                contact.setName(name);
                contact.setMobile(mobile);
//                contacts.put(contact.mobile, mobile);

                jArr.add(contact);
            }

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));

            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(jArr));
//            for (int i = 0; i < jArr.size(); i++) {
//                writer.write(mapper.writeValueAsString(jArr.get(i)) + ",\n");
//            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
