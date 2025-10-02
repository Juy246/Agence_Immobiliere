package com.example.agence_immobiliere.data.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class Piece {
    private TypePiece typePiece;
    private String niveau;

    public Piece(TypePiece typePiece, String niveau) {
        this.typePiece = typePiece;
        this.niveau = niveau;
    }

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setTypePiece(TypePiece typePiece) {
        this.typePiece = typePiece;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public abstract double surface();

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "- " + typePiece.getNom() + " surface : " + numberFormat.format(surface()) + " m2\n";
    }

    public boolean isSurfaceHabitable() {
        return typePiece.isSurfaceHabitable();
    }
}
