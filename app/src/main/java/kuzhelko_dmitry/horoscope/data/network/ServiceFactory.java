package kuzhelko_dmitry.horoscope.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ServiceFactory {

    private static Retrofit retrofit;
    public static ApiInterface apiInterface = getApiInterface();
    private static final String URL = "https://raw.githubusercontent.com/startandroid/data/master/messages/";

    public static ApiInterface getApiInterface() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;
    }
}
