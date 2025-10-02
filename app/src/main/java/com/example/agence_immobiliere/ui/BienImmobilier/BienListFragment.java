package com.example.agence_immobiliere.ui.BienImmobilier;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agence_immobiliere.R;
import com.example.agence_immobiliere.data.model.BienImmobilier;
import com.example.agence_immobiliere.viewmodel.BienImmobilierViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BienListFragment extends Fragment {
    private BienImmobilierViewModel viewModel;
    private BienAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(BienImmobilierViewModel.class);
        //code
        RecyclerView rv = view.findViewById(R.id.recyclerBiens);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new BienAdapter(bien -> {
            BienListFragmentDirections.ActionBienListFragmentToBienDetailFragment action =
                    BienListFragmentDirections.actionBienListFragmentToBienDetailFragment(bien.getId());

            NavHostFragment.findNavController(BienListFragment.this).navigate(action);

        });
        rv.setAdapter(adapter);

        viewModel.getBiens().observe(getViewLifecycleOwner(),list ->
            adapter.submitList(new ArrayList<>(list))
        );

        view.findViewById(R.id.btnAddBiens).setOnClickListener(btn -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_bienListFragment_to_bienCreateFragment);
        });

    }
}