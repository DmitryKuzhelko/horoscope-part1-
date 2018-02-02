package kuzhelko_dmitry.horoscope.presentation.detailZodiac.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import kuzhelko_dmitry.horoscope.domain.interactors.detailZodiac.ZodiacDetailInteractor;
import kuzhelko_dmitry.horoscope.presentation.detailZodiac.view.IZodiacDetailView;

@InjectViewState
public class ZodiacDetailPresenter extends MvpPresenter<IZodiacDetailView> {

    public ZodiacDetailInteractor interactor;

    public ZodiacDetailPresenter() {
    }

    public ZodiacDetailPresenter(ZodiacDetailInteractor interactor) {
        this.interactor = interactor;
    }

    public void getDetailInfo(String zodiacId) {
        if (zodiacId != null) {
            getViewState().showDetailInfo(interactor.getZodiac(zodiacId));
        }
    }
}