package com.example.documentrepository;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.documentrepository.Models.MainItems;

/**
 * Created by divyankvijayvergiya on 09/04/18.
 */

public class DocumentActivity extends AppCompatActivity {
    MainItems mainItems;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
      mainItems  = getIntent().getParcelableExtra("items");

    }
}
