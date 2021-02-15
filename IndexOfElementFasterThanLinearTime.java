// An sorted array of integers was rotated an unknown number of times.

// Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

// For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

// You can assume all the integers in the array are unique.


// Time complexity is O(log(n)) and sapce complexity is O(1).
class IndexOfElementFasterThanLinearTime {
	
    public int findIndex(int[] arr, int val) {
    	
        return solution(arr, val, 0, arr.length - 1);
    }

    private static int solution(int[] arr, int val, int left, int right) {

        if (left == right) {

            return arr[left] == val ? left : null;
        }

        int mid = (left + right) / 2;

        if (arr[left] <= arr[mid] && arr[left] <= val && val <= arr[mid]
                || arr[mid + 1] <= arr[right] && (arr[mid + 1] > val || val > arr[right])) {

            return solution(arr, val, left, mid);
    	}

        return solution(arr, val, mid + 1, right);
    }

    public static void main(String... args) {

    	IndexOfElementFasterThanLinearTime obj = new IndexOfElementFasterThanLinearTime();

        System.out.println(obj.findIndex(new int[] { 13, 18, 25, 2, 8, 10 }, 8));
    }
}