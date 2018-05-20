package elieser.eu.urc.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import elieser.eu.urc.R;
import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.navigation.Navigator;
import elieser.eu.urc.scenes.adnd.AdndMainScene;
import elieser.eu.urc.scenes.adnd.OnSpellChosenListener;
import elieser.eu.urc.scenes.adnd.PriestSpellScene;
import elieser.eu.urc.scenes.adnd.PriestSpellsListScene;

public class AdndActivity extends AppCompatActivity implements OnSpellChosenListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adnd);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AdndMainScene fragment = new AdndMainScene();
        fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack(PriestSpellsListScene.Name);
        fragmentTransaction.commit();
    }

    @Override
    public void onSpellChosen(Spell spell)
    {
        Navigator.navigationEvent(PriestSpellScene.newInstance(spell), this);
    }
}
