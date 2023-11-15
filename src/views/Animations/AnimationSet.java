package views.Animations;

import java.util.Map;

public class AnimationSet {
    private Map<String, ImageAnimated> animations;

    public void addAnimation(String name, ImageAnimated animation) {
        animations.put(name, animation);
    }

    public ImageAnimated getAnimation(String name) {
        return animations.get(name);
    }


}
