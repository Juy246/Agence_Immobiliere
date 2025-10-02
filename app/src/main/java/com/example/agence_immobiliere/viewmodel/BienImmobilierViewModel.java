package com.example.agence_immobiliere.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.agence_immobiliere.data.model.BienImmobilier;
import com.example.agence_immobiliere.data.repository.BienImmobilierRepository;

import java.util.List;

import dagger.hilt.android.lifecycle.HiltViewModel;
import jakarta.inject.Inject;

@HiltViewModel
public class BienImmobilierViewModel extends ViewModel {
    private final BienImmobilierRepository repo;
    private final MutableLiveData<List<BienImmobilier>> biens = new MutableLiveData<>();
    private final MutableLiveData<BienImmobilier> bienImmobilierDetail = new MutableLiveData<>();

    @Inject
    public BienImmobilierViewModel(BienImmobilierRepository repo) {
        this.repo = repo;
        // Chargement initial
        biens.setValue(repo.getBiens());
    }

    public LiveData<List<BienImmobilier>> getBiens() {
        return biens;
    }

    public LiveData<BienImmobilier> getBienById(String id) {
        return Transformations.map(biens, list -> {
            if (biens == null || id == null) return null; {
                for (BienImmobilier b : list) {
                    if (id.equals(b.getId())) return b;
                }
            }
            return null;
        });
    }

    public LiveData<BienImmobilier> getBienImmobilierDetail() {
        return bienImmobilierDetail;
    }



    public boolean creerBien(String type, String rue, String ville, String codePostal) {
        boolean ok = repo.creerBien(type, rue, ville, codePostal);
        if (ok) {
            biens.setValue(repo.getBiens());
        }
        return ok;
    }
}
