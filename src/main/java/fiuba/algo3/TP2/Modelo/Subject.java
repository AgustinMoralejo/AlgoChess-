package fiuba.algo3.TP2.Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void agregarObserver(Observer observer){

        observers.add(observer);

    }

    public void notificarObservers(){

        for(Observer unObserver: observers){
            unObserver.actualizar();
        }

    }



}
