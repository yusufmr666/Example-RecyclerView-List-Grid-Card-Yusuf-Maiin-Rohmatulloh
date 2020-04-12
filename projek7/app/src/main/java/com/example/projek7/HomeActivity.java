package com.example.projek7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Bem> list = new ArrayList<>();
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private String title = "Mode List";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setActionBarTitle(title);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(BemData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvHeroes.setAdapter(listAdapter);

        listAdapter.setOnItemClickCallback(new ListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bem data) {
                showSelectedHero(data);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
    }
    private void showRecyclerGrid(){
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapter gridAdapter = new GridAdapter(list);
        rvHeroes.setAdapter(gridAdapter);
        gridAdapter.setOnItemClickCallback(new GridAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bem data) {
                showSelectedHero(data);
            }
        });
    }

    private void showRecyclerCardView(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(list);
        rvHeroes.setAdapter(cardViewAdapter);
    }
    private void showSelectedHero(Bem bem) {
        Toast.makeText(this, "Kamu memilih " + bem.getName(), Toast.LENGTH_SHORT).show();
    }


}
