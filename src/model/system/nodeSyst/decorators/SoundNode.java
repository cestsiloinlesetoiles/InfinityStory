package model.system.nodeSyst.decorators;

import model.system.nodeSyst.decorators.DecoratorEvent;
import model.system.nodeSyst.decorators.Event;

public class SoundNode extends DecoratorEvent {

    Object sound;
    public SoundNode(Event e) {
        super(e);
    }

    @Override
    public void display() {
        //active(sound);
       // super.display();
    }

    @Override
    public Event chooseNext() {
        return super.chooseNext();
    }


}
