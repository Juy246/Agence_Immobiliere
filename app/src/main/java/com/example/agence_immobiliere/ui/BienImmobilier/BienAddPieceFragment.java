package com.example.agence_immobiliere.ui.BienImmobilier;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agence_immobiliere.R;
import com.example.agence_immobiliere.viewmodel.BienImmobilierViewModel;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BienAddPieceFragment extends Fragment {

    private BienImmobilierViewModel viewModel;
    private String bienId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_create_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //code
        viewModel = new ViewModelProvider(this).get(BienImmobilierViewModel.class);
    }
}