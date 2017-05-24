package com.mytasks;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mytasks.forms.add.AddFormPageAdapter;

import java.util.ArrayList;
import java.util.List;

import layout.TaskDateFragment;
import layout.TaskDescriptionFragment;
import layout.TaskTimeFragment;

public class AddActivity extends AppCompatActivity {

    private AddFormPageAdapter pageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        List<Fragment> fragments = getFragments();

        this.pageAdapter = new AddFormPageAdapter(getSupportFragmentManager(), fragments);

        this.viewPager = (ViewPager)findViewById(R.id.view_pager);
        this.viewPager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new TaskDescriptionFragment());
        fragments.add(new TaskDateFragment());
        fragments.add(new TaskTimeFragment());

        return fragments;
    }

    public void jumpToPage(View view) {
        this.viewPager.setCurrentItem(Math.min(this.pageAdapter.getCount(), this.viewPager.getCurrentItem() + 1));
    }

    public void addTaskDone(View view) {
        Intent i = new Intent(this, MainActivity.class);
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        startActivity(i, options.toBundle());
    }
}
