package model.system.nodeSyst;

import model.system.nodeSyst.decorators.Event;
import model.universe.Living.CompanionTrainer;
import model.universe.Living.Items.Companions.Elekchu;
import model.universe.Living.Items.Companions.FireCat;
import model.universe.Living.Items.Companions.IcyWolf;

import java.util.Scanner;

public class StartNode extends InnerNode{

    CompanionTrainer companionTrainer;

    public StartNode(String desc, int i, CompanionTrainer c) {
        super(desc, i);
        this.companionTrainer = c;
    }

    @Override
    public void display() {
        System.out.println("Choisissez votre companion");
        System.out.print("1. Elekchu \n 2. FireCat \n 3. IcyWolf \n Votre choix :");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        if(choix == 1){
            Elekchu e = new Elekchu();
            companionTrainer.addCompanionDex(e);
        }else if(choix == 2){
            FireCat f = new FireCat();
            companionTrainer.addCompanionDex(f);
        }else{
            IcyWolf i = new IcyWolf();
            companionTrainer.addCompanionDex(i);
        }

        System.out.println("Félicitations ! vous avez choisi "+companionTrainer.getCompanionDex().get(0));

    }

    @Override
    public Node chooseNext() {
        return this.getNextNodes().get(0);
    }
}
