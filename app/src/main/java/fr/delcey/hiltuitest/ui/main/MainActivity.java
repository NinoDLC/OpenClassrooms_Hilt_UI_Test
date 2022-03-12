package fr.delcey.hiltuitest.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.delcey.hiltuitest.R;
import fr.delcey.hiltuitest.ui.main.MainFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
        }
    }
}