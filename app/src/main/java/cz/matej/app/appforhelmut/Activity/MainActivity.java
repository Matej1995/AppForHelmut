package cz.matej.app.appforhelmut.activity;

import android.databinding.DataBindingUtil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import cz.matej.app.appforhelmut.R;
import cz.matej.app.appforhelmut.databinding.ActivityMainBinding;
import cz.matej.app.appforhelmut.fragment.UserFragment;


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
                .replace(R.id.userFragment, UserFragment.newInstance())
                .commit();

    }
}
