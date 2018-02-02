package kuzhelko_dmitry.horoscope.presentation.zodiacsList.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;
import kuzhelko_dmitry.horoscope.domain.interactors.ZodiacsList.ZodiacsInteractor;
import kuzhelko_dmitry.horoscope.presentation.detailZodiac.view.ZodiacDetailActivity;
import kuzhelko_dmitry.horoscope.presentation.zodiacsList.view.IZodiacsView;

@InjectViewState
public class ZodiacsPresenter extends MvpPresenter<IZodiacsView> {

    Context context;
    ZodiacsInteractor interactor;

    public ZodiacsPresenter() {
    }

    @Inject
    public ZodiacsPresenter(Context context, ZodiacsInteractor interactor) {
        this.context = context;
        this.interactor = interactor;
    }

    @ProvidePresenter
    ZodiacsPresenter providePresenter() {
        return new ZodiacsPresenter(context, interactor);
    }

    public void setScreen() {
        List<Zodiac> result = interactor.getZodiacs();
        if (result.isEmpty()) {
            interactor.createDB();
        }
        getViewState().addDataToAdapter(result);
    }

    public void OnItemClick(Zodiac zodiac) {
        getViewState().startDetailActivity(ZodiacDetailActivity.getZodiacIntent(context, zodiac));
    }

    public void onBntClick() {
        getViewState().startBrowser();
    }
}