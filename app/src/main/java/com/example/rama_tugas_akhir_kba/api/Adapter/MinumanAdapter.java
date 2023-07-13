package com.example.rama_tugas_akhir_kba.api.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rama_tugas_akhir_kba.api.models.DataMinuman.DataMinumanItem;
import com.example.rama_tugas_akhir_kba.databinding.ItemListMinumanBinding;

import java.util.List;

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.AdapterViewHolder> {

    List<DataMinumanItem> dataMinuman;

    public MinumanAdapter(List<DataMinumanItem> dataMinuman) {
        this.dataMinuman = dataMinuman;
    }

    @NonNull
    @Override
    public MinumanAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(ItemListMinumanBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanAdapter.AdapterViewHolder holder, int position) {
        DataMinumanItem responseDataMinuman = dataMinuman.get(position);

        String namaMinuman = responseDataMinuman.getNama();
        String ratingMinuman = responseDataMinuman.getRating();
        String hargaMinuman = responseDataMinuman.getHarga();

        holder.itemListMinumanBinding.tvNamaMinuman.setText(namaMinuman);
        holder.itemListMinumanBinding.tvRatingMinuman.setText(ratingMinuman);
        holder.itemListMinumanBinding.tvHargaMinuman.setText(hargaMinuman);

        Glide.with(holder.itemListMinumanBinding.imageView2)
                .load(responseDataMinuman.getImage())
                .into(holder.itemListMinumanBinding.imageView2);
    }

    @Override
    public int getItemCount() {
        return dataMinuman.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

     ItemListMinumanBinding itemListMinumanBinding;
        public AdapterViewHolder(ItemListMinumanBinding itemListMinumanBinding) {
            super(itemListMinumanBinding.getRoot());
            this.itemListMinumanBinding = itemListMinumanBinding;
        }
    }
}
