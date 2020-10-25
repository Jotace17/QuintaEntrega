package com.caselles.mypuppy;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Detalle> detalles;
    Activity activity;

    public ContactoAdaptador(ArrayList<Detalle> detalles, Activity activity){
        this.detalles = detalles;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder ContactoViewHolder, int position) {
        final Detalle detalle = detalles.get(position);
        ContactoViewHolder.imgFoto.setImageResource(detalle.getFoto());
        ContactoViewHolder.tvNombreCV.setText(detalle.getNombre());
        ContactoViewHolder.tvDireccionCV.setText(detalle.getEmail());

        ContactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, detalle.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("nombre", detalle.getNombre());
                intent.putExtra("telefono", detalle.getTelefono());
                intent.putExtra("direccion", detalle.getEmail());
                activity.startActivity(intent);
            }
        });
        ContactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + detalle.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elementos de la lista
        return detalles.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvDireccionCV;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvDireccionCV = (TextView) itemView.findViewById(R.id.tvDireccionCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
