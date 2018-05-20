package elieser.eu.urc.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import elieser.eu.urc.data.adnd.Spells;

/**
 * Created by bjorn on 21/04/16.
 */
public class JsonLoader
{
    private static String loadJsonFromAsset(Context context, String fileName)
    {
        String json = null;

        try
        {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-16");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return json;
    }

    protected static Spells priestSpellsFromJson(Context context)
    {
        String json = loadJsonFromAsset(context, "all_spells.json");

        Gson gson = new GsonBuilder().create();

        return gson.fromJson(json, Spells.class);
    }
}
