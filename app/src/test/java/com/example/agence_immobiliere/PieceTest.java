package com.example.agence_immobiliere;

import com.example.agence_immobiliere.data.model.PieceCirculaire;
import com.example.agence_immobiliere.data.model.PieceQuadrilatere;
import com.example.agence_immobiliere.data.model.PieceTriangulaire;
import com.example.agence_immobiliere.data.model.TypePiece;

import org.junit.Assert;
import org.junit.Test;

public class PieceTest {

    private static final double DELTA = 0.001; // Marge d'erreur pour les doubles

    @Test
    public void surface_pour_PieceQuadrilatere_estCorrecte() {
        TypePiece typeChambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        PieceQuadrilatere chambre = new PieceQuadrilatere(typeChambre, "1", 5.0, 4.0);

        double surface = chambre.surface();

        Assert.assertEquals("La surface d'un quadrilatère de 5x4 doit être 20.0", 20.0, surface, DELTA);
    }

    @Test
    public void surface_pour_PieceCirculaire_estCorrecte() {
        TypePiece typeSalon = new TypePiece(TypePiece.SALON, true, true);
        PieceCirculaire salon = new PieceCirculaire(typeSalon, "0", 3.0); // Rayon de 3m

        double surface = salon.surface();

        Assert.assertEquals("La surface d'un cercle de rayon 3 doit être PI*9", Math.PI * 9.0, surface, DELTA);
    }

    @Test
    public void surface_pour_PieceTriangulaire_estCorrecte() {
        TypePiece typeCuisine = new TypePiece(TypePiece.CUISINE, true, true);
        PieceTriangulaire cuisine = new PieceTriangulaire(typeCuisine, "0", 4.0, 3.0);

        double surface = cuisine.surface();

        Assert.assertEquals("La surface d'un triangle de base 4 et hauteur 3 doit être 6.0", 6.0, surface, DELTA);
    }
}

