package mikecanco.de.libraryplusplus;

/**
 * Created by koalahamlet on 11/20/14.
 */
import java.io.IOException;

public class Solution {

    public static void main (String[] args) throws IOException {

        int total;
        int currentDivider;
        char[] array;
        for (String sting : args) {
            int counter = 0;
            total = Integer.parseInt(sting);
            array = sting.toCharArray();


            for (int i = 0; i< array.length; i++) {
                currentDivider = Integer.parseInt(String.valueOf(array[i]));
                if(currentDivider != 0 && total % currentDivider == 0) {
                    counter = counter++;
                }
            }
            System.out.println(counter);
        }
    }
}