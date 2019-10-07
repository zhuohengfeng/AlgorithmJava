package d02_Sorting_Basic;

import utils.SortTestHelper;

/**
    选择排序
 算法思想：选择排序，从头至尾扫描序列，找出最小的一个元素，和第一个元素交换，接着从剩下的元素中继续这种选择和交换方式，最终得到一个有序序列。
*/
public class s01_selection_sort {

    public static void sort(Integer[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // // 寻找[i, n)区间里的最小值的索引
            for (int j = i+1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 找完一轮后，进行交换
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        SortTestHelper.printArrary(arr);
    }


    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(20, 10, 100);
        sort(arr, arr.length);
    }




}
