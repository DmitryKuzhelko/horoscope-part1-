package kuzhelko_dmitry.horoscope.DI.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import kuzhelko_dmitry.horoscope.data.dataBase.ZodiacsRepository;
import kuzhelko_dmitry.horoscope.domain.interactors.detailZodiac.ZodiacDetailInteractor;
import kuzhelko_dmitry.horoscope.presentation.detailZodiac.presenter.ZodiacDetailPresenter;

@Module
public class ZodiacDetailPresenterModule {

    Context mContext;

    public ZodiacDetailPresenterModule(Context context) {
        mContext = context;
    }

    @Provides
    ZodiacDetailPresenter provideZodiacDetailPresenter(ZodiacDetailInteractor zodiacDetailInteractor) {
        return new ZodiacDetailPresenter(zodiacDetailInteractor);
    }

    @Provides
    ZodiacDetailInteractor provideZodiacDetailInteractor(ZodiacsRepository zodiacsRepository) {
        return new ZodiacDetailInteractor(zodiacsRepository);
    }
}
