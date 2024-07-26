package com.mathmaurer.affichage;

public class CompteARebours implements Runnable {

    private final int PAUSE = 1000; //tps de pause entre deux affichages
    private int compteurTemps; // décrémenter le temps affiché grâce à str
    private String str;


    // Constructeur
    public CompteARebours() {
        this.compteurTemps = 100; // initialise le compteur à 100
        this.str = "Temps restant : 100";

        Thread compteARebours = new Thread(this); 
        compteARebours.start();
    }


    
    // GETTERS 
    
    public int getCompteurTemps() {return compteurTemps;}


    public String getStr() {return str;}
 
    
    //METHODE

    public void run() { // va gérer la décrémentation du compteur temps 

        while(true){
            try{Thread.sleep(PAUSE);
        }
        catch (InterruptedException e) {}
        this.compteurTemps--;
        this.str = "Temps restant : " + this.compteurTemps;
}

}
}
