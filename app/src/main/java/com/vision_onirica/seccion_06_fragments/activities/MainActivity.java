package com.vision_onirica.seccion_06_fragments.activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vision_onirica.seccion_06_fragments.R;
import com.vision_onirica.seccion_06_fragments.fragments.DataFragment;
import com.vision_onirica.seccion_06_fragments.fragments.DetailsFragment;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    private boolean isMultipanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultipanel();
    }

    @Override
    public void sendData(String text) {
        if (isMultipanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }
    }

    private void setMultipanel() {
        isMultipanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}
