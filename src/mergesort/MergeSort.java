package mergesort;

import java.util.Scanner;

/**
 * Created by shassanzafar on 6/15/2015.
 */
public class MergeSort {
    int size;


    public void mergesort(int array[])
    {
        if(array.length<2) return;

        int middle = array.length/2;

        int left [] = new int[middle];
        int right [] = new int[array.length - middle];

        int i = 0; int j = middle;

        while(i < middle || j<array.length)
        {
            if(i<middle)
                left[i] = array[i];
            right[i] = array[j];
            i++;j++;
        }

        mergesort(left);
        mergesort(right);
        doMerge(left,right,array);
    }

    public static void doMerge(int left[], int right[], int array[])
    {
        int i = 0,j = 0,k = 0;

        while(i < left.length && j < right.length)
        {
            if(left[i]<right[j])
            {
                array[k] = left[i];
                i++;
            }
            else
            {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length)
        {
            array[k] = left[i];
            k++;
            i++;
        }
        while(j < right.length)
        {
            array[k] = right[j];
            k++;
            j++;
        }

    }

    public static void main(String a[])
    {
        MergeSort mergeSort = new MergeSort();
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter size");
        mergeSort.size = scn.nextInt();
        int arr[] = new int[mergeSort.size];

        for(int i = 0; i<mergeSort.size;i++)
            arr[i] = scn.nextInt();

        mergeSort.mergesort(arr);

        System.out.println("The sorted array is:");
        for (int i = 0; i<arr.length;i++)
            System.out.print(arr[i]+ " ");


    }
}
