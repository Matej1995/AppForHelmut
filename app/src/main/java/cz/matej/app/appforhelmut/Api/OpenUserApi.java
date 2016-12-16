package cz.matej.app.appforhelmut.Api;

import java.util.List;

import cz.matej.app.appforhelmut.model.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Fanda on 30.10.2016.
 */
public interface OpenUserApi {

    @GET(ApiConfig.CURRENT_USER)
    Call<List<Example>> repoContributors();
}
