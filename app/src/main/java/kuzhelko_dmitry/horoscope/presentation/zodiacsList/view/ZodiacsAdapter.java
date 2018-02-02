package kuzhelko_dmitry.horoscope.presentation.zodiacsList.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kuzhelko_dmitry.horoscope.R;
import kuzhelko_dmitry.horoscope.domain.entities.Zodiac;
import kuzhelko_dmitry.horoscope.utils.Constants;

public class ZodiacsAdapter extends RecyclerView.Adapter<ZodiacsAdapter.ViewHolder> {

    private List<Zodiac> zodiacs;
    private static ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(Zodiac zodiac);
    }

    public void updateAdapter(List<Zodiac> zodiacs) {
            this.zodiacs = zodiacs;
    }



    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_zodiacs_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindZodiac(zodiacs.get(position));
    }

    @Override
    public int getItemCount() {
        if (zodiacs != null) {
            return zodiacs.size();
        } else {
            return Constants.ZERO_ITEM_COUNT;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public void bindZodiac(Zodiac zodiac) {
            title.setText(zodiac.getTitle());
        }

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.zodiacTitle);

            itemView.setOnClickListener(v -> {
                if (ZodiacsAdapter.clickListener != null) {
                    ZodiacsAdapter.clickListener.onItemClick(zodiacs.get(getAdapterPosition()));
                }
            });
        }
    }
}