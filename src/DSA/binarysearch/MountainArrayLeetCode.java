package DSA.binarysearch;

// Step 1: MountainArray Interface (LeetCode style)
interface MountainArray {
    int get(int index);
    int length();
}

// Step 2: Concrete Implementation for local testing
class MountainArrayImpl implements MountainArray {
    private int[] arr;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}

// Step 3: Solution logic (same as LeetCode)
class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakIndex(mountainArr);

        int firstTry = binarySearch(mountainArr, target, 0, peak, true);
        if (firstTry != -1) {
            return firstTry;
        }

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private int findPeakIndex(MountainArray mountainArr) {
        int st = 0;
        int end = mountainArr.length() - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    private int binarySearch(MountainArray mountainArr, int target, int st, int end, boolean isAsc) {
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            }

            if (isAsc) {
                if (val > target) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if (val < target) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }
        return -1;
    }
}

// Step 4: Main class (requested name)
public class MountainArrayLeetCode {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        int target = 6;

        MountainArray mountainArr = new MountainArrayImpl(arr);
        Solution solution = new Solution();

        int result = solution.findInMountainArray(target, mountainArr);
        System.out.println("Target found at index: " + result);
    }
}
