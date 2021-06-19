package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import commons.Utilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONWriter {

    public void writeData(String path) {
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
