package kuzhelko_dmitry.horoscope.DI.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import kuzhelko_dmitry.horoscope.data.dataBase.ZodiacsRepository;
import kuzhelko_dmitry.horoscope.domain.interactors.ZodiacsList.ZodiacsInteractor;
import kuzhelko_dmitry.horoscope.presentation.zodiacsList.presenter.ZodiacsPresenter;

@Module
public class ZodiacsPresenterModule {

    Context mContext;

    public ZodiacsPresenterModule(Context context) {
        mContext = context;
    }

    @Provides
    ZodiacsPresenter provideZodiacsPresenter(ZodiacsInteractor zodiacsInteractor) {
        return new ZodiacsPresenter(mContext, zodiacsInteractor);
    }

    @Provides
    ZodiacsInteractor provideZodiacsInteractor(ZodiacsRepository zodiacsRepository) {
        return new ZodiacsInteractor(zodiacsRepository);
    }

    @Provides
    ZodiacsRepository provideZodiacsRepository() {
        return new ZodiacsRepository(mContext);
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}