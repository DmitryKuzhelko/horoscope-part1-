package kuzhelko_dmitry.horoscope.domain.interactors.detailZodiac;

import kuzhelko_dmitry.horoscope.data.dataBase.IZodiacsRepository;
import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public class ZodiacDetailInteractor implements IZodiacDetailInteractor {

    private IZodiacsRepository zodiacsRepository;

    public ZodiacDetailInteractor(IZodiacsRepository zodiacsRepository) {
        this.zodiacsRepository = zodiacsRepository;
    }

    @Override
    public Zodiac getZodiac(String zodiacId) {
        return zodiacsRepository.getZodiac(zodiacId);
    }
}