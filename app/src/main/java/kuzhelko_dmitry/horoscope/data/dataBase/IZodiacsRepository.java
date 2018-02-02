package kuzhelko_dmitry.horoscope.data.dataBase;

import java.util.List;

import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public interface IZodiacsRepository {

    Zodiac getZodiac(String zodiacId);

    List<Zodiac> getZodiacs();

    void createDB();
}
