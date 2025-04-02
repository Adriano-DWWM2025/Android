package com.example.myimc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MenuActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("OlaOla");

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        if (item.getItemId()==R.id.item_search)
            Toast.makeText(this, "Item_Search", Toast.LENGTH_SHORT).show();
        if (item.getItemId()==R.id.item_search2)
            Toast.makeText(this, "item_search2", Toast.LENGTH_SHORT).show();
        if (item.getItemId()==R.id.item_quit1)
            Toast.makeText(this, "item_quit1", Toast.LENGTH_SHORT).show();
        if (item.getItemId()==R.id.item_quit2)
            Toast.makeText(this, "item_quit2", Toast.LENGTH_SHORT).show();
        if (item.getItemId()==R.id.item_quit3)
            Toast.makeText(this, "item_quit3", Toast.LENGTH_SHORT).show();


        return false;

        }
    }

