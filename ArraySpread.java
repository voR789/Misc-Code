import java.util.Arrays;
import java.util.Scanner;

public class ArraySpread {

    public static Integer[] arr = new Integer[20];
    public static int[] input;
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of inputs: ");
        int len = scan.nextInt();
        input = new int[len];
        for(int i = 0; i < len; i++){
            input[i] = i+1;
        }
        System.out.println("Before: " + Arrays.toString(input));
        fill();
        System.out.println("After: " + Arrays.toString(arr));
    }

    public static void fill() {
        if (arr.length % input.length == 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = input[i / (arr.length / input.length)];
            }
            return;
        }

        int extras = arr.length % input.length;
        double key = (arr.length - extras) / (double) extras;
        double keyAdd = key;
        double shifter = key / 2;
        int count = 0;
        int arrCount = 0;

        for(int i = 0; i < arr.length; i++){
            int current = input[(count++ / (arr.length / input.length))];
            arr[arrCount++] = current;

            if((Math.round(keyAdd - shifter)) == count){
                i++;
                arr[arrCount++] = current;
                keyAdd += key;
            }
            /*Debug Code
            System.out.println("Extras: " + extras + "\n Key: " + key + "\n  Shifter: " + shifter);
            System.out.println("Key:" + keyAdd);
            System.out.println("Check: " + (Math.round(keyAdd - shifter)));
            System.out.println(list);
            System.out.println("adding " +current);
*/          }
/*
        //dirty fill : broken code
        int extras = arr.length % input.length;
        double key = (arr.length - extras) / (double) extras;
        double shifter = key / 2;
        // Debug Code
            System.out.println("Extras: " + extras + "\nKey: " + key + "\nShifter: " + shifter);
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int current = input[(count++ / (arr.length / input.length))];
                // Debug Code
                System.out.println(current);
                arr[i] = current;
                if (i % key >= shifter) {
                    // Debug Code
                    System.out.println("adding" + current);
                    i++;
                    arr[i] = current;
                    extras--;
                }
                // Debug Code
                System.out.println(Arrays.toString(arr));
            }*/
    }
}
