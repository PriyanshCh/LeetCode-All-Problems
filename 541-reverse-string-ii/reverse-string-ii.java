class Solution {

    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {

            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            reverse(arr, left, right);
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}