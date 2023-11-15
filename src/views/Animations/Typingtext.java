package views.Animations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Typingtext extends Label {
    
    private Timeline animation;
    
    public Typingtext() {
        super("");
    }
    // crée une animation pour typing text
    public void typeText(String text, int delay) {
        // Permet de crée une chaine de caractére modifiable => String immuable 
        StringBuilder currentText = new StringBuilder();

        animation = new Timeline();
        
        
        Duration duration = Duration.millis(delay);
        
        // for each sur l'input
        for (char t : text.toCharArray()) {
            // Chaque clé correspond à l'ajout d'un appel currentText.append(t) et on actualise la vu
            KeyFrame keyFrame = new KeyFrame(duration, e -> { currentText.append(t); setText(currentText.toString()); });
            
            animation.getKeyFrames().add(keyFrame);
            // Rajout pour chaque ajout  au total time
            duration = duration.add(Duration.millis(delay));
        }

        // r
        animation.play();
    }
    


}
