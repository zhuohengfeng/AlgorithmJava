package d02_Sorting_Basic;

import utils.SortTestHelper;

/**
 * 插入排序
 * 每个元素都和前面已经排序的原始进行比较，插入到合适的位置
 * 当到最后一个原始排序完后，就说明插入排序已经完成
 */
public class s03_insert_sort {


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 注意，这里从1开始，因为对于插入排序来说，第1个原始是不需要进行比较的
        for (int i = 1; i < n; i++) {
            // 可以看到，插入排序是可以提前结束的
            for (int j = i; j > 0 && (arr[j].compareTo(arr[j-1]) < 0); j-- ) {
                SortTestHelper.swapArrary(arr, j, j-1);
            }
        }
        SortTestHelper.printArrary(arr);
    }


    public static void main(String[] args) {
        // 测试Integer
        Integer[] intArr = SortTestHelper.generateRandomArray(100000, 1, 10000); // 10w数据排序需要13422ms
        SortTestHelper.testSort("d02_Sorting_Basic.s03_insert_sort", intArr);
    }

}
