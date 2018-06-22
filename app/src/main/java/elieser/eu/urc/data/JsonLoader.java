package elieser.eu.urc.data;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import elieser.eu.urc.data.adnd.Spells;
import elieser.eu.urc.data.genesys.Talents;
import elieser.eu.urc.data.genesys.sw.adversaries.wrappers.Adversaries;
import elieser.eu.urc.data.genesys.sw.equipment.wrappers.Weapons;

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


    public static Talents genesysTalentsFromJson(Context context)
    {
        String json = loadJsonFromAsset(context, "genesys-talents.json");

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        return gson.fromJson(json, Talents.class);
    }

    public static Adversaries genesysAdversariesFromJson(Context context)
    {
        String json = loadJsonFromAsset(context, "genesys/Adversaries.json");

        Gson gson = new GsonBuilder().create();

        return gson.fromJson(json, Adversaries.class);
    }

    public static Weapons genesysWeaponsFromJson(Context context)
    {
        String json = loadJsonFromAsset(context, "genesys/Weapons.json");

        Gson gson = new GsonBuilder().create();

        return gson.fromJson(json, Weapons.class);
    }
}
