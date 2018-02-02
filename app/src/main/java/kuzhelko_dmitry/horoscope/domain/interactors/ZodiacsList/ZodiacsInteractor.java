package kuzhelko_dmitry.horoscope.domain.interactors.ZodiacsList;

import java.util.List;

import kuzhelko_dmitry.horoscope.data.dataBase.IZodiacsRepository;
import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;

public class ZodiacsInteractor implements IZodiacsInteractor {

    private IZodiacsRepository zodiacsRepository;

    public ZodiacsInteractor(IZodiacsRepository zodiacsRepository) {
        this.zodiacsRepository = zodiacsRepository;
    }

    @Override
    public List<Zodiac> getZodiacs() {
        return zodiacsRepository.getZodiacs();
    }

    @Override
    public void createDB() {
        zodiacsRepository.createDB();
    }
}