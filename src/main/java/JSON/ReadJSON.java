package JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {

    public void getContactByMobile(String mobile, String path) {
        try {
            List<String> list = new ArrayList<>();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);
            for (int i = 0; i < parser.size(); i++) {
                if (parser.get(i).get("mobile").toString().equals(mobile) || parser.get(i).get("mobile").toString().contains(mobile))
                    list.add(parser.get(i).get("mobile").toString());
                else
                    throw new Exception("Add more text in search");
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getContactByName(String name, String path) {
        try {
            List<String> list = new ArrayList<>();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);
            for (int i = 0; i < parser.size(); i++) {
                if (parser.get(i).get("name").toString().equals(name) || parser.get(i).get("name").toString().contains(name))
                    list.add(parser.get(i).get("name").toString());
                else
                    throw new Exception("Add more text in search");
                getContactByName(name + "a", path);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
