package kuzhelko_dmitry.horoscope.presentation.detailZodiac.view;

import com.arellomobile.mvp.MvpView;

import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public interface IZodiacDetailView extends MvpView {

    void showDetailInfo(Zodiac zodiac);
}
