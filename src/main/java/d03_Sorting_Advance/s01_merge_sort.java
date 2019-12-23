package d03_Sorting_Advance;

import utils.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序
 * 算法思想：归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分：问题分成一些小的问题然后递归求解，治：的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * 将序列递归拆半分成多个子序列，再将各个子序列排序后归并叠加，最后归并所有子序列，排序完成。
 */
public class s01_merge_sort {

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void _merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }


    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void _sort(Comparable[] arr, int l, int r) {
        // 先设置递归退出条件
        if (l >= r) {
            return;
        }

        int mid = (l+r) / 2;
        _sort(arr, l, mid);
        _sort(arr, mid+1, r);
        _merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        _sort(arr, 0, n-1);
    }


    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("d03_Sorting_Advance.s01_merge_sort", arr);

    }

}
