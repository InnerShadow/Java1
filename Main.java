package rfe.bsu.SikolenkoMa.laba1;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        final int size = args.length;
        Vector<Food> breakfast = new Vector<Food>();

//        System.out.println(Cocktail.class.getName());
        try {
            for (int i = 0; i < size; ++i) {
                switch (args[i]) {
                    case "Coctail": {
                        try {
                            Cocktail coctail = null;
                            Class clazz = Class.forName(Cocktail.class.getName());
                            Class[] params = {String.class, String.class, String.class};
                            coctail = (Cocktail) clazz.getConstructor(params).newInstance("Coctail", args[++i], args[++i]);
                            //System.out.println(coctail.toString());
                            breakfast.add(coctail);
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                                 NoSuchMethodException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "Chees": {
                        breakfast.add(new Chees("Chees"));
                        break;
                    }
                    case "Apple": {
                        breakfast.add(new Apple("Apple", args[++i]));
                        break;
                    }
                    default: {
                        if (args[i].charAt(0) == '-') {
                            break;
                        }
                        throw new RuntimeException("Class " + args[i] + " not Found");
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
        try {
            Cocktail ToCompear = null;
            Class clazz = Class.forName(Cocktail.class.getName());
            Class[] params = {String.class, String.class, String.class};
            ToCompear = (Cocktail) clazz.getConstructor(params).newInstance("Coctail", drink, fruit);
            Count(breakfast, ToCompear);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


        if(IfCalories(args)) {
            System.out.println("Tatal caloris is: " + Calculate(breakfast));
        }

        if(IfSorted(args)) {
            TreeSet<Food> sortBreakfast = new TreeSet<Food>(new Comparator<Food>() {
                public int compare(Food i1, Food i2) {
                    if (i1.calculateCalories() > i2.calculateCalories()) {
                        return -1;
                    } else if (i1.calculateCalories() < i2.calculateCalories()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            sortBreakfast.addAll(breakfast);


            for(Food f : sortBreakfast){
                System.out.println(f);
            }
        }

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
        System.out.println("Num of same elements is/are: " + counter);
    }

    static boolean IfCalories(String[] arguments){
        for(String s : arguments){
            if(s.compareTo("-calories") == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean IfSorted(String[] arguments){
        for(String s : arguments){
            if(s.compareTo("-sort") == 0) {
                return true;
            }
        }
        return false;
    }


}
