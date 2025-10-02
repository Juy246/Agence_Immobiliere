package com.example.agence_immobiliere.data.repository;

import com.example.agence_immobiliere.data.model.BienImmobilier;
import com.example.agence_immobiliere.data.model.PieceQuadrilatere;
import com.example.agence_immobiliere.data.model.TypePiece;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class BienImmobilierRepository {
    private final List<BienImmobilier> biens = new ArrayList<>();

    @Inject
    public BienImmobilierRepository() { }

    public List<BienImmobilier> getBiens() {
        return new ArrayList<>(biens);
    }

    public void ajouterBien(BienImmobilier bien) {
        biens.add(0, bien);
    }

    public BienImmobilier getBien(String id) {
        for (BienImmobilier b : biens) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    public boolean ajouterPieceQuadrilatere(String bienId, TypePiece typePiece, String niveau, double longueur, double largeur) {
        if (typePiece == null || longueur <= 0 || largeur <= 0) {
            return false;
        }
        BienImmobilier bien = getBien(bienId);
        if (bien != null) {
            PieceQuadrilatere piece = new PieceQuadrilatere(typePiece, niveau, longueur, largeur);
            bien.ajouterPiece(piece);
            return true;
        }
        return false;
    }

    public boolean creerBien(String type, String rue, String ville, String codePostal) {
        if (
                type == null || type.isEmpty() ||
                rue == null || rue.isEmpty() ||
                ville == null || ville.isEmpty() ||
                codePostal == null || codePostal.isEmpty()) {
            return false;
        }

        BienImmobilier bien = new BienImmobilier(type, rue, ville, codePostal);
        ajouterBien(bien); // méthode du repository
        return true;
    }


}
