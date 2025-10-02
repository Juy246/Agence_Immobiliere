package com.example.agence_immobiliere.data.model;

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
        return "- " + typePiece.getNom() + " surface : " + String.format("%.2f", surface()) + " m2";
    }

    public boolean isSurfaceHabitable() {
        return typePiece.isSurfaceHabitable();
    }
}
