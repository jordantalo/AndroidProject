package com.example.jordan.projectapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DestinationAdapter extends BaseAdapter {

    List<Destination> biblio;
    // LayoutInflater aura pour mission de charger notre fichier XML
    LayoutInflater inflater;
    /**
     * Elle nous servira à mémoriser les éléments de la liste en mémoire pour
     * qu’à chaque rafraichissement l’écran ne scintille pas
     *
     * @author patrice
     */
    private class ViewHolder {
        TextView tvTitre;
        TextView tvAuteur;
    }
    public DestinationAdapter(Context context, List<Destination> objects) {
        inflater = LayoutInflater.from(context);
        this.biblio = objects;
    }
    /**
     * Génère la vue pour un objet
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {Log.v("test", "convertView is null");
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.livre_item, null);
            holder.tvTitre = (TextView) convertView.findViewById(R.id.txtTitre);
            holder.tvAuteur = (TextView) convertView
                    .findViewById(R.id.txtAuteur);
            convertView.setTag(holder);
        } else {
            Log.v("test", "convertView is not null");
            holder = (ViewHolder) convertView.getTag();
        }
        Livre livre = biblio.get(position);
        holder.tvTitre.setText(livre.getTitre());
        holder.tvAuteur.setText(livre.getAuteur());
        return convertView;
    }
    /**
     * Retourne le nombre d'éléments
     */
    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return biblio.size();
    }
/**
 * Retourne l'item à la position
 */
    @Override
    public Livre getItem(int position) {
// TODO Auto-generated method stub
        return biblio.get(position);
    }
    /**
     * Retourne la position de l'item
     */
    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }
}



