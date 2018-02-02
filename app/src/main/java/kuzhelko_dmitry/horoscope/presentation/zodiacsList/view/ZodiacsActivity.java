package kuzhelko_dmitry.horoscope.presentation.zodiacsList.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kuzhelko_dmitry.horoscope.R;
import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;
import kuzhelko_dmitry.horoscope.presentation.zodiacsList.presenter.ZodiacsPresenter;
import kuzhelko_dmitry.horoscope.utils.App;
import kuzhelko_dmitry.horoscope.utils.Constants;

public class ZodiacsActivity extends MvpAppCompatActivity implements IZodiacsView {

    private ZodiacsAdapter adapter;
    private Toolbar toolbar;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.link_button)
    Button link_btn;

    @Inject
    ZodiacsPresenter daggerPresenter;

    @InjectPresenter
    ZodiacsPresenter presenter;

    @ProvidePresenter
    ZodiacsPresenter daggerPresenter() {
        App.getComponent().inject(this);
        return daggerPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.setScreen();
        setToolbar();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ZodiacsAdapter();
        recyclerView.setAdapter(adapter);

        String jsonData = getIntent().getStringExtra(Constants.JSON);
        checkJson(jsonData);

        adapterClickListener();
    }

    private void adapterClickListener() {
        adapter.setClickListener(zodiac -> presenter.OnItemClick(zodiac));
    }

    @Override
    public void addDataToAdapter(List<Zodiac> zodiacs) {
        adapter.updateAdapter(zodiacs);
    }

    @Override
    public void startDetailActivity(Intent intent) {
        startActivity(intent);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        getSupportActionBar().setSubtitle(getResources().getString(R.string.all_zodiacs));
    }

    @OnClick({R.id.link_button})
    void onClick(View view) {
        presenter.onBntClick();
    }

    @Override
    public void startBrowser() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yandex.ru")));
    }

    @Override
    public void showLinkButton() {
        link_btn.setVisibility(View.VISIBLE);
    }

    private void checkJson(String jsonData) {
        if (jsonData != null && jsonData.equals("1")) {
            showLinkButton();
        }else {
            return;
        }
    }
}