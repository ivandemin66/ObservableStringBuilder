// Файл: src/main/java/Main.java
public class Main {
    public static void main(String[] args) {
        ObservableStringBuilder osb = new ObservableStringBuilder();

        // Добавляем наблюдателей
        osb.addObserver(state -> System.out.println("Observer 1: New state -> " + state));
        osb.addObserver(state -> System.out.println("Observer 2: New state -> " + state));

        // Вносим изменения
        osb.append("Hello");
        osb.append(", World!");
        osb.delete(5, 7);
        osb.replace(7, 12, "Java");

        // Вывод текущего состояния
        System.out.println("Final state: " + osb.toString());
    }
}
