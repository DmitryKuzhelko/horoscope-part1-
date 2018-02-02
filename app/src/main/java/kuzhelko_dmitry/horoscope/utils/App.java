package kuzhelko_dmitry.horoscope.utils;

import android.app.Application;

import io.realm.Realm;
import kuzhelko_dmitry.horoscope.DI.component.AppComponent;
import kuzhelko_dmitry.horoscope.DI.component.DaggerAppComponent;
import kuzhelko_dmitry.horoscope.DI.modules.ZodiacDetailPresenterModule;
import kuzhelko_dmitry.horoscope.DI.modules.ZodiacsPresenterModule;

public class App extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        component = DaggerAppComponent.builder()
                .zodiacsPresenterModule(new ZodiacsPresenterModule(this))
                .zodiacDetailPresenterModule(new ZodiacDetailPresenterModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }

}
