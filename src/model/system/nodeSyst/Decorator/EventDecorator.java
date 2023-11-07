package model.system.nodeSyst.Decorator;

public abstract class EventDecorator  implements Event{
    protected Event decoEvent;

    public EventDecorator(Event e){
        this.decoEvent = e;
    }

    @Override
    public void display() {
        decoEvent.display();
    }

    @Override
    public Event chooseNext() {
        return decoEvent.chooseNext();
    }
}
