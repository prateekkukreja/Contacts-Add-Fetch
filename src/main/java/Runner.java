import JSON.JSONWriter;
import JSON.ReadJSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cliftonlabs.json_simple.Jsoner;
import commons.GlobalVariables;
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

    static JSONArray jArr = new JSONArray();
    static GlobalVariables var = new GlobalVariables();
    static JSONWriter jsonWriter = new JSONWriter();
    static ReadJSON jsonReader = new ReadJSON();

    public static void main(String[] args) {

        var.path = System.getProperty("user.dir") + "/src/main/resources/DataFile.json";
        Runner runner = new Runner();
        Scanner scan = new Scanner(System.in);
        jsonWriter.writeData(var.path);

        System.out.println("Enter input : name or mobile");
        String inp = scan.next();
        System.out.println("Enter value to search");
        String searchVal = scan.next();
        if ("name".contains(inp.toLowerCase(Locale.ROOT))) {
            jsonReader.getContactByName(searchVal, var.path);
        } else if ("mobile".contains(inp.toLowerCase(Locale.ROOT))) {
            jsonReader.getContactByMobile(searchVal, var.path);
        }
    }
}
