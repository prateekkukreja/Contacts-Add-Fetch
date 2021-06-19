//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//
//import java.io.File;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class AddContact {
//
//    Gson g = new Gson();
//    ObjectMapper mapper = new ObjectMapper();
//    JSONParser parser = new JSONParser();
//
//    public AddContact(JSON.Contact details) {
//        try {
//            String json = details.toString();
//            UserInput user = g.fromJson(json, UserInput.class);
////            JSONObject jsonObj = (JSONObject) parser.parse(json);
//
//            mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/DataFile.json"), json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
