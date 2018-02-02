package kuzhelko_dmitry.horoscope.presentation.zodiacsList.view;

import android.content.Intent;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public interface IZodiacsView extends MvpView {

    void addDataToAdapter(List<Zodiac> zodiacs);

    void startDetailActivity(Intent intent);

    void startBrowser();

    void showLinkButton();
}
