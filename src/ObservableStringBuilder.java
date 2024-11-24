// Файл: src/main/java/ObservableStringBuilder.java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ObservableStringBuilder {
    private final StringBuilder stringBuilder;
    private final List<Consumer<String>> observers;

    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.observers = new ArrayList<>();
    }

    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(char c) {
        stringBuilder.append(c);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        notifyObservers();
        return this;
    }

    public int length() {
        return stringBuilder.length();
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public void addObserver(Consumer<String> observer) {
        observers.add(observer);
    }

    public void removeObserver(Consumer<String> observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        String currentState = stringBuilder.toString();
        for (Consumer<String> observer : observers) {
            observer.accept(currentState);
        }
    }
}
