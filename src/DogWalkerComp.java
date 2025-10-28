import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DogWalkerComp {
    private int maxDogs;
    private DogWalkerComp company;
    private int[] schedule;
    public DogWalkerComp(int max, DogWalkerComp comp) {
        maxDogs= max;
        company = comp;
    }
    public DogWalkerComp(int [] dogs){
        schedule = dogs;
    }

    public DogWalkerComp() {
        schedule = new int[24];
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < schedule.length; i++) {
            s += i + " " + schedule[i] + "\n";
        }
        return s;
    }
    public int addDogs() {
        Scanner s = new Scanner(System.in);
        System.out.println("What hour");
        int hr = s.nextInt();
        System.out.println("How many dogs?");
        int dogs = s.nextInt();
        schedule[hr] = dogs;
        return hr;
    }
    public int walkDogs( int hour) {
        if (company == null) return 0;
        int dogs = company.numAvailableDogs(hour);
        if (dogs < maxDogs){
            company.updateDogs(hour, dogs);
            return dogs;
        }
        else{
            company.updateDogs(hour, maxDogs);
            return maxDogs;
        }
    }
    public int dogWalkShift(int startHour, int endHour) {
        int pay = 0;
        int dogs = 0;
        while (startHour <= endHour) {
            dogs = walkDogs(startHour);
            pay += dogs * 5;
            if (dogs == maxDogs || startHour >= 9 && startHour <= 17) {
                pay += 3;
            }
            startHour++;
        }
        return pay;
    }
    public int numAvailableDogs ( int hour){
        return schedule[hour];
    }
    public void updateDogs(int hour, int numberDogsWalked){
        schedule[hour] -= numberDogsWalked;
    }

}