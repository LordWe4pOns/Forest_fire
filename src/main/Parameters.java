package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.*;


public class Parameters {
    public int width;
    public int height;
    public double spreadingProbability;
    public int[][] burningTreesCoords;

    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGHT = 100;
    public static final double DEFAULT_SPREADING_PROBABILITY = 0.5;

    public static final String CONFIG_PATH = "main/config.json";

    public Parameters() {
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.spreadingProbability = DEFAULT_SPREADING_PROBABILITY;
        this.burningTreesCoords = null;

        try {
            Path filePath = Path.of(CONFIG_PATH);
            String content;
            content = Files.readString(filePath);
            JSONObject jo = new JSONObject(content);
            final int newWidth = jo.getInt("width");
            final int newHeight = jo.getInt("height");
            final double newSpreadingProbability = jo.getDouble("spreading probability");

            this.width = verifyWidth(newWidth) ? newWidth : DEFAULT_WIDTH;
            this.height = verifyHeight(newHeight) ? newHeight : DEFAULT_HEIGHT;
            this.spreadingProbability = newSpreadingProbability >= 0.0 && newSpreadingProbability <= 1.0 ? newSpreadingProbability : DEFAULT_SPREADING_PROBABILITY;
            createBurningTreeCoords(jo.getJSONArray("burning trees coords"));
        }
        catch (JSONException | IOException e) {
            System.out.println(e);
        }
    }

    public static boolean verifyWidth(int width) {
        return width > 0;
    }

    public static boolean verifyHeight(int height) {
        return height > 0;
    }

    private void createBurningTreeCoords(JSONArray jarr) {
        this.burningTreesCoords = new int[jarr.length()][2];
        for (int i = 0; i < jarr.length(); i++) {
            try {
                JSONObject jo = jarr.getJSONObject(i);
                this.burningTreesCoords[i][0] = jo.getInt("x");
                this.burningTreesCoords[i][1] = jo.getInt("y");
            } catch (JSONException e) {
                System.out.println(e);
                this.burningTreesCoords = null;
            }
        }
    }
}
