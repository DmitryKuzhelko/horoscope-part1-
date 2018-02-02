package kuzhelko_dmitry.horoscope.data.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("messages1.json")
    Call<String> getJson();

}
