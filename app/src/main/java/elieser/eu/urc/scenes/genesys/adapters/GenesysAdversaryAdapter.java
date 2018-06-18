package elieser.eu.urc.scenes.genesys.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import elieser.eu.urc.R;
import elieser.eu.urc.data.genesys.Talent;
import elieser.eu.urc.data.genesys.sw.adversaries.Adversary;


/**
 * Created by Bjorn on 3/11/2018.
 */

public class GenesysAdversaryAdapter extends RecyclerView.Adapter<GenesysAdversaryAdapter.ChooseAdversaryViewHolder> implements Serializable
{
    private final Context context;
    private final GenesysAdversaryAdapterListener listener;
    private List<Adversary> itemData = new ArrayList<>();

    public GenesysAdversaryAdapter(Context context, GenesysAdversaryAdapterListener listener)
    {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public GenesysAdversaryAdapter.ChooseAdversaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);

        return new GenesysAdversaryAdapter.ChooseAdversaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GenesysAdversaryAdapter.ChooseAdversaryViewHolder holder, int position)
    {
        Adversary adversary = itemData.get(position);

        holder.name.setText(adversary.getName());
        holder.brawn.setText(String.valueOf(adversary.getAbilities().getBrawn()));
        holder.agility.setText(String.valueOf(adversary.getAbilities().getAgility()));
        holder.intellect.setText(String.valueOf(adversary.getAbilities().getIntellect()));
        holder.cunning.setText(String.valueOf(adversary.getAbilities().getCunning()));
        holder.willpower.setText(String.valueOf(adversary.getAbilities().getWillpower()));
        holder.presence.setText(String.valueOf(adversary.getAbilities().getPresence()));

        holder.soak.setText(String.valueOf(adversary.getSoak()));
        holder.wounds.setText(String.valueOf(adversary.getWounds()));
        holder.strain.setText(String.valueOf(adversary.getStrain()));

        holder.defense.setText(adversary.getRangedDefence() + " / " + adversary.getMeleeDefence());
    }

    @Override
    public int getItemCount()
    {
        return itemData.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return R.layout.widget_genesys_list_entry_adversary;
    }

    public void setData(List<Adversary> data)
    {
        itemData.clear();
        itemData.addAll(data);

        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
            @Override
            public void run()
            {
                notifyDataSetChanged();
            }
        });
    }

    public class ChooseAdversaryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView name;

        public TextView brawn;
        public TextView agility;
        public TextView intellect;
        public TextView cunning;
        public TextView willpower;
        public TextView presence;

        public TextView soak;
        public TextView wounds;
        public TextView strain;
        public TextView defense;

        public ChooseAdversaryViewHolder(View view)
        {
            super(view);

            name = view.findViewById(R.id.name);

            brawn = view.findViewById(R.id.brawn);
            agility = view.findViewById(R.id.agility);
            intellect = view.findViewById(R.id.intellect);
            cunning = view.findViewById(R.id.cunning);
            willpower = view.findViewById(R.id.willpower);
            presence = view.findViewById(R.id.presence);

            soak = view.findViewById(R.id.soak);
            wounds = view.findViewById(R.id.wounds);
            strain = view.findViewById(R.id.strain);
            defense = view.findViewById(R.id.defenses);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            listener.onItemClicked(name.getText().toString());
        }
    }

    public interface GenesysAdversaryAdapterListener
    {
        void onItemClicked(String adversaryName);
    }

    public static class TalentDataComparator implements Comparator<Talent>
    {
        @Override
        public int compare(Talent t1, Talent t2)
        {
            int compare = t1.getTier().compareTo(t2.getTier());

            if (compare == 0)
            {
                compare = t1.getName().compareTo(t2.getName());
            }

            return compare;
        }

        @Override
        public boolean equals(Object o)
        {
            return false;
        }
    }
}
