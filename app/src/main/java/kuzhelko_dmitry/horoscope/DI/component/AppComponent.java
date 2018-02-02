package kuzhelko_dmitry.horoscope.DI.component;

import dagger.Component;
import kuzhelko_dmitry.horoscope.DI.modules.ZodiacDetailPresenterModule;
import kuzhelko_dmitry.horoscope.DI.modules.ZodiacsPresenterModule;
import kuzhelko_dmitry.horoscope.presentation.detailZodiac.view.ZodiacDetailActivity;
import kuzhelko_dmitry.horoscope.presentation.zodiacsList.view.ZodiacsActivity;

@Component(modules = {ZodiacsPresenterModule.class, ZodiacDetailPresenterModule.class})
public interface AppComponent {

    void inject(ZodiacsActivity zodiacsActivity);
    void inject(ZodiacDetailActivity zodiacDetailActivity);
}