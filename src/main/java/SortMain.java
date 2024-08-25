public class SortMain {
    public static void quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    private static void partition(int[] arr, int low, int high) {
        // 选择数组的最后一个元素作为枢纽值
        if(low < high) {
            int pivot = arr[low];
            int i = low;

            // 遍历数组，将小于枢纽值的元素放到左边，大于枢纽值的元素放到右边
            for (int j = low + 1; j <= high; j++) {
                if (arr[j] < pivot) {
                    // 交换 arr[i] 和 arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i = j;
                }
            }
            partition(arr, low, i - 1);
            partition(arr, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1};
        quickSort(arr);
    }
}
