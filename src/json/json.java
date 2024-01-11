package json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class json {
    public static void main(String[] args) throws FileNotFoundException {
        JSONTokener jsonTokener = new JSONTokener(new FileInputStream("./src/json/demo.json"));
        JSONObject jsonObject = new JSONObject(jsonTokener);
        JSONObject address = jsonObject.getJSONObject("address");
        JSONArray phoneNumbers = jsonObject.getJSONArray("phoneNumbers");
        JSONArray children = jsonObject.getJSONArray("children");

        System.out.println(jsonObject.getString("firstName") + " " + jsonObject.getString("lastName") +
                (jsonObject.getBoolean("isAlive") ?
                        " is alive and " + jsonObject.getNumber("age") :
                        " is not alive and was " + jsonObject.getNumber("age")) +
                " years old");
        System.out.println("Address: \n\t" + address.getString("streetAddress") + ", " + address.getString("city") + ", " + address.get("state"));
        System.out.println("\t" + address.getString("postalCode"));
        System.out.println("Phone numbers:");
        for (int i = 0; i < phoneNumbers.length(); i++) {
            JSONObject phoneNumber = phoneNumbers.getJSONObject(i);
            System.out.println("\t" + phoneNumber.getString("number") + " - " + phoneNumber.getString("type"));
        }
        System.out.println("Children:");
        for (int i = 0; i < children.length(); i++) {
            JSONObject child = children.getJSONObject(i);
            System.out.println("\tName: " + child.getString("name"));
        }
        System.out.println("Spouse: " + jsonObject.get("spouse"));
    }
}
