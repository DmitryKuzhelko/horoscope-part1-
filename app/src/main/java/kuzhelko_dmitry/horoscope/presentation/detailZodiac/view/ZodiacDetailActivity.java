package kuzhelko_dmitry.horoscope.presentation.detailZodiac.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kuzhelko_dmitry.horoscope.R;
import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;
import kuzhelko_dmitry.horoscope.presentation.detailZodiac.presenter.ZodiacDetailPresenter;
import kuzhelko_dmitry.horoscope.utils.App;
import kuzhelko_dmitry.horoscope.utils.Constants;

public class ZodiacDetailActivity extends MvpAppCompatActivity implements IZodiacDetailView {

    private String zodiacId;

    @BindView(R.id.tvZodiacTitle)
    TextView title;

    @BindView(R.id.ivZodiacImage)
    ImageView image;

    @BindView(R.id.tvZodiacRange)
    TextView timeRange;

    @BindView(R.id.tvZodiacDescription)
    TextView description;

    @Inject
    ZodiacDetailPresenter daggerPresenter;

    @InjectPresenter
    ZodiacDetailPresenter zodiacDetailPresenter;

    @ProvidePresenter
    ZodiacDetailPresenter daggerPresenter() {
        App.getComponent().inject(this);
        return daggerPresenter;
    }

    public static Intent getZodiacIntent(Context context, Zodiac zodiac) {
        return new Intent(context, ZodiacDetailActivity.class)
                .putExtra(Constants.ID, zodiac.getId())
                .putExtra(Constants.TITLE, zodiac.getTitle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac_detail);
        setToolbar();
        ButterKnife.bind(this);

        zodiacId = getIntent().getStringExtra(Constants.ID);
        zodiacDetailPresenter.getDetailInfo(zodiacId);
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setTitle(getIntent().getStringExtra(Constants.TITLE));
        getSupportActionBar().setSubtitle(getResources().getString(R.string.description_toolbar));
    }

    @Override
    public void showDetailInfo(Zodiac zodiac) {
        title.setText(zodiac.getTitle());
        image.setImageResource(zodiac.getImageId());
        timeRange.setText(zodiac.getRange());
        description.setText(zodiac.getDescription());
    }
}