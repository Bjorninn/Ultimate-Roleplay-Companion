package elieser.eu.urc.scenes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import elieser.eu.urc.R;
import elieser.eu.urc.data.adnd.Spell;

public class PriestSpellRecyclerViewAdapter extends RecyclerView.Adapter<PriestSpellRecyclerViewAdapter.ViewHolder>
{
    private final List<Spell> spellList;
    private final OnFragmentInteractionListener listener;

    public PriestSpellRecyclerViewAdapter(List<Spell> spells, OnFragmentInteractionListener listener)
    {
        spellList = new ArrayList<>(spells.size());
        spellList.addAll(spells);

        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_priest_spell, parent, false);

        return new PriestSpellRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        final Spell spell = spellList.get(position);

        holder.level.setText(spell.getLevel().toString());
        holder.name.setText(spell.getName());
        holder.school.setText(String.format("(%s)", spell.getSchool()));
        holder.sphere.setText(spell.getSphere());
        holder.range.setText(spell.getRange());
        holder.duration.setText(spell.getDuration());
        holder.savingThrow.setText(spell.getSave());

        holder.view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (listener != null)
                {
                    listener.onFragmentInteraction(spell);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return spellList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View view;

        public final TextView level;
        public final TextView name;
        public final TextView school;
        public final TextView sphere;
        public final TextView range;
        public final TextView duration;
        public final TextView savingThrow;

        public ViewHolder(View itemView)
        {
            super(itemView);

            view = itemView;

            level = itemView.findViewById(R.id.level);
            name = itemView.findViewById(R.id.name);
            school = itemView.findViewById(R.id.school);
            sphere = itemView.findViewById(R.id.sphere);
            range = itemView.findViewById(R.id.range);
            duration = itemView.findViewById(R.id.duration);
            savingThrow = itemView.findViewById(R.id.saving_throw);
        }
    }
}
