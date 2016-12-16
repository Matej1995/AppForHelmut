package cz.matej.app.appforhelmut.Activity;

import android.databinding.DataBindingUtil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import cz.matej.app.appforhelmut.Fragment.UserFragment;
import cz.matej.app.appforhelmut.R;
import cz.matej.app.appforhelmut.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initFragment();

    }

    public void initFragment()
    {

        getSupportFragmentManager()
                .beginTransaction()
                 // .replace(R.id.userFragment, UserFragment.newInstance())
                .commit();

    }
}
