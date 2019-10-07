package d02_Sorting_Basic;

import utils.SortTestHelper;

/**
 * 使用comparable进行类比较，这样就可以适用于任何类型
 *
 */
public class s02_selection_sort_comparable {


    /**
     *  定义一个内部类，实现Comparable
     *  在非静态的内部类中，存在一个隐藏的外部类引用字段，在构造内部类时，用于指向外部类的引用。
     *  每次生成一个非静态的内部类实例，都会有这样的操作。
     * 所以，在定义一个内部类时，如果该内部类不需要引用外部类的非静态属性/方法，则应该将它声明为静态的。
     */
    public static class Student implements Comparable<Student> {

        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        // 定义Student的compareTo函数
        // 如果分数相等，则按照名字的字母序排序
        // 如果分数不等，则分数高的靠前
        public int compareTo(Student that) {
            if (this.score < that.score) {
                return -1;
            }
            else if (this.score > that.score)  {
                return 1;
            }
            return this.name.compareTo(that.name);
        }

        @Override
        public String toString() {
            return "Student: " + this.name + " " + this.score;
        }
    }


    /**
     * 使用comparable来进行"泛型"的操作
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) { // 注意这里比较语句
                    minIndex = j;
                }
            }
            SortTestHelper.swapArrary(arr, minIndex, i);
        }
        SortTestHelper.printArrary(arr);
    }



    public static void main(String[] args) {
        // 测试Integer
        Integer[] intArr = SortTestHelper.generateRandomArray(100000, 1, 10000); // 10w数据排序需要10181ms
        SortTestHelper.testSort("d02_Sorting_Basic.s02_selection_sort_comparable", intArr); // 传入包名，使用反射进行调用

//        // 测试String
//        String[] strArr = {"a", "abc", "A", "cc", "efe", "zz", "a12344", "11", "344", "e3riu"};
//        SortTestHelper.testSort("d02_Sorting_Basic.s02_selection_sort_comparable", strArr);
//
//
//        // 测试指定类型
//        Student[] students = new Student[4];
//        students[0] = new Student("D",90);
//        students[1] = new Student("C",100);
//        students[2] = new Student("B",95);
//        students[3] = new Student("A",95);
//        SortTestHelper.testSort("d02_Sorting_Basic.s02_selection_sort_comparable", students);
    }

}
