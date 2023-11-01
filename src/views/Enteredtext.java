package views;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Enteredtext extends Label {
    
    private Timeline timeline;
    
    public Enteredtext() {
        super("");
    }

    public void typeText(String text, int delay) {
        StringBuilder currentText = new StringBuilder();
        
        timeline = new Timeline();
        Duration duration = Duration.millis(delay);
        for (char c : text.toCharArray()) {
            KeyFrame keyFrame = new KeyFrame(duration, e -> {
                currentText.append(c);
                setText(currentText.toString());
            });
            
            timeline.getKeyFrames().add(keyFrame);
            duration = duration.add(Duration.millis(delay));
        }

        timeline.play();
    }
    


}
