import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        DogWalker c = new DogWalker();
        System.out.println(c);
        int hr = c.addDogs();
        System.out.println(c);
        DogWalker w = new DogWalker(4,c);
        System.out.println(w.walkDogs(hr)+ " dogs walked. ");
        System.out.println(c.numAvailableDogs(hr)+ " dogs remaining. ");

        for (int i = 7; i<11; i++) {
            c.addDogs();
        }

        System.out.println(c);
        w = new DogWalker(3, c);
        System.out.println("$" + w.dogWalkShift(7, 10) + ".00 earned ");
    }
}