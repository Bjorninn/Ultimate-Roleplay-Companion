package elieser.eu.urc.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import elieser.eu.urc.R;
import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.data.genesys.GenesysDataStore;
import elieser.eu.urc.scenes.MainScene;
import elieser.eu.urc.scenes.adnd.OnSpellChosenListener;
import elieser.eu.urc.scenes.adnd.PriestSpellScene;

public class MainActivity extends AppCompatActivity implements OnSpellChosenListener
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MainScene mainScene = new MainScene();
        fragmentTransaction.add(R.id.fragment_container, mainScene).addToBackStack(MainScene.class.getName());
        fragmentTransaction.commit();
    }

    @Override
    public void onSpellChosen(Spell spell)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PriestSpellScene priestSpellScene = PriestSpellScene.newInstance(spell);
        fragmentTransaction.add(R.id.fragment_container, priestSpellScene).addToBackStack("test2");
        fragmentTransaction.commit();
    }
}
