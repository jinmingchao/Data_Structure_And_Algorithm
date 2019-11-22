package noctis.practice;

import jdk.jfr.Description;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author Bob Jin
 * @date 2019/11/17/7:05
 * @description: TODO
 */
public class SelectionProblems {
    /**
     * @Description: Get the 3rd biggest number in whole input numbers.
     * @Param [input_arr]
     * @Return int
     * @Throw
     * @Author Bob Jin
     * @Date 2019/11/17 20:49
     */
    private static int sortArrayInDecreaseOrder(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }
        return arr[3];
    }

    /**
     * @Description: Get the 3rd biggest number in whole input numbers.
     * @Param [arr]
     * @Return int
     * @Throw
     * @Author Bob Jin
     * @Date 2019/11/17 21:27
     */
    private static int getTheThirdBiggestNumber(int arr[]) {
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[j] > arr[i]) {
                    int a = arr[j];
                    arr[j] = arr[i];
                    arr[i] = a;
                }
            }
        }
        for (int ele : arr
        ) {
            System.out.print(ele + "\t");
        }
        System.out.println();
        for (int i = 3; i < arr.length; i++) {
            // if arr[i] bigger than arr[2],then
            // 1.put it into the right position of the array
            // 2.and pop one element from the array.
            // Otherwise,ignores it.
            arr = compareAndOrderTheElement(arr, i);

        }
        for (int ele : arr
        ) {
            System.out.print(ele + "\t");
        }
        return arr[3];
    }

    private static int[] compareAndOrderTheElement(int[] arr, int i) {
        int position = 0;
        if (arr[i] > arr[2] && arr[i] <= arr[1])
            position = 2;
        else if (arr[i] > arr[1] && arr[i] <= arr[0])
            position = 1;
        return putAndRemoveElements(arr, position, i);

    }

    private static int[] putAndRemoveElements(int[] arr, int position, int i) {

        List list = Arrays.asList(arr);
        if (position != 0) {
            List l_1 = list.subList(0, position);
            l_1.add(arr[i]);
            List l_2 = list.subList(position, list.size() - 1);
            l_2.remove(i);
            l_1.addAll(l_2);
            list = l_1;
        } else {
            list.remove(i);
            ((LinkedList) list).addFirst(arr[i]);
        }
        Iterator iterator = list.iterator();
        int t = 0;
        int[] res = new int[]{};
        while (iterator.hasNext()) {
            res[t] = (int) iterator.next();
            t++;
        }
        return res;

    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.round(Math.random() * 1000));
        }
//        sortArrayInDecreaseOrder(arr);
        getTheThirdBiggestNumber(arr);

    }
}
