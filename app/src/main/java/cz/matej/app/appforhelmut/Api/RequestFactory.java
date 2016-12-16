package cz.matej.app.appforhelmut.Api;

import android.util.Log;

import java.util.List;

import cz.matej.app.appforhelmut.Activity.MainActivity;
import cz.matej.app.appforhelmut.model.Example;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fanda on 30.10.2016.
 */
public class RequestFactory implements ApiConfig {
    private static final String TAG = MainActivity.class.getSimpleName();



    private static RequestFactory sInstance;
    private OpenUserApi openUserApi;

    public  static RequestFactory getsInstance()
    {
        if (sInstance == null) sInstance = new RequestFactory();
        return sInstance;
    }

    public RequestFactory()
    {
        init();
    }

    public void init()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();
        openUserApi = retrofit.create(OpenUserApi.class);

    }

    private OkHttpClient getHttpClient()
    {
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        return clientBuilder.build();
    }

    public void GetCurrentUser()
    {
        final Example example = new Example();
        final Call<List<Example>> call =
                openUserApi.repoContributors();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
               List<Example> listUsers = response.body();

                Log.d(TAG, "Number of user received: " + listUsers.size());

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }



}
