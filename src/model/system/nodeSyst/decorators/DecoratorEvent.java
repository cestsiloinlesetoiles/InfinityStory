package model.system.nodeSyst.decorators;

import java.io.IOException;

public abstract class DecoratorEvent implements Event {

    private Event event;

    public DecoratorEvent(Event e) {
        event = e;
    }

    @Override
    public void display() throws IOException {
        event.display();
    }
    @Override
    public Event chooseNext(){
        return event.chooseNext();
    }
}
