package com.example.mymenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("OlaOla");

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar s = Snackbar.make(v, "Contacter l'assistance", BaseTransientBottomBar.LENGTH_LONG);
                s.setAction("Appeler", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0772254947"));
                        startActivity(i);
                    }

                }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
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