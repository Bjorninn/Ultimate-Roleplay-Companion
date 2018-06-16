package elieser.eu.urc.scenes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import elieser.eu.urc.R;
import elieser.eu.urc.navigation.Navigator;
import elieser.eu.urc.scenes.adnd.AdndMainScene;
import elieser.eu.urc.scenes.genesys.GenesysMainScene;

public class MainScene extends Fragment
{
    public MainScene()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.scene_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ImageButton adndButton = view.findViewById(R.id.adnd_button);
        ImageButton genesysButton = view.findViewById(R.id.genesys_button);

        SetOnClickListener(adndButton, AdndMainScene.class);
        SetOnClickListener(genesysButton, GenesysMainScene.class);
    }

    private void SetOnClickListener(View button, final Class<? extends android.support.v4.app.Fragment> clazz)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigator.navigationEvent(clazz, (AppCompatActivity) getActivity());
            }
        });
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}
