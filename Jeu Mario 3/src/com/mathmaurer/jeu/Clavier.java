package com.mathmaurer.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mathmaurer.audio.Audio;


public class Clavier implements KeyListener {

    public void keyPressed(KeyEvent e){
        if(Main.scene.mario.isVivant() ==true){

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            if(Main.scene.getxPos() == -1) { // Si on est complétement à gauche
                Main.scene.setxPos(0); // alors on remet xpos à 0 
                Main.scene.setxFond1(-50); //idem pr xFond1 et 2
                Main.scene.setxFond2(750);
            }

            Main.scene.mario.setMarche(true);
            Main.scene.mario.setVersDroite(true);
            Main.scene.setDx(1);



 
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {

            if(Main.scene.getxPos() == 4431) {
                Main.scene.setxPos(4430);
                Main.scene.setxFond1(-50);
                Main.scene.setxFond2(750);
            }

            Main.scene.mario.setMarche(true);
            Main.scene.mario.setVersDroite(false);
              Main.scene.setDx(-1);

        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            Main.scene.mario.setSaut(true);
            Audio.playSound("/audio/saut.wav");
        }
}
    }
    
        public void keyReleased(KeyEvent e){

        Main.scene.mario.setMarche(false);
        Main.scene.setDx(0);
    }




        public void keyTyped(KeyEvent e){}
}
