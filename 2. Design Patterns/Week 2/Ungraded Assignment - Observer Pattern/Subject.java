
// By https://hawshemi.com on 01-Jan-2022


public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
