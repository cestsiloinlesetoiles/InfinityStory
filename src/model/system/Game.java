package model.system;

import model.system.nodeSyst.*;
import model.universe.Living.CompanionTrainer;
import model.universe.Living.Items.Companions.Elekchu;

public class Game {

    CompanionTrainer companionTrainer;

    public Game(String playerName){

        CompanionTrainer companionTrainer = new CompanionTrainer(playerName);
        this.companionTrainer = companionTrainer;

        StartNode s = new StartNode("choix companion",1, this.companionTrainer);
        CombatNode c = new CombatNode("combat",2,this.companionTrainer,new CompanionTrainer("The punisher",new Elekchu()));
        TerminalNode fin = new TerminalNode("Partie Terminé",3);

        s.fillNextNode(c);c.fillNextNode(fin);

        Node n = s;
        n.display();
        while(!n.equals(fin)){
            n = n.chooseNext();
            n.display();
        }

    }



}
