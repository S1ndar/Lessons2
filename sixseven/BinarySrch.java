package sixseven;

import java.util.Arrays;

public class BinarySrch {
    static void main() {
        int[] arr = {1,2,3,4,5,6,7,434,67};
        Arrays.sort(arr);
        System.out.println(binar(arr,1,0,arr.length - 1));
        System.out.println(line(arr,1));
    }
    public static int binar(int[] arr, int el,int l,int h){
        int m = l + (h - l) / 2;
        if (l > h){
            System.out.println("Не нашли :(");
            return -1;
        }
        if (arr[m] == el){
            System.out.println("Нашли "+el);
            return m;
        }
        if (arr[m] > el){
            return binar(arr,el,l,m-1);
        }
        return binar(arr,el,m+1,h);
    }

    public static int line(int[] arr,int el){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == el){
                return i;
            }
        }
        return -1;
    }
}
