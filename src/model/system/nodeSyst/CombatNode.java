package model.system.nodeSyst;

import model.system.nodeSyst.decorators.DecoratorEvent;
import model.system.nodeSyst.decorators.Event;
import model.universe.Living.CompanionTrainer;
import model.universe.Living.Enum.DamageType;
import model.universe.Living.Items.Companions.Companion;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CombatNode extends InnerNode {
    private CompanionTrainer companionTrainer;
    private CompanionTrainer opponent;

    private boolean won;
    public CombatNode( String d, int id, CompanionTrainer c, CompanionTrainer opp) {
        super(d,id);

        companionTrainer = c;
        opponent = opp;
    }

    public void opponentAttacks(Companion companion, Companion companionOpp){
        DamageType type = companionOpp.getSpecialty();
        double d = Math.random();
        if(d <= 0.4){
            companionOpp.attack(companion, type);
            System.out.println("Attaque de type "+type+" par l'opposant !!!");
        }else{
            companionOpp.attack(companion, DamageType.NORMAL);
            System.out.println("Attaque de type Normal par l'opposant !!!");
        }

    }

    public void playerAttacks(Companion companion, Companion companionOpp){
        DamageType type = companion.getSpecialty();
        System.out.println("Choisissez votre type d'attaque:\n 1. "+type+"\n2. Normal");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();

        if(choix == 1){
            companion.attack(companionOpp, type);
            System.out.println("Vous avez lancé une attaque de type "+type+" !!!");
        }else{
            companion.attack(companionOpp, DamageType.NORMAL );
            System.out.println("Vous avez lancé une attaque de type Normal !!!");
        }
    }


    @Override
    public void display()  {
        System.out.println("Préparez vous au combat : "+companionTrainer.getName()+" VS "+opponent.getName());
        System.out.println("Choisis ton companion pour ce combat (0 , 1 ou 2 ou ....) : "+this.companionTrainer.toStringDex());

        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        Companion companion = companionTrainer.getCompanionDex().get(choix);
        Companion opp = opponent.getCompanionDex().get(0);

        while( !companion.isdead() && !opp.isdead()){
            System.out.println("Toi:"+companion+" Adversaire"+opp);
            playerAttacks(companion,opp);
            System.out.println("Toi:"+companion+" Adversaire"+opp);
            if(opp.isdead()){won=true;break;}
            opponentAttacks(companion,opp);
            if(companion.isdead()){won=false;}
        }
    }

    @Override
    public Node chooseNext() {

        if(won){
            System.out.println("Vous avez gagné !!");
            return this.getNextNodes().get(0);
        }else{
            System.out.println("Vous avez perdu :(");
            return this.getNextNodes().get(1);
        }

    }
}
