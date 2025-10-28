import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Main {
    public static int read() throws FileNotFoundException{
        int money = 0;
        DogWalkerComp[] companies = new DogWalkerComp[1000];
        File f = new File("src/Companies.txt");
        Scanner s = new Scanner(f);
        int index = 0;
        while(s.hasNextLine() && index < companies.length) {
            int[] dogs = new int[24];
            for (int i = 0; i < dogs.length && s.hasNextInt(); i++) {
                dogs[i] = s.nextInt();
            }
                companies[index] = new DogWalkerComp(dogs);
                index++;
            }
            DogWalkerComp[] walkers = new DogWalkerComp[(int)Math.pow(10,4)];
            f= new File("src/walkers.txt");
            s = new Scanner(f);
            index=0;
            while (s.hasNextLine() && index < walkers.length) {
                int dogs = s.nextInt();
                DogWalkerComp company = companies[s.nextInt()];
                walkers[index] = new DogWalkerComp(dogs, company);
                int start = s.nextInt();
                int end = s.nextInt();
                money += walkers[index].dogWalkShift(start, end);
                index++;
            }
            return money;

        }

    public static void main (String[] args) throws FileNotFoundException {

        System.out.println(read());
    }
}
