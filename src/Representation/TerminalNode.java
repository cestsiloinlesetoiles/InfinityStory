package Representation;

public class TerminalNode extends Node{

    public TerminalNode(String d,int i){

        super(d,i);

    }

    public Node chooseNext() {

        return this;

    }

}
