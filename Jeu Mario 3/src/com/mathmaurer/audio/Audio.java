package com.mathmaurer.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
    
    private Clip clip;

    public Audio(String son) { // contructeur qui prend comme chaîne de caractère le chemain du fichier


        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
            clip = AudioSystem.getClip();
            clip.open(audio);
        }
        catch(Exception e) {}

    }

    public Clip geClip() {return clip;}

    

    public void play() {clip.start();}

    public void stop() {clip.stop();}

    public static void playSound(String son) {
        Audio s = new Audio(son);
        s.play();
    }


}
