package tools;

public interface SceneObservable {
	public void notifyObservers();
	public boolean remove(Observer obs);
	public boolean add(Observer obs);
	public double getWidth();
	public double getHeight();
}
