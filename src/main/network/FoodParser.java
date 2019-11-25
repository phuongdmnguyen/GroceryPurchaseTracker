package network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodParser {

    //code adapted prof's JSONparser example

    //REQUIRES: jsonData in String type
    //EFFECTS: print library parsed from JSON data
    public void parseLibrary(String jsonData) throws JSONException {
        JSONObject library = new JSONObject(jsonData);
        JSONArray resultslibrary = library.getJSONArray("results");

        for (int index = 0; index < resultslibrary.length(); index++) {
            JSONObject food = resultslibrary.getJSONObject(index);
            parseFood(food);
        }
    }

    //REQUIRES: JSONObject
    //EFFECTS: print recipe item parsed from JSONObject
    public static void parseFood(JSONObject food) throws JSONException {
        String dishName = food.getString("title");
        String ingredients = food.getString("ingredients");
        String recipelink = food.getString("href");

        System.out.println("\nDish name: " + dishName);
        System.out.println("\tYou would need these ingredients: " + ingredients);
        System.out.println("\tFollow the recipe found here: " + recipelink);
    }
}
