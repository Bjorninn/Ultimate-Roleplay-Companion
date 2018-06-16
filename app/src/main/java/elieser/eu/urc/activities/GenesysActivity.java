package elieser.eu.urc.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import elieser.eu.urc.R;
import elieser.eu.urc.data.genesys.GenesysDataStore;
import elieser.eu.urc.scenes.genesys.GenesysTalentListScene;

public class GenesysActivity extends AppCompatActivity
{
    GenesysDataStore genesysDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genesys);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        genesysDataStore = new GenesysDataStore();
        genesysDataStore.loadTalentData(this);

        GenesysTalentListScene fragment = new GenesysTalentListScene();
        fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack(GenesysTalentListScene.Name);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
