package com.mathmaurer.affichage;

public class Score {

    // Variables
        private final int NBRE_TOTAL_PIECES = 10; // nb total de pièce qui est 10
        private int nbrePieces; //nb de pièces collectées

    //Constructeur

    public Score(){
        this.nbrePieces = 0; // initialisation début de jeu
    }


        // GETTERS

    public int getNBRE_TOTAL_PIECES() {return NBRE_TOTAL_PIECES;}

    public int getNbrePieces() {return nbrePieces;}

    //SETTERS 

    public void setNbrePieces(int nbrePieces) {this.nbrePieces = nbrePieces;}

}
