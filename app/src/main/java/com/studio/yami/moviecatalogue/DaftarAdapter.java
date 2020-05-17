package com.studio.yami.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DaftarAdapter extends BaseAdapter {

    private Context context;
    private List<Film> films;

    public DaftarAdapter(Context context, List<Film> films) {
        this.context = context;
        this.films = films;
    }


    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.onBind(film);
        return view;
    }

    private class ViewHolder{

        private ImageView poster;
        private TextView title, date, score;

        public ViewHolder(View v){
            poster = v.findViewById(R.id.iv_poster_item);
            title = v.findViewById(R.id.tv_title_item);
            date = v.findViewById(R.id.tv_date_item);
            score = v.findViewById(R.id.tv_score_item);
        }

        public void onBind(Film d){
            poster.setImageResource(d.getPoster());
            title.setText(d.getTitle());
            date.setText(d.getDate());
            score.setText(String.valueOf(d.getScore())+"%");
            if(d.getScore() < 70){
                score.setTextColor(context.getResources().getColor(R.color.colorYellow));
            } else {
                score.setTextColor(context.getResources().getColor(R.color.colorGreen));
            }
        }
    }
}
