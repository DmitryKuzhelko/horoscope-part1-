package kuzhelko_dmitry.horoscope.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kuzhelko_dmitry.horoscope.data.network.ApiInterface;
import kuzhelko_dmitry.horoscope.data.network.ServiceFactory;
import kuzhelko_dmitry.horoscope.presentation.zodiacsList.view.ZodiacsActivity;
import kuzhelko_dmitry.horoscope.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(SplashActivity.this, ZodiacsActivity.class).putExtra(Constants.JSON, "1"));
//        finish();
        apiInterface = ServiceFactory.getApiInterface();
        Call<String> jsonData = apiInterface.getJson();

        jsonData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                startActivity(new Intent(SplashActivity.this, ZodiacsActivity.class).putExtra(Constants.JSON, response.body()));
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                startActivity(new Intent(SplashActivity.this, ZodiacsActivity.class).putExtra(Constants.JSON, "0"));
                finish();
            }
        });
    }
}