package com.mytasks.realm;

import android.content.Context;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class TaskBusinessLayer {

    public TaskBusinessLayer(Context c){
        Realm.init(c);
    }

    public List<Task> getTasks(){
        Realm instance = Realm.getDefaultInstance();

        final RealmResults<Task> tasks = instance.where(Task.class).findAll();

        return tasks.sort("date");
    }

    public void addTask(Task task){
        Realm instance = Realm.getDefaultInstance();

        instance.copyToRealm(task);

        instance.commitTransaction();
    }

}
