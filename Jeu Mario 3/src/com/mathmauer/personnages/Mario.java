package com.mathmauer.personnages;

import java.awt.Image;
import javax.swing.ImageIcon;

import com.mathmaurer.audio.Audio;
import com.mathmaurer.jeu.Main;
import com.mathmaurer.objects.Objet;
import com.mathmaurer.objects.Piece;



public class Mario extends Personnage {

    // VARIABLES
    private Image imgMario;
    private boolean saut; //vrai si Mario saute
    // private ImageIcon icoMario;
    private int compteurSaut; //durée et hauteur du saut
    private int compteurMort;

    // CONSTRUCTOR
    public Mario(int x, int y) {
        super(x, y, 28, 50);
        ImageIcon icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        if (icoMario.getImage() != null) {
            this.imgMario = icoMario.getImage();
            this.saut = false;
            this.compteurSaut = 0; 
            this.compteurMort = 0;
            System.out.println("Mario image loaded successfully");
        } else {
            System.out.println("Error loading Mario image");
        }
    }

    // GETTER
    public Image getImgMario() {return imgMario;}

    public boolean isSaut() {return saut;}


    //SETTER
    public void setSaut(boolean saut) {this.saut = saut;}


    //METHODE 

    @Override
    public Image marche(String nom, int frequence) {
        
        String str; 
        ImageIcon ico; 
        Image img;

        if(this.marche == false || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430){ // Mario s'arrête dès qu'il arrive à la fin à 4430
            if(this.versDroite == true) {
                str = "/images/" + nom + "ArretDroite.png";
            }else {str = "/images/" + nom + "ArretGauche.png";}
        }else {
            this.compteur++;
            if(this.compteur / frequence == 0 ) {
                if (this.versDroite == true){
                    str = "/images/" + nom + "ArretDroite.png";
                }else {str = "/images/" + nom + "ArretGauche.png";}}
            else {
                if(this.versDroite == true) {
                str = "/images/" + nom + "MarcheDroite.png";
            }else {str = "/images/" + nom + "MarcheGauche.png";}
            }
            if(this.compteur == 2 * frequence){
                this.compteur = 0;}
            }
            ico = new ImageIcon(getClass().getResource(str));
            img = ico.getImage();
            return img; 
        }

    public Image saute(){

        //3 variables 
        ImageIcon ico;
        Image img;
        String str; 

        this.compteurSaut++; // incrémentation du compteurSaut

        //Montée du saut
        if(this.compteurSaut <= 40) { //une fois arrivé à 35, le personnage commence sa descente  
            if(this.getY() > Main.scene.getHauteurPlafond()) { //tant que getY est plus grand que la hauteur du plafond/ donc que MArio ne touche pas le plafond
                this.setY(this.getY() - 4); // -4 donc Mario va monter à l'écran 
            } else {this.compteurSaut = 41; }// Sinon on est arrivé à 35 donc on bloque le compteur à 36
            if(this.isVersDroite() == true) { 
                str = "/images/marioSautDroite.png";
            }else {str = "/images/marioSautGauche.png";}

            //Retombée du saut 
            }else if (this.getY() + this.getHauteur() < Main.scene.getySol()) { //getY 
                this.setY(this.getY() + 1);
                if(this.isVersDroite() == true)                  
                {str = "/images/marioSautDroite.png";}
                else{str = "/images/marioSautGauche.png";}
            

            //Saut terminé 

        }else {
            if(this.isVersDroite() == true) {str = "src/images/marioArretDroite.png";}
            else {str = "src/images/marioArretGauche.png";}
            this.saut = false;
            this.compteurSaut = 0; 
        }

        //Affichage de l'image de AMrio
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

public void contact(Objet object){
    //contact horizontal
    if((super.contactAvant(object) == true && this.isVersDroite() == true) || (super.contactArriere(object) == true && this.isVersDroite() ==false)) {
        Main.scene.setDx(0);
        this.setMarche(false);
    }
    //contact avec un objet en dessous
    if(super.contactDessous(object) == true && this.saut == true){ //Mario saute sur un objet
        Main.scene.setySol(object.getY());  
    }else if (super.contactDessous(object) == false) {  // Mario tombe sur le sol initial
        Main.scene.setySol(293);        //altitude du sol
        if(this.saut == false) { 
            this.setY(243);// 
        }
    }

    //contact avec un objet au-dessus
    if(super.contactDessus(object) == true){
        Main.scene.setHauteurPlafond(object.getY() + object.getHauteur()); // le plafond devient le dessous de l'object
    } else if (super.contactDessus(object) == false && this.saut == false) {
        Main.scene.setHauteurPlafond(0); // altitude du plafond inital (ciel)
    }

}

    public boolean contactPiece(Piece piece){
        if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || this.contactDessus(piece) == true) {
            return true;
        } else {return false;}
    }

    public void contact(Personnage personnages) {
        if((super.contactAvant(personnages) == true) || (super.contactArriere(personnages) == true)){
            this.setMarche(false);
            this.setVivant(false);
        }else if(super.contactDessous(personnages) == true) {
            personnages.setMarche(false);
            personnages.setVivant(false);
        }
    }

    public Image meurt(){
        String str;
        ImageIcon ico;
        Image img;

        str = "/images/boom.png";  // D'abord l'image boom

        
        if(this.compteurMort == 0) {Audio.playSound("/audio/boum.wav");}

        if(this.compteurMort == 100) {Audio.playSound("/audio/partiePerdue.wav");}




        this.compteurMort++;
 
        if(this.compteurMort > 100) { // puis quand le compteur image va arriver à 100
        str = "/images/marioMeurt.png"; // image Mario meurt 
        this.setY(this.getY() -1); //mario monte vers le ciel

        }

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

}


