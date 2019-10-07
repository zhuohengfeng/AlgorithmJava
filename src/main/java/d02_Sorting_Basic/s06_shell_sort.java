package d02_Sorting_Basic;

/**
 * 希尔排序
 *
 * 算法思想：希尔算法又名缩小增量排序，本质是插入排序，
 * 只不过是将待排序的序列按某种规则分成几个子序列，
 * 分别对几个子序列进行直接插入排序。
 *
 * 这个规则就是增量，增量选取很重要，增量一般选序列长度一半，然后逐半递减，直到最后一个增量为1，为1相当于直接插入排序。
 */
public class s06_shell_sort {

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) { // 这里增加了一个分组的操作

            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }
}
