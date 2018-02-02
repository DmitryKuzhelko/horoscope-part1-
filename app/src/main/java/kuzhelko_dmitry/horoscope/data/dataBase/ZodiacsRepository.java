package kuzhelko_dmitry.horoscope.data.dataBase;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import kuzhelko_dmitry.horoscope.R;
import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;
import kuzhelko_dmitry.horoscope.utils.Constants;
public class ZodiacsRepository implements IZodiacsRepository {

    Context context;
    private Realm mRealm = Realm.getDefaultInstance();

    public ZodiacsRepository() {
    }

    public ZodiacsRepository(Context context) {
        this.context = context;
    }

    @Override
    public Zodiac getZodiac(String zodiacId) {
        return mRealm.where(Zodiac.class).equalTo(Constants.ID, zodiacId).findFirst();
    }

    @Override
    public List<Zodiac> getZodiacs() {
        return mRealm.where(Zodiac.class).findAll();
    }

    @Override
    public void createDB() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.ariesTitle), R.drawable.aries, context.getString(R.string.ariesRange), context.getString(R.string.ariesDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.taurusTitle), R.drawable.taurus, context.getString(R.string.taurusRange), context.getString(R.string.taurusDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.geminiTitle), R.drawable.gemini, context.getString(R.string.geminiRange), context.getString(R.string.geminiDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.cancerTitle), R.drawable.cancer, context.getString(R.string.cancerRange), context.getString(R.string.cancerDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.leoTitle), R.drawable.leo, context.getString(R.string.leoRange), context.getString(R.string.leoDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.virgoTitle), R.drawable.virgo, context.getString(R.string.virgoRange), context.getString(R.string.virgoDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.libraTitle), R.drawable.libra, context.getString(R.string.libraRange), context.getString(R.string.libraDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.scorpioTitle), R.drawable.scorpio, context.getString(R.string.scorpioRange), context.getString(R.string.scorpioDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.sagittariusTitle), R.drawable.sagittarius, context.getString(R.string.sagittariusRange), context.getString(R.string.sagittariusDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.kapricornTitle), R.drawable.capricorn, context.getString(R.string.kapricornRange), context.getString(R.string.kapricornDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.aquariusTitle), R.drawable.aquarius, context.getString(R.string.aquariusRange), context.getString(R.string.aquariusDescription)));
                mRealm.copyToRealm(new Zodiac(context.getString(R.string.piscesTitle), R.drawable.pisces, context.getString(R.string.piscesRange), context.getString(R.string.piscesDescription)));
            }
        });
    }
}