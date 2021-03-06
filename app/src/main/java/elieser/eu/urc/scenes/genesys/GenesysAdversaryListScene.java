package elieser.eu.urc.scenes.genesys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import elieser.eu.urc.R;
import elieser.eu.urc.data.BundleKeys;
import elieser.eu.urc.data.genesys.GenesysDataStore;
import elieser.eu.urc.data.genesys.Talent;
import elieser.eu.urc.data.genesys.sw.adversaries.Adversary;
import elieser.eu.urc.navigation.Navigator;
import elieser.eu.urc.scenes.genesys.adapters.GenesysAdversaryAdapter;
import elieser.eu.urc.scenes.genesys.adapters.GenesysTalentAdapter;
import elieser.eu.urc.widgets.UrcToolbar;


/**
 * Created by bjornjonsson on 10/03/2018.
 */

public class GenesysAdversaryListScene extends Fragment implements GenesysAdversaryAdapter.GenesysAdversaryAdapterListener
{
    public final static String Name = "Genesys Talent List";

    private GenesysAdversaryAdapter adapter;
    private GenesysTalentAdapter.TalentDataComparator comparator = new GenesysTalentAdapter.TalentDataComparator();


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.scene_genesys_talent_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.talent_list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // specify an adapter (see also next example)
        List<Adversary> adversaries = GenesysDataStore.getInstance().getAdversaries().getAdversaries();
//        Collections.sort(talents, comparator);

        adapter = new GenesysAdversaryAdapter(getActivity(), this);
        recyclerView.setAdapter(adapter);

        adapter.setData(adversaries);

        UrcToolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigator.popFragmentBackStack((AppCompatActivity) getActivity());
            }
        });
    }

    @Override
    public void onItemClicked(String name)
    {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeys.NAME, name);
//        bundle.putInt(BundleKeys.POSITION, position);

        Navigator.navigationEvent(GenesysAdversaryScene.class, bundle, (AppCompatActivity) getActivity());
    }
}
