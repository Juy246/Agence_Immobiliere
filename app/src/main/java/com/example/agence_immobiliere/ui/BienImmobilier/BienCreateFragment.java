package com.example.agence_immobiliere.ui.BienImmobilier;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agence_immobiliere.R;
import com.example.agence_immobiliere.viewmodel.BienImmobilierViewModel;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BienCreateFragment extends Fragment {
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
        if (getArguments() != null) {
            bienId = BienCreateFragmentArgs.fromBundle(getArguments()).getBienId();
        }

        EditText etType = view.findViewById(R.id.etType);
        EditText etRue  = view.findViewById(R.id.etRue);
        EditText etVille = view.findViewById(R.id.etVille);
        EditText etCodePostale = view.findViewById(R.id.etCodePostale);

        view.findViewById(R.id.btnCreateBien).setOnClickListener(btn -> {
            String type = etType.getText().toString().trim();
            String rue = etRue.getText().toString().trim();
            String ville = etVille.getText().toString().trim();
            String codePostale = etCodePostale.getText().toString().trim();

            if (type.isEmpty()) { etType.setError("Requis"); return; }
            if (rue.isEmpty()) { etRue.setError("Requis"); return; }
            if (ville.isEmpty()) { etVille.setError("Requis"); return; }
            if (codePostale.isEmpty()) { etCodePostale.setError("Requis"); return; }

            boolean ok = viewModel.creerBien(type,rue, ville, codePostale);
            if (ok) {
                Toast.makeText(requireContext(), "Bien ajouté", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(this).navigateUp();
            } else {
                Toast.makeText(requireContext(), "Erreur lors de l'ajout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}