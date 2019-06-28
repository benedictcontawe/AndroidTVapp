package com.example.androidtvapptutorial.Repository;

import android.content.Context;
import android.util.Log;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonReader {

    private Context context;

    public JsonReader(Context context) {
        this.context = context;
    }

    public String readJsonFile(String jsonFile){
        int resource = context.getResources().getIdentifier(jsonFile, "raw", context.getPackageName());
        Log.e(JsonReader.class.getSimpleName(), "readJsonFile: resource" + resource);

        if (resource == 0) {
            return "[]";
        }
        InputStream resourceReader = context.getResources().openRawResource(resource);

        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, StandardCharsets.UTF_8));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.e(JsonReader.class.getSimpleName(), "readJsonFile: ", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(JsonReader.class.getSimpleName(), "readJsonFile: ", e);
            }
        }

        return writer.toString();
    }
}
