package com.example.thirdweekapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TelegramAdapter extends RecyclerView.Adapter<TelegramAdapter.AllViewHolder>{

    private final static int SECTION = 1;
    private final static int TITLE_WITH_SUBTITLE = 2;
    private final static int ICON_WITH_TEXT = 3;

    private final ArrayList<ContentItem> data = new ArrayList<>();

    public TelegramAdapter() {
        data.add(new SectionsItem("Account",0));
        data.add(new TitleWithSubtitleItem("+7(906)606-34-23","Tap to change phone number"));
        data.add(new TitleWithSubtitleItem("@ivan22","Username"));
        data.add(new TitleWithSubtitleItem("Точность - вежливость королей","Bio"));
        data.add(new SectionsItem("Settings",12));
        data.add(new IconWithTextItem("Notifications and Sounds",R.drawable.ic_notifications));
        data.add(new IconWithTextItem("Privacy and Security",R.drawable.ic_privacy));
        data.add(new IconWithTextItem("Data and Storage",R.drawable.ic_data));
        data.add(new IconWithTextItem("Chat Settings",R.drawable.ic_chat));
        data.add(new IconWithTextItem("Chat Folders",R.drawable.ic_folder));
        data.add(new IconWithTextItem("Devices",R.drawable.ic_devices));



    }

    @NonNull
    @Override
    public AllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == SECTION) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_section, parent, false);
            return new SectionsViewHolder(view);
        } else if (viewType == TITLE_WITH_SUBTITLE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_title_with_subtitle, parent, false);
            return new TitleWithSubtitleViewHolder(view);

        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_icon_with_text, parent, false);
            return new IconWithTextViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull AllViewHolder holder, int position) {
        ContentItem item = data.get(position);
        holder.bind(item);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        ContentItem contentItem = data.get(position);
        if(contentItem instanceof IconWithTextItem )
            return ICON_WITH_TEXT;
        if(contentItem instanceof TitleWithSubtitleItem )
            return TITLE_WITH_SUBTITLE;
        if(contentItem instanceof SectionsItem )
            return SECTION;
        throw new IndexOutOfBoundsException();
    }

    public abstract class AllViewHolder extends RecyclerView.ViewHolder{

        public AllViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public abstract void bind(ContentItem item);
    }

    private class IconWithTextViewHolder extends AllViewHolder {


        ImageView iconTg;
        TextView textTg;

        public IconWithTextViewHolder(@NonNull View itemView) {
            super(itemView);
            iconTg = itemView.findViewById(R.id.tg_icon);
            textTg = itemView.findViewById(R.id.tg_text);
        }

        @Override
        public void bind(ContentItem item) {
           IconWithTextItem iconWithTextItem = (IconWithTextItem)item;
           iconTg.setImageResource(iconWithTextItem.iconId);
           textTg.setText(iconWithTextItem.textName);
        }
    }


    private class SectionsViewHolder extends AllViewHolder {
        TextView sectionTg;

        public SectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            sectionTg = itemView.findViewById(R.id.tg_section);
        }

        @Override
        public void bind(ContentItem item) {
            SectionsItem sectionItem = (SectionsItem)item;
            sectionTg.setText(sectionItem.sectionName);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams)itemView.getLayoutParams();
            lp.topMargin = sectionItem.margin;
            itemView.setLayoutParams(lp);
        }

    }

    private class TitleWithSubtitleViewHolder extends AllViewHolder {
        TextView titleTg;
        TextView subTitleTg;

        public TitleWithSubtitleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTg = itemView.findViewById(R.id.tg_title);
            subTitleTg = itemView.findViewById(R.id.tg_subtitle);
        }
        @Override
        public void bind(ContentItem item) {
            TitleWithSubtitleItem titleWithSubtitleItem = (TitleWithSubtitleItem)item;
            titleTg.setText(titleWithSubtitleItem.title);
            subTitleTg.setText(titleWithSubtitleItem.subTitle);

        }
    }
    interface ContentItem{

    }
    private class IconWithTextItem implements ContentItem{
        final String textName;
        final Integer iconId;

        public IconWithTextItem(String textName, Integer iconId) {
            this.textName = textName;
            this.iconId = iconId;
        }
    }
    private class SectionsItem implements ContentItem{
        final String sectionName;
        final int margin;

        public SectionsItem(String sectionName) {
            this.sectionName = sectionName;
            this.margin = 0;
        }

        public SectionsItem(String sectionName, int margin) {
            this.sectionName = sectionName;
            this.margin = margin;
        }
    }
    private class TitleWithSubtitleItem implements ContentItem{
        final String title;
        final String subTitle;

        public TitleWithSubtitleItem(String title, String subTitle) {
            this.title = title;
            this.subTitle = subTitle;
        }
    }
}






