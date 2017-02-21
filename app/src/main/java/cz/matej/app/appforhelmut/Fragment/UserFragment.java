package cz.matej.app.appforhelmut.fragment;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cz.matej.app.appforhelmut.api.RequestFactory;
import cz.matej.app.appforhelmut.R;
import cz.matej.app.appforhelmut.adapter.UserAdapter;
import cz.matej.app.appforhelmut.callback.UserListener;
import cz.matej.app.appforhelmut.databinding.UserFragmentBinding;
import cz.matej.app.appforhelmut.model.Example;

/**
 * Created by Fanda on 16.12.2016.
 */
public class UserFragment extends Fragment implements UserListener {

    @Override
    public void callbackUser(List<Example> listUsers) {
        Log.d("List Tag", "List User size" + listUsers.size());

        userAdapter = new UserAdapter(listUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(userAdapter);

    }


    private static final int GRID_ITEMS_COUNT = 3;

    public static UserFragment newInstance()
    {
        return new UserFragment();
    }

    private View mRootView;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        UserFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.user_fragment, container , false);
        init(binding);

        return this.mRootView;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        parseWeather();

    }



    private void init(UserFragmentBinding binding)
    {
        this.mRootView = binding.getRoot();
        this.recyclerView = binding.recyclerView;
    }


    private void parseWeather() {
            RequestFactory.getsInstance().getUsers(this);
    }

    @NonNull
    private LinearLayoutManager getLayoutManager()
    {
        return getResources().getBoolean(R.bool.is_landscape) ?
                new GridLayoutManager(getActivity(), GRID_ITEMS_COUNT) : new LinearLayoutManager(getActivity());
    }

}
