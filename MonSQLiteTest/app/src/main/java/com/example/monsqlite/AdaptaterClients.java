package com.example.monsqlite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptaterClients extends RecyclerView.Adapter<AdaptaterClients.ClientViewHolder> {
    private List<Clients> mesClients;
    private Context context;

    public AdaptaterClients(List<Clients> mesClients, Context context) {
        this.mesClients = mesClients;
        this.context = context;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.affichage_items, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {

        holder.nomTextView.setText(mesClients.get(position).getNom());
        holder.prenomTextView.setText(mesClients.get(position).getPrenom());
        holder.ageTextView.setText (mesClients.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return mesClients.size();
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nomTextView, prenomTextView, ageTextView;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);


            nomTextView = itemView.findViewById(R.id.titre);
            prenomTextView = itemView.findViewById(R.id.description);
            ageTextView = itemView.findViewById(R.id.img);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            String nomClick = mesClients.get(position).getNom();
            String prenomClick = mesClients.get(position).getPrenom();
            int ageClick = mesClients.get(position).getAge();

                Log.d("CLICK", "Nom : " + nomClick);
                Log.d("CLICK", "Prénom : " + prenomClick);
                Log.d("CLICK", "Âge : " + ageClick);

                Toast.makeText(context,
                        "Nom : " + nomClick + ", " +
                                "Prénom : " + prenomClick + "\n" +
                                "Âge : " + ageClick,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
