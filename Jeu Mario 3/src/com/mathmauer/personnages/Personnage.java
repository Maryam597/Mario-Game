package com.mathmauer.personnages;

import java.awt.Image;
import javax.swing.ImageIcon;

import com.mathmaurer.objects.Objet;
import com.mathmaurer.jeu.Main;




public class Personnage {

    //variables
    private int largeur, hauteur;
    private int x, y;
    protected boolean marche;
    protected boolean versDroite;
    public int compteur; 
    protected boolean vivant; // vrai si perso vivant


    // CONSTRUCTEUR
    public Personnage (int x, int y, int largeur, int hauteur) { //constructeur d'initialisation

        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
        this.vivant = true; 
    }




    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public int getX() {return x;}

    public int getY() {return y;}

    public int getCompteur() {return compteur;}

    public boolean isMarche() {return marche;}

    public boolean isVersDroite() {return versDroite;}

    public boolean isVivant() {return vivant;}





    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setMarche(boolean marche) {this.marche = marche;}

    public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

    public void setCompteur(int compteur) {this.compteur = compteur;}

    public void setVivant(boolean vivant) {this.vivant = vivant;}




// METHODE


public Image marche(String nom, int frequence){	
    String str;
    ImageIcon ico;
    Image img;		
    if(this.marche == false){
        if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
        else{str = "/images/" + nom + "ArretGauche.png";}
    }else{
        this.compteur++;
        if(this.compteur / frequence == 0){
            if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
            else{str = "/images/" + nom + "ArretGauche.png";}
        }else{
            if(this.versDroite == true){str = "/images/" + nom + "MarcheDroite.png";}
            else{str = "/images/" + nom + "MarcheGauche.png";}
        }
        if(this.compteur == 2 * frequence){this.compteur = 0;}
    }
    //Affichage de l'image du personnage
    ico = new ImageIcon(getClass().getResource(str));
    img = ico.getImage();
    return img;
}

        public void deplacement(){		
            if(Main.scene.getxPos() >= 0){this.x = this.x - Main.scene.getDx();}
        }
    
        protected boolean contactAvant(Objet object){
            if(this.x + this.largeur < object.getX() || this.x + this.largeur > object.getX() + 5 || this.y + this.hauteur <= object.getY() || this.y >= object.getY() + object.getHauteur()){
                return false;
            } else {return true;}
            }


            protected boolean contactArriere(Objet object) {
                if(this.x > object.getX() + object.getLargeur() || this.x + this.largeur < object.getX() + object.getLargeur() -5
                || this.y + this.hauteur <= object.getY() || this.y >= object.getY() + object.getHauteur()) {
                    return false;}
                    else{return true;}
            }

            protected boolean contactDessous (Objet object) {
                if(this.x + this.largeur < object.getX() + 5 || this.x > object.getX() + object.getLargeur() -5 
                || this.y + this.hauteur < object.getY() || this.y + this.hauteur > object.getY() + 4 ) {
                    return false;
                } else {return true;}
            }

            protected boolean contactDessus(Objet object){
            if(this.x + this.largeur < object.getX() + 5 || this.x > object.getX() + object.getLargeur() -5 
                || this.y < object.getY() + object.getHauteur() || this.y > object.getY() + object.getHauteur() + 5 ) {
                    return false;
                } else {return true;}
            }

            public boolean proche (Objet object) {
                if((this.x > object.getX() -10 && this.x < object.getX() + object.getLargeur() + 10)
                || (this.x + this.largeur > object.getX() - 10 && this.x + this.largeur < object.getX() + object.getLargeur() + 10)){
                    return true;
                }
                else {return false;}
            }


            protected boolean contactAvant(Personnage personnages){
                if(this.isVersDroite() == true){
            if(this.x + this.largeur < personnages.getX() || this.x + this.largeur > personnages.getX() + 5 
            || this.y + this.hauteur <= personnages.getY() || this.y >= personnages.getY() + personnages.getHauteur()){
                return false;
            } else {return true;}
            }else {return false;}
        }

            protected boolean contactArriere(Personnage personnages) {
                if(this.x > personnages.getX() + personnages.getLargeur() || this.x + this.largeur < personnages.getX() + personnages.getLargeur() -5
                || this.y + this.hauteur <= personnages.getY() || this.y >= personnages.getY() + personnages.getHauteur()) {
                    return false;}
                    else{return true;}
            }

            protected boolean contactDessous (Personnage personnages) {
                if(this.x + this.largeur < personnages.getX() + 5 || this.x > personnages.getX() + personnages.getLargeur() -5 
                || this.y + this.hauteur < personnages.getY() || this.y + this.hauteur > personnages.getY() + 4 ) {
                    return false;
                } else {return true;}
            }

            
            public boolean proche (Personnage personnages) {
                if((this.x > personnages.getX() -10 && this.x < personnages.getX() + personnages.getLargeur() + 10)
                || (this.x + this.largeur > personnages.getX() - 10 && this.x + this.largeur < personnages.getX() + personnages.getLargeur() + 10)){
                    return true;
                }
                else {return false;}
            }
        }