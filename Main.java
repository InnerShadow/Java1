import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        final int size = 5;
        Food[] breakfast = new Food[size];
        for(int i = 0; i < size; i++){
            System.out.println("Enter " + (i + 1) + " Coctail: ");
            String drink = console.nextLine();
            String fruit = console.nextLine();
            breakfast[i] = new Cocktail("Coctail", drink, fruit);
        }

        for(int i = 0; i < size; i++){
            System.out.println(breakfast[i].toString());
        }

        System.out.println("Enter Cocteail to Compear: ");

        String drink = console.nextLine();
        String fruit = console.nextLine();

        Cocktail ToCompear = new Cocktail("Coctail", drink, fruit);

        Count(breakfast, size, ToCompear);

        System.out.println("Tatal caloris is: " + Calculate(breakfast, size));

    }

    static int Calculate(Food[] breakfast, int size){
        int caloris = 0;
        for(int i = 0; i < size; i++){
            caloris += breakfast[i].calculateCalories();
        }
        return caloris;
    }

    static void Count(Food[] breakfast, int size, Cocktail ToCompear) {
        int counter = 0;
        for(int i = 0; i < size; i++){
            if(breakfast[i].equals(ToCompear)){
                counter++;
            }
        }
        System.out.println(counter);
//        try {
//            int x = System.in.read();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}


