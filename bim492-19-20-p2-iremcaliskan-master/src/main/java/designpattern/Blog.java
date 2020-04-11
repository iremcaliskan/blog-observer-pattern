package designpattern;

import designpattern.observer.Observer;
import designpattern.observer.Subject;


import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject {

    private List<Observer> observersList;
    private boolean stateChange;

    public Blog() {
        this.observersList = new ArrayList<>();
        stateChange = false;
    }

    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void notifyObserver() {
        if (stateChange) {
            for (Observer observer : observersList) {
                observer.update();
            }
        }

    }

    public void unRegisterObserver(Observer observer) {
        observersList.remove(observer);
    }


    public Object getUpdate() {
        Object changedState = null;
        // should have logic to send the
        // state change to querying observer
        if (stateChange) {
            changedState = "New Artical! (By Observer Design Pattern)";
        }
        return changedState;
    }

    public void postNewArticle() {
        stateChange = true;
        notifyObserver();
    }
}
