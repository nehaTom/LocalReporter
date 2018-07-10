package com.example.admin.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;

public class VideoCardAdapter extends RecyclerView.Adapter<VideoCardAdapter.MyViewHolder>
{
    private Context context;
    private  String fromWhere;

    int[] news_images={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.news_video};
    String[] news_title={"HD Kumaraswamy sworn in as Karnataka chief minister, and nine other top stories","Karnataka assembly elections: Voters to decide between Congress, BJP, JD(S) today",
            "Dhoni still best in the world, India selector claims","Nirav Modi’s ‘letter’ to PNB: You closed all my options by going public, liability much less than Rs 11,000 crore",
            "Union Ministers list 4 years achievements of Modi Govt","ICICI Bank shares tumble, RBI slaps penalty"};


    public  VideoCardAdapter(Context context,String fromWhere) {
        this.context = context;
        this.fromWhere = fromWhere;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView news_headline, news_source, news_time;
        ImageView play_button, comment, share;
        RelativeLayout news_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            news_headline = itemView.findViewById(R.id.news_headline);
            news_source = itemView.findViewById(R.id.news_source);
            news_time = itemView.findViewById(R.id.news_time);
            share = itemView.findViewById(R.id.share);
            news_img = itemView.findViewById(R.id.news_img);
            play_button = itemView.findViewById(R.id.play_button);

            if (fromWhere.equals("Video_List")) {
                play_button.setImageDrawable(context.getResources().getDrawable(R.drawable.video_icon));
                play_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Video.class);
                        context.startActivity(intent);
                    }
                });

            } else if (fromWhere.equals("Image_List")) {
                play_button.setImageDrawable(context.getResources().getDrawable(R.drawable.photo_icon));
                play_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Image_Food.class);
                        context.startActivity(intent);
                    }
                });
            }


        }
    }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.videos_card_layout, null);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int i) {
            holder.news_headline.setText(news_title[i]);
            holder.news_img.setBackgroundResource(news_images[i]);

        }

        @Override
        public int getItemCount() {

            return news_images.length;
        }

    }

