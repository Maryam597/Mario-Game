package com.mathmaurer.jeu;
import javax.swing.JFrame;

public class Main {
    public static Scene scene;
    public static void main(String[] args) { // prend un tableau de chaînes en paramètre

        JFrame fenetre = new JFrame("Jeu style Mario");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermeture du pgm quand on appuie sur la croix
        fenetre.setSize(700, 360);
        fenetre.setLocationRelativeTo(null);// centrer à l'écran
        fenetre.setResizable(false); // impossible de redimensionner
        fenetre.setAlwaysOnTop(true); // fenêtre toujours au-dessus des autres

        // instanciation de l'objet scene
        scene = new Scene();

        fenetre.setContentPane(scene); // on associe la scène à la fenêtre de l'application
        fenetre.setVisible(true);
    }
}
