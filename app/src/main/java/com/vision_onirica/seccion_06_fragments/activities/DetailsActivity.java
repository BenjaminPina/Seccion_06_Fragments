package com.vision_onirica.seccion_06_fragments.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vision_onirica.seccion_06_fragments.R;
import com.vision_onirica.seccion_06_fragments.fragments.DetailsFragment;

public class DetailsActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().getExtras() != null) {
            text = getIntent().getExtras().getString("text");
        } else {
            text = "";
        }

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }
}
