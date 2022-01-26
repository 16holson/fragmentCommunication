package edu.weber.w01311060.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MissleFragment.OnFireListener{

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.fragContainerA, new MissleFragment(), "missle")
                .replace(R.id.fragContainerB, new CounterFragment(), "counter")
                .commit();
    }

    public void onFire()
    {
        Log.d("main", "fire");
    }
}