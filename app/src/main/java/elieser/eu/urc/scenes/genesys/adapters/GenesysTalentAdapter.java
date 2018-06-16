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
import elieser.eu.urc.scenes.genesys.TalentHelper;


/**
 * Created by Bjorn on 3/11/2018.
 */

public class GenesysTalentAdapter extends RecyclerView.Adapter<GenesysTalentAdapter.ChooseTalentViewHolder> implements Serializable
{
    private final Context context;
    private final GenesysTalentAdapterListener listener;
    private List<Talent> itemData = new ArrayList<>();

    public GenesysTalentAdapter(Context context, GenesysTalentAdapterListener listener)
    {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public GenesysTalentAdapter.ChooseTalentViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);

        return new ChooseTalentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GenesysTalentAdapter.ChooseTalentViewHolder holder, int position)
    {
        Talent talent = itemData.get(position);

        holder.position = position;
        holder.name.setText(TalentHelper.createNameSpannable(talent.getName()));
        holder.tier.setText(talent.getTier().toString());
        holder.ranked.setText(talent.getRanked().toString());
        holder.activation.setText(talent.getActivation());
        holder.description.setText(talent.getDescription());
    }

    @Override
    public int getItemCount()
    {
        return itemData.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return R.layout.widget_genesys_talent_list_entry;
    }

    public void setData(List<Talent> data)
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

    public Talent getTalent(int position)
    {
        return itemData.get(position);
    }

    public class ChooseTalentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public int position;
        public TextView name;
        public TextView tier;
        public TextView ranked;
        public TextView activation;
        public TextView description;

        public ChooseTalentViewHolder(View view)
        {
            super(view);

            name = view.findViewById(R.id.talent_name);
            tier = view.findViewById(R.id.talent_tier);
            activation = view.findViewById(R.id.talent_activation);
            ranked = view.findViewById(R.id.talent_ranked);
            description = view.findViewById(R.id.talent_description);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            listener.onItemClicked(name.getText().toString(), position);
        }
    }

    public interface GenesysTalentAdapterListener
    {
        void onItemClicked(String talentName, int position);
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
