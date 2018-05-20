package elieser.eu.urc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import elieser.eu.urc.R;
import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.scenes.adnd.OnSpellChosenListener;
import elieser.eu.urc.scenes.adnd.PriestSpellScene;

public class MainActivity extends AppCompatActivity implements OnSpellChosenListener
{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.navigation_adnd:
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                    PriestSpellsListScene fragment = new PriestSpellsListScene();
//                    fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack("test");
//                    fragmentTransaction.commit();

                    Intent myIntent = new Intent(MainActivity.this, AdndActivity.class);
                    MainActivity.this.startActivity(myIntent);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
