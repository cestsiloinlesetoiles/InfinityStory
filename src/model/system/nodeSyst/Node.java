package model.system.nodeSyst;

import model.system.nodeSyst.decorators.Event;

public abstract class Node implements Event {

    private String description;
    private int id;

    public Node(String d, int i) {

        this.description = d;
        this.id = i;

    }

    //getters

    public String getDescription() {
        return description;
    }



    public int getId() {
        return id;
    }

    //end getters

    public void display(){

        System.out.println(this.description);

    }

    public abstract Node chooseNext();


    public boolean equals(Node obj) {
        return obj.id == this.id;
    }
}

