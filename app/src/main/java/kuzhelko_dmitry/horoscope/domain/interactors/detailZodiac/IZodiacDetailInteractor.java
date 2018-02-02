package kuzhelko_dmitry.horoscope.domain.interactors.detailZodiac;

import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public interface IZodiacDetailInteractor {

    Zodiac getZodiac(String noteId);
}