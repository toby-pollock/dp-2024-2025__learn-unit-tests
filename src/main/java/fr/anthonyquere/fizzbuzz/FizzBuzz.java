package fr.anthonyquere.fizzbuzz;

import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static List<String> startFizzBuzz(int count) {
        if (count == 0) {
            return List.of();
        }

        String[] fizzBuzzArray = new String[count];
        for (int i = 0; i < count; i++) {
            if ((i+1)%3 == 0 && (i+1)%5 == 0){
                fizzBuzzArray[i] = "FizzBuzz";
            } else if ((i+1)%3 == 0){
                fizzBuzzArray[i] = "Fizz";
            } else if ((i+1)%5 == 0) {
                fizzBuzzArray[i] = "Buzz";
            } else {
                fizzBuzzArray[i] = "";
            }
        }
        return List.of(fizzBuzzArray);
    }
}
