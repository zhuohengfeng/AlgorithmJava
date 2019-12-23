/**
 * 包含7中排序：冒泡排序，选择排序，插入排序，希尔排序，归并排序，快速排序，堆排序
 */
public class SortingUtils {

    /**
     * 一，冒泡排序 时间复杂度O(n*n)
     *比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤，除了最后一个。持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * Java实现
     *
     * 加入标记状态 flag 若在一次冒泡中，没有交换 则说明可以停止 减少运行时
     */
    public static void bubbleSort(int[] data) {
        int size = data.length;
        boolean flag = true;
        for (int i = 0; i < size - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < size - 1 - i; j++) { // 经过冒泡后，最大的已经升到最上面了，所以这里要-i
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = true;
                }
            }
        }

    }

    /**************************************************************************************/
    /**
     * 二，选择排序算法  时间复杂度O(n*n) 性能上优于冒泡排序 交换次数少
     * 基本思想：
     * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public static void selectSort(int[] data) {
        int size = data.length;
        for (int i = 0; i < size - 1; i ++) {
            int pos = i;
            for (int j = i; j < size -1; j++) {
                if (data[pos] > data[j + 1]) {
                    pos = j+1; // 保存当前这一轮最小的值
                }
            }
            if (pos != i) {
                int temp = data[pos];
                data[pos] = data[i];
                data[i] = temp;
            }
        }
    }

    /**************************************************************************************/
    /**
     * 三，插入排序算法  O(n*n) 性能上优于冒泡排序和选择排序
     * 基本思想：
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     *
     */
    public static void insertSort(int[] data) {
        int size = data.length;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j-1]) {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
                else {
                    break; // 因为前面都已经是有序的，可以提前结束
                }
            }
        }
    }

    /**************************************************************************************/
    /**
     * 四，希尔排序算法 时间复杂度O(n^1.5）
     * 基本思想：
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     *
     * 希尔排序的原理:根据需求，如果你想要结果从小到大排列，它会首先将数组进行分组，然后将较小值移到前面，较大值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，
     * 可以说希尔排序是加强 版的插入排序 拿数组5, 2,8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从小到大排列，所以小的会排在前面，第一次排序后数组为5, 1, 3, 4, 2, 8，9
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序， 实现数组从大到小排
     */
    public static void shellSort(int[] data) {}

    /**************************************************************************************/
    /**
     * 五，堆排序算法  时间复杂度O(nlogn）不适合待排序序列较少的情况
     * 基本思想:
     * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     *
     * 堆的定义下：具有n个元素的序列 （h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=h2i+1）或（hi<=h2i,hi<=h2i+1） (i=1,2,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。
     *
     * 思想:初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
     */
    public static void heapSort(int[] data){}


    /**************************************************************************************/
    /**
     * 六，快速排序算法
     *
     * 时间复杂度O(nlogn）
     *
     * 快速排序在序列中元素很少时，效率将比较低，不如插入排序，因此一般在序列中元素很少时使用插入排序，这样可以提高整体效率。
     *
     * 基本思想：
     * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序。
     */
    public static void quick(int[] data) {
        _quickSort(data, 0, data.length - 1);
    }

    private static void _quickSort(int[] data, int left, int right){
        if (left >= right) {
            return;
        }
        int middle = _getMiddle(data, left, right);
        _quickSort(data, left, middle - 1);
        _quickSort(data, middle+1, right);
    }

    private static int _getMiddle(int[] data, int left, int right){
        int temp = data[left]; // 数组的第一个作为中轴
        while (left < right) {
            while (left < right && data[right] > temp) {
                right--;
            }
            data[left] = data[right]; // 比中轴小的记录移到低端
            while(left < right && data[left] < temp) {
                left++;
            }
            data[right] = data[left];
        }
        data[left] = temp;
        return left;
    }



    /**************************************************************************************/
    /**
     *
     * 七，归并排序算法 时间复杂度O(nlogn)
     *
     * 基本思想:
     * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     */
    public static int[] sort(int[] data, int low, int high) {
        return null;
    }



    /**************************************************************************************/
    public static void main(String[] args) {
        int[] srcData = {2, 4, 11, 9, 23, 6, 12, 33, 55, 24, 4, 8, 43, 23, 1, 0, 27, 3};
        printArrays("\n排序前", srcData);
        quick(srcData);
        printArrays("排序后", srcData);

    }


    public static void printArrays(String tag, int[] data) {
        System.out.print(tag + " : ");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }


}
