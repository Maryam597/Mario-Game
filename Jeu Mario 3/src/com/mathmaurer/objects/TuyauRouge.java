package com.mathmaurer.objects;

import javax.swing.ImageIcon;

public class TuyauRouge extends Objet {




    //Constructeur

    public TuyauRouge(int x, int y) {

        super(x, y, 43, 65);
        super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        super.imgObjet = super.icoObjet.getImage();
    }    
    
}
