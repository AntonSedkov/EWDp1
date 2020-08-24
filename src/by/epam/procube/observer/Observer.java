package by.epam.procube.observer;

import java.util.EventObject;

public interface Observer<T extends EventObject> {

    void actionPerformer(T t);

}