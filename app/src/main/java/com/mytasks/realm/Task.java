package com.mytasks.realm;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Task extends RealmObject {

    @PrimaryKey
    private long id;
    private String description;
    private boolean isReminderSet;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isReminderSet() {
        return isReminderSet;
    }

    public void setReminderSet(boolean reminderSet) {
        isReminderSet = reminderSet;
    }
}
