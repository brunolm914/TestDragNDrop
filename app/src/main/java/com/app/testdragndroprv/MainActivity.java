package com.app.testdragndroprv;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Exercise> exercises;
    public Exercise exVal;

    public void initializeData() {
        exercises = new ArrayList<>();

        exercises.add(new Exercise("Jumping Jack", "20x", "http://cdn.instructables.com/FLV/BN83/I8SLTHTQ/FLVBN83I8SLTHTQ.MEDIUM.jpg"));
        exercises.add(new Exercise("Plank", "30sec", "http://blog.myfitnesspal.com/wp-content/uploads/2015/04/Screen-Shot-2015-04-23-at-2.42.19-PM.png"));
        exercises.add(new Exercise("Wall Sits", "30sec", "http://workoutlabs.com/wp-content/uploads/watermarked/Wall_Sit_squat_F_WorkoutLabs.png"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        mRecyclerView.setLayoutManager(llm);

        final Adapter adapter = new Adapter(exercises);
        mRecyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback ithCallback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                // get the viewHolder's and target's positions in your adapter data, swap them
                Collections.swap(adapter.exercises, viewHolder.getAdapterPosition(), target.getAdapterPosition());
                // and notify the adapter that its dataset has changed
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };

        ItemTouchHelper ith = new ItemTouchHelper(ithCallback);
        ith.attachToRecyclerView(mRecyclerView);
    }

}
