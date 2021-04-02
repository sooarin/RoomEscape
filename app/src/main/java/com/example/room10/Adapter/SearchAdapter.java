package com.example.room10.Adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.room10.Model.Escape;
import com.example.room10.R;

import java.util.List;


class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView region, theme, cafe, room, link;
    public View mView;
    public SearchViewHolder(View itemView) {
        super(itemView);
        region = (TextView)itemView.findViewById(R.id.region);
        theme = (TextView)itemView.findViewById(R.id.theme);
        cafe = (TextView)itemView.findViewById(R.id.cafe);
        room = (TextView)itemView.findViewById(R.id.room);
        link = (TextView)itemView.findViewById(R.id.link);
        mView = itemView;

    }

}
public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private Context context;
    private List<Escape> Escapes;


    public SearchAdapter(Context context, List<Escape> Escapes){
        this.context = context;
        this.Escapes = Escapes;
    }
    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        final int intentPosition = position;
        holder.region.setText(Escapes.get(position).getRegion());
        holder.theme.setText(Escapes.get(position).getTheme());
        holder.cafe.setText(Escapes.get(position).getCafe());
        holder.room.setText(Escapes.get(position).getRoom());
        holder.link.setText(Escapes.get(position).getLink());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(Escapes.get(intentPosition).getLink());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Escapes.size();
    }



}
