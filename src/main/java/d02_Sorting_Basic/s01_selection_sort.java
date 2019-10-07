package d02_Sorting_Basic;

import utils.SortTestHelper;

/**
    选择排序
 1. 使用泛型
 2. 测试例辅助类，产生随机数组
 3.
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
