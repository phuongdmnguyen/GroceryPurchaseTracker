package network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodParser {

    //code adapted prof's JSONparser example

    /**
     * Prints library parsed from JSON data to console
     * @param jsonData  string containing JSON data
     * @throws JSONException when jsonData cannot be parsed as a JSONArray
     */
    public void parseLibrary(String jsonData) throws JSONException {
        JSONObject library = new JSONObject(jsonData);
        JSONArray resultslibrary = library.getJSONArray("results");

        for (int index = 0; index < resultslibrary.length(); index++) {
            JSONObject food = resultslibrary.getJSONObject(index);
            parseFood(food);
        }
    }

    /**
     * Prints book parsed from JSON object to console
     * @param food  a JSON object representing a book
     * @throws JSONException when book does not have a title or an author field
     */
    public static void parseFood(JSONObject food) throws JSONException {
        String dishName = food.getString("title");
        String ingredients = food.getString("ingredients");
        String recipelink = food.getString("href");

        System.out.println("\nDish name: " + dishName);
        System.out.println("\tYou would need these ingredients: " + ingredients);
        System.out.println("\tFollow the recipe found here: " + recipelink);
    }
}
