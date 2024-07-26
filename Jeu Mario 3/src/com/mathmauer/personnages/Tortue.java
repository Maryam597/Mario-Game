package com.mathmauer.personnages;

import javax.swing.ImageIcon;

import com.mathmaurer.objects.Objet;

import java.awt.Image;


public class Tortue extends Personnage implements Runnable{

    private Image imgTortue;
    private ImageIcon icoTortue; 

    private final int PAUSE = 15; // tps d'attente en ms entre deux tours de boucle
    private int dxTortue; //pas de déplacement du champ
    


    // CONSTRUCTEUR

    public Tortue(int x, int y){
        super(x, y, 43, 50);
        super.setVersDroite(true);
        super.setMarche(true);
        this.dxTortue = 1;

        this.icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
        this.imgTortue = this.icoTortue.getImage();

        Thread chronoChamp = new Thread(this);
        chronoChamp.start();
    }

        //GETTERS
    
        public Image getImgChamp() {return imgTortue;}

        //METHODE 
        public void bouge() {
            if(super.isVersDroite() == true) {
                this.dxTortue = 1;
            } else {this.dxTortue = -1;}
            super.setX(super.getX() + this.dxTortue);
        }



        public void run(){
            try{
                Thread.sleep(20);} // on attend 20ms avant d'appeler bouge pour que tous les objets soient complétement créés
                catch(InterruptedException e) {}
    
             while(true){ //boucle infinie
                if(this.vivant == true) {
                this.bouge();  
                try {
                  Thread.sleep(PAUSE); 
    
                } catch (InterruptedException e) {}
         }
           }
        }


                public void contact(Objet object){
    //contact horizontal
    if(super.contactAvant(object) == true && this.isVersDroite() == true) {
        super.setVersDroite(false);
        this.dxTortue = -1;
    }
    else if (super.contactArriere(object) == true && this.isVersDroite() == false) {
    super.setVersDroite(true);
    this.dxTortue = 1; 
    }
}

public void contact(Personnage personnages){
    //contact horizontal
    if(super.contactAvant(personnages) == true && this.isVersDroite() == true) {
        super.setVersDroite(false);
        this.dxTortue = -1;
    }else if(super.contactArriere(personnages) == true && this.isVersDroite() ==false) {
       super.setVersDroite(true);
        this.dxTortue = 1;
    }
}

public Image meurt(){
    String str;
    ImageIcon ico;
    Image img;
    str = "/images/tortueFermee.png";
    ico = new ImageIcon(getClass().getResource(str));
    img = ico.getImage();
    return img;
}



}

