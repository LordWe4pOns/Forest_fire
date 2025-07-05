package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.*;


public class Parameters {
    public int width;
    public int height;
    public double spreadingProbability;

    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGHT = 100;
    public static final double DEFAULT_SPREADING_PROBABILITY = 0.5;

    public static final String CONFIG_PATH = "main/config.json";

    public Parameters() {
        try {
            Path filePath = Path.of(CONFIG_PATH);
            String content;
            content = Files.readString(filePath);
            JSONObject jo = new JSONObject(content);
            final int newWidth = jo.getInt("width");
            final int newHeight = jo.getInt("height");
            final double newSpreadingProbability = jo.getDouble("spreading probability");

            this.width = newWidth > 0 ? newWidth : DEFAULT_WIDTH;
            this.height = newHeight > 0 ? newHeight : DEFAULT_HEIGHT;
            this.spreadingProbability = newSpreadingProbability >= 0.0 && newSpreadingProbability <= 1.0 ? newSpreadingProbability : DEFAULT_SPREADING_PROBABILITY;
        }
        catch (JSONException | IOException e) {
            System.out.println(e);

            this.width = DEFAULT_WIDTH;
            this.height = DEFAULT_HEIGHT;
            this.spreadingProbability = DEFAULT_SPREADING_PROBABILITY;
        }
    }
}
