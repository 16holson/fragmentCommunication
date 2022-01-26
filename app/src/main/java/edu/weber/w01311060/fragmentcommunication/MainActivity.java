package edu.weber.w01311060.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MissleFragment.OnFireListener{

    private FragmentManager fm;
    private CounterFragment cf;
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
        if(cf == null)
        {
            cf = (CounterFragment) fm.findFragmentByTag("counter");
        }
        if(cf != null)
        {
            cf.incrementCount();
        }
    }
    public void onReset()
    {
        if(cf == null)
        {
            cf = (CounterFragment) fm.findFragmentByTag("counter");
        }
        if(cf != null)
        {
            cf.resetCount();
        }
    }
}