package model.system.nodeSyst.decorators;

import java.io.IOException;

public interface Event {
    public void display() throws IOException;
    public Event chooseNext();

}
