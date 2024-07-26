package com.mathmaurer.jeu;

public class Chrono implements Runnable {


    private final int PAUSE = 3; // temps de pause entre deux tours de boucle  

    public void run(){

        while(true){
            Main.scene.repaint();  //reprise du fond d'écran et d'image mario dans la classe Main
            try {
              Thread.sleep(PAUSE); 

            } catch (InterruptedException e) {}
        }

    }
    
}
