package com.example.agence_immobiliere.ui.BienImmobilier;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agence_immobiliere.R;
import com.example.agence_immobiliere.data.model.BienImmobilier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BienAdapter extends RecyclerView.Adapter<BienAdapter.VH> {
    private final List<BienImmobilier> biens = new ArrayList<>();
    private final Consumer<BienImmobilier> onClick;

    public BienAdapter(Consumer<BienImmobilier> onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bien, parent, false);
        return new VH(vItem);
    }
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(biens.get(position));
    }

    @Override
    public int getItemCount() {
        return biens.size();
    }

    public void submitList(List<BienImmobilier> newBiens) {
        biens.clear();
        biens.addAll(newBiens);
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvType;
        TextView tvRue;
        TextView tvVille;
        TextView tvCodePostal;

        VH(@NonNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tvType);
            tvRue = itemView.findViewById(R.id.tvRue);
            tvVille = itemView.findViewById(R.id.tvVille);
            tvCodePostal = itemView.findViewById(R.id.tvCodePostal);
        }

        void bind(BienImmobilier bien) {
            tvType.setText(bien.getType());
            tvRue.setText(bien.getRue());
            tvVille.setText(bien.getVille());
            tvCodePostal.setText(bien.getCodePostal());
        }
    }
}
