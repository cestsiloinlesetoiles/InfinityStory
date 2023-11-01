package model.nodeSyst;

public abstract class Node {

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


}

