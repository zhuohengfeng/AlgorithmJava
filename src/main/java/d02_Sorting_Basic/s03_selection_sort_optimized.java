package d02_Sorting_Basic;

import utils.SortTestHelper;

/**
 * 对选择排序的优化
 * 在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
 */
public class s03_selection_sort_optimized {

    public static void sort(Comparable[] arr){

        int left = 0, right = arr.length - 1;
        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if(arr[minIndex].compareTo(arr[maxIndex]) > 0)
                SortTestHelper.swapArrary(arr, minIndex, maxIndex);

            for(int i = left + 1 ; i < right; i ++)
                if(arr[i].compareTo(arr[minIndex]) < 0)
                    minIndex = i;
                else if(arr[i].compareTo(arr[maxIndex]) > 0)
                    maxIndex = i;

            SortTestHelper.swapArrary(arr, left, minIndex);
            SortTestHelper.swapArrary(arr, right, maxIndex);

            left ++;
            right --;
        }
    }
}
