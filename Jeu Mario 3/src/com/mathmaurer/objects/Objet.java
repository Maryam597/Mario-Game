package com.mathmaurer.objects;

import javax.swing.ImageIcon;
import java.awt.Image;


import com.mathmaurer.jeu.Main;


public class Objet {
    //Var
    private int largeur, hauteur;
    private int x, y;

    protected Image imgObjet;
    protected ImageIcon icoObjet;
    // private Image imgTuyauRouge;
    // private ImageIcon icoTuyauRouge;

    

    
//Constr
    public Objet(int x, int y, int largeur, int hauteur){
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }




    public int getX() {return x;}

    public int getY() {return y;}

    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public Image getImgObjet() { return imgObjet;}




    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setLargeur(int largeur) {this.largeur = largeur;}

    public void setHauteur(int hauteur) {this.hauteur = hauteur;}

//METHODES

    public void deplacement(){// met à jour la position x de l'objet en enlevant le déplacement dx (déplacement de l'écran)
        
        if(Main.scene.getxPos() >=0){
            this.x = this.x - Main.scene.getDx(); 
        }
    }
  

    
}
