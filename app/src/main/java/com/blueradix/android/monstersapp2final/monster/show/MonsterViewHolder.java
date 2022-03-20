package com.blueradix.android.monstersapp2final.monster.show;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.android.monstersapp2final.R;
import com.blueradix.android.monstersapp2final.databinding.RecyclerItemViewBinding;
import com.blueradix.android.monstersapp2final.monster.Monster;

/**
 * We create this view holder representing the recycler_item_view.xml
 * The idea of this class is to create a class that can manipulate the view
 */
public class MonsterViewHolder extends RecyclerView.ViewHolder {

    private RecyclerItemViewBinding binding;

    public MonsterViewHolder(@NonNull RecyclerItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void updateMonster(Monster monster){
        this.binding.monsterNameTextView.setText(monster.getName());
        this.binding.monsterDescriptionTextView.setText(monster.getDescription());
        this.binding.monsterTotalVotesTextView.setText(monster.getVotes() + " Votes");

//        this.binding.monsterImageView.setImageResource(R.drawable.monster_7);

        if(monster.getImage().isEmpty()) {
            this.binding.monsterImageView.setImageResource(R.drawable.monster_7);
        }else{
            int resID = binding.getRoot().getResources().getIdentifier(monster.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
            this.binding.monsterImageView.setImageResource(resID);
        }
    }
}
