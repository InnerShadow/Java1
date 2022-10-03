import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Scanner console = new Scanner(System.in);



    public static void main(String[] args) {
        final int size = args.length;
        Vector<Food> breakfast = new Vector<Food>();
        try {
            for (int i = 0; i < size; ++i) {
                switch (args[i]) {
                    case "Coctail": {
                        breakfast.add(new Cocktail("Coctail", args[++i], args[++i]));
                        break;
                    }
                    default: {
                        throw new RuntimeException("ClassnotFound");
                    }
                }
            }
        } catch (RuntimeException error){
            System.out.println(error.toString());
        }

        System.out.println("Youre breakfast: ");
        for(Food cock : breakfast){
            System.out.println(cock.toString());
        }

        System.out.println("Enter Cocteail to Compear: ");

        String drink = console.nextLine();
        String fruit = console.nextLine();

        Cocktail ToCompear = new Cocktail("Coctail", drink, fruit);

        Count(breakfast, ToCompear);

        System.out.println("Tatal caloris is: " + Calculate(breakfast));

    }

    static int Calculate(Vector<Food> breakfast){
        int caloris = 0;
        for(int i = 0; i < breakfast.size(); i++){
            caloris += breakfast.elementAt(i).calculateCalories();
        }
        return caloris;
    }

    static void Count(Vector<Food> breakfast, Cocktail ToCompear) {
        int counter = 0;
        for(int i = 0; i < breakfast.size(); i++){
            if(breakfast.elementAt(i).equals(ToCompear)){
                counter++;
            }
        }
        System.out.println(counter);
    }

}


