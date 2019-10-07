package d02_Sorting_Basic;

import utils.SortTestHelper;

/**
 * 冒泡排序
 * 算法原理：比较两个相邻的元素，将值大的元素右移。
 *
 * 算法思路：首先第一个元素和第二个元素比较，如果第一个大，则二者交换，否则不交换；
 * 然后第二个元素和第三个元素比较，如果第二个大，则二者交换，否则不交换……一直执行下去，
 * 最终最大的那个元素被交换到最后，一趟冒泡排序完成。最坏的情况是排序是逆序的。
 */
public class s05_bubble_sort {

    public static void sort(Comparable[] arr){

        int n = arr.length;
        boolean swapped = false;

        do{
            swapped = false;
            for( int i = 1 ; i < n ; i ++ ) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SortTestHelper.swapArrary(arr, i - 1, i);
                    swapped = true;
                }
            }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n --; //!!!!!!!!!!!!!!
        }while(swapped);
    }


    public static void sort2(Comparable[] arr){

        int n = arr.length;
        int newn; // 使用newn进行优化

        do{
            newn = 0;
            for( int i = 1 ; i < n ; i ++ )
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    SortTestHelper.swapArrary( arr , i-1 , i );

                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            n = newn;
        }while(newn > 0);
    }


}
