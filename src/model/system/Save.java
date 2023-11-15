package model.system;

import model.system.nodeSyst.Node;

import java.util.ArrayList;

public class  Save<E> {
   Object saveSlot;
   Object SaveState;
   Object Game;

   private ArrayList<E> history;

   public Save(){
      history = new ArrayList<>();
   }


   public void AddSavePoint(E n){
      history.add(n);
   }

   public E getSavePoint(int i){System.err.println("SAVE");
      return history.get(i);
   }
   public ArrayList<E> getHistory() {
      return history;
   }
}
