package com.blueradix.android.monstersapp2final.monster.show;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.monstersapp2final.R;
import com.blueradix.android.monstersapp2final.databinding.ShowMonstersFragmentBinding;
import com.blueradix.android.monstersapp2final.monster.Monster;

import java.util.List;

public class ShowMonstersFragment extends Fragment {

    private ShowMonstersViewModel mViewModel;
    private ShowMonstersFragmentBinding binding;


    public static ShowMonstersFragment newInstance() {
        return new ShowMonstersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ShowMonstersFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShowMonstersViewModel.class);

        //check for the Bundle that arrives
        NavController navController = Navigation.findNavController(view);
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("ADD_MONSTER")){
            Monster monster = (Monster) getArguments().getSerializable("ADD_MONSTER");
            mViewModel.insert(monster);
        }

        binding.monstersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.monstersRecyclerView.setHasFixedSize(true);

        MonsterRecyclerViewAdapter adapter = new MonsterRecyclerViewAdapter();
        binding.monstersRecyclerView.setAdapter(adapter);

        final Observer<List<Monster>> allMonstersObserver = new Observer<List<Monster>>() {
            @Override
            public void onChanged(List<Monster> monsters) {
                //update RecyclerView
                adapter.submitList(monsters);
            }
        };
        mViewModel.getAllMonsters().observe(getViewLifecycleOwner(), allMonstersObserver);

        binding.addMonsterFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_showMonstersFragment_to_addMonsterScrollingFragment);
            }
        });

    }

}