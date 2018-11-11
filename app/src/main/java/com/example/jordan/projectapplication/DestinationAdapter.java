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

    List<ClassDestination> listdest;
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
        TextView tvLieu;
        TextView tvDistance;
    }
    public DestinationAdapter(Context context, List<ClassDestination> objects) {
        inflater = LayoutInflater.from(context);
        this.listdest = objects;
    }
    /**
     * Génère la vue pour un objet
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {Log.v("test", "convertView is null");
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.template_destination, null);
            holder.tvTitre = (TextView) convertView.findViewById(R.id.titreid);
            holder.tvLieu = (TextView) convertView.findViewById(R.id.Lieuid);
            holder.tvDistance = (TextView) convertView.findViewById(R.id.distanceid);
            convertView.setTag(holder);
        } else {
            Log.v("test", "convertView is not null");
            holder = (ViewHolder) convertView.getTag();
        }

        ClassDestination dest = listdest.get(position);
        holder.tvTitre.setText(dest.getType());
        holder.tvLieu.setText(dest.getDisplay());
        holder.tvDistance.setText(Double.toString(dest.getDistance()));
        return convertView;
    }
    /**
     * Retourne le nombre d'éléments
     */
    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return listdest.size();
    }
/**
 * Retourne l'item à la position
 */
    @Override
    public ClassDestination getItem(int position) {
// TODO Auto-generated method stub
        return listdest.get(position);
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



