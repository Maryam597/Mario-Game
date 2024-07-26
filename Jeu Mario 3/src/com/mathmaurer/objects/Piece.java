package com.mathmaurer.objects;

import javax.swing.ImageIcon;

// import com.mathmaurer.jeu.Main;

import java.awt.Image;


public class Piece extends Objet implements Runnable {
    
    
    // Variables
    private int compteur; 
    private final int PAUSE = 15; // temps d'attente entre 2 tours 




    //Constructeur
    public Piece(int x, int y) {
        super(x, y, 30, 30);

        System.out.println("Loading image for Piece...");

        super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
        super.imgObjet = super.icoObjet.getImage();
    }

    //METHODES

    public Image bouge(){
        String str; 
        ImageIcon ico;
        Image img;

        this.compteur++;
        if(this.compteur /100 == 0){ // fréquence de changement d'image de piece1 à piece2 pour une impressiond e clignotement
            str = "/images/piece1.png"; 
        } else {str = "/images/piece2.png";}
        if(this.compteur == 200) {this.compteur = 0;}

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void run(){
        try{
            Thread.sleep(20);} // on attend 20ms avant d'appeler bouge pour que tous les objets soient complétement créés
            catch(InterruptedException e) {}

         while(true){ //boucle infinie
            this.bouge();  
            try {
              Thread.sleep(PAUSE); 

            } catch (InterruptedException e) {}
        }

    }


}
