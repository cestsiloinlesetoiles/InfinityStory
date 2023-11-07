package model.system.nodeSyst;

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
    @Override
    public String toString(){
        return "id = "+id+"\n"+" description =  "+ description +" ";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node n = (Node) o;
            if(this.id == n.id && description.equals(n.getDescription())){
                return  true;
            }
        }
        return  false;
    }

    public abstract Node chooseNext();


}

