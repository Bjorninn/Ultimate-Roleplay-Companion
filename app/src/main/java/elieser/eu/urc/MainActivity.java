package elieser.eu.urc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.scenes.OnFragmentInteractionListener;
import elieser.eu.urc.scenes.PriestSpells;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener
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
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    PriestSpells fragment = new PriestSpells();
                    fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack("test");
                    fragmentTransaction.commit();

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
    public void onFragmentInteraction(Spell spell)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PriestSpellScene priestSpellScene = PriestSpellScene.newInstance(spell);
        fragmentTransaction.add(R.id.fragment_container, priestSpellScene).addToBackStack("test2");
        fragmentTransaction.commit();
    }
}
