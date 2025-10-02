package com.example.agence_immobiliere.data.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BienImmobilier {
    public static final String TYPE_APPARTEMENT = "Appartement";
    public static final String TYPE_MAISON = "Maison";
    private String id;
    private String type;
    private String rue;
    private String ville;
    private String codePostal;
    private List<Piece> pieces = new ArrayList<>();

    public BienImmobilier(String type, String rue, String ville, String codePostal) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getRue() {
        return rue;
    }
    public String getVille() {
        return ville;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public List<Piece> getPieces() {
        return pieces;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public double surfaceHabitable() {
        double total = 0;
        for (Piece p : pieces) {
            total += p.surface();
        }
        return total;
    }

    public double surfaceNonHabitable() {
        double total = 0;
        for (Piece p : pieces) {
            if (!p.isSurfaceHabitable()) {
                total += p.surface();
            }
        }
        return total;
    }

    public void ajouterPiece(Piece piece) {
        pieces.add(piece);
    }

    public String toStringPieces() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : pieces) {
            sb.append(p.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return type + " " + id +
                "\nLocalisation : " + rue + " " + codePostal + " " + ville +
                "\n \n Description du bien : \n" +
                toStringPieces() +
                "\nPour une surface habitable de : " + numberFormat.format(surfaceHabitable())
                + " m2 et une surface non habitable de : " + numberFormat.format(surfaceNonHabitable()) + " m2.";
    }
}