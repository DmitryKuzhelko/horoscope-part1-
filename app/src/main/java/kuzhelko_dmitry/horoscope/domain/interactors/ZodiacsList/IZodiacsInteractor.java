package kuzhelko_dmitry.horoscope.domain.interactors.ZodiacsList;

import java.util.List;

import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public interface IZodiacsInteractor {

    List<Zodiac> getZodiacs();

    void createDB();
}
