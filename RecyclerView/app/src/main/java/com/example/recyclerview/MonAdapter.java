package com.example.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonAdapter extends RecyclerView.Adapter<MonAdapter.MonViewHolder> {
    List<Items> mesItems;
private Context context;
    public MonAdapter(List<Items> mesItems, Context context) {
        this.mesItems = mesItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.affichage_items, parent, false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {

        holder.imageImV.setImageResource(mesItems.get(position).getImage());
        holder.titreTxtV.setText(mesItems.get(position).getTitre());
        holder.descriptionTxtV.setText(mesItems.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mesItems.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titreTxtV, descriptionTxtV;
        private ImageView imageImV;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            titreTxtV = itemView.findViewById(R.id.titre);
            descriptionTxtV = itemView.findViewById(R.id.description);
            imageImV = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int posi = getLayoutPosition();

            String titreClick = mesItems.get(posi).getTitre();
            String descriptionClick = mesItems.get(posi).getDescription();
            int imgClick = mesItems.get(posi).getImage();

            Log.d("CLICK", "Titre : " + titreClick);
            Log.d("CLICK", "Description : " + descriptionClick);
            Log.d("CLICK", "Image ID : " + imgClick);

            Toast.makeText(context, "Titre : " + titreClick + ", " +
                    "Description : " + descriptionClick +"\n" +
                    "Img : " + imgClick, Toast.LENGTH_SHORT).show();

        }
    }
}


