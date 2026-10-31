package sixseven;

import java.util.Arrays;
import java.util.Random;

public class Arr {
    static void main() {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int iMin = 0;
        int iMax = 0;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] == min){
                iMin = i;
            }
            if(arr[i] == max){
                iMax = i;
            }
        }

        System.out.println(STR."\{min} \{iMin}\t\{max} \{iMax}");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
