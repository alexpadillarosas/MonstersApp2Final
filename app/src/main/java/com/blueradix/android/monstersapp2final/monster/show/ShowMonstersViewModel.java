package com.blueradix.android.monstersapp2final.monster.show;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.blueradix.android.monstersapp2final.monster.Monster;
import com.blueradix.android.monstersapp2final.monster.MonsterRepository;
import java.util.List;

public class ShowMonstersViewModel extends AndroidViewModel {

    private MonsterRepository monsterRepository;
    private LiveData<List<Monster>> allMonsters;

    public ShowMonstersViewModel(@NonNull Application application) {
        super(application);

        monsterRepository = new MonsterRepository(application);

        allMonsters = monsterRepository.getAllMonsters();
    }

    public void insert(Monster monster){
        monsterRepository.insert(monster);
    }

    public void delete(Monster monster){
        monsterRepository.delete(monster);
    }

    public void update(Monster monster){
        monsterRepository.update(monster);
    }

    public LiveData<List<Monster>> getAllMonsters(){
        return allMonsters;
    }

    public Monster findById(int id){
        return monsterRepository.findById(id);
    }

}