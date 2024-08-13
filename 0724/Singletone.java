/**
 * Singletone
 */
public class Singletone {
    static Singletone singletone;

    private Singletone() {
        singletone = new Singletone();
    }

    public Singletone getSingletone() {
        return singletone;
    } 
}