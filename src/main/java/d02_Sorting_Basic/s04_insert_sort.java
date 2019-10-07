package d02_Sorting_Basic;

import utils.SortTestHelper;

import java.util.Arrays;

/**
 * 插入排序
 * 每个元素都和前面已经排序的原始进行比较，插入到合适的位置
 * 当到最后一个原始排序完后，就说明插入排序已经完成
 *
 * 算法思路：每趟将一个待排序的元素作为关键字，按照其关键字值得大小插入到已经排好的部分的适当位置上，知道插入完成。
 */
public class s04_insert_sort {


    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 版本1，这个版本效率比较慢，因为每次都要交互
        // 注意，这里从1开始，因为对于插入排序来说，第1个原始是不需要进行比较的
//        for (int i = 1; i < n; i++) {
//            // 可以看到，插入排序是可以提前结束的
//            for (int j = i; j > 0 && (arr[j].compareTo(arr[j-1]) < 0); j-- ) {
//                SortTestHelper.swapArrary(arr, j, j-1);
//            }
//        }

        // 版本2，先拷贝一份当前要比较的数，然后和前面原始比较是否要进行位移，如果需要进行位移，就把前面的元素往后移动。最后把保存下来的元素插入到合适的位置
        for (int i = 1; i < n; i++) {
            // 可以看到，插入排序是可以提前结束内层循环
            Comparable current = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1].compareTo(current) > 0; j-- ) {
                arr[j] = arr[j - 1];
            }
            arr[j] = current;
        }
    }


    public static void main(String[] args) {
        // 测试Integer
        Integer[] intArr = SortTestHelper.generateRandomArray(10000, 1, 1000); // 10w数据排序需要13422ms
        Integer[] copyArr = SortTestHelper.copyArray(intArr, intArr.length);

        SortTestHelper.testSort("d02_Sorting_Basic.s02_selection_sort_comparable", copyArr);
        SortTestHelper.printArrary(copyArr);

        SortTestHelper.testSort("d02_Sorting_Basic.s04_insert_sort", intArr);
        SortTestHelper.printArrary(intArr);
    }

}
