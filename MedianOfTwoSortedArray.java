class MedianOfTwoSortedArray {
    // https://www.jiuzhang.com/solution/median-of-two-sorted-arrays/
    // 4. Median of Two Sorted Arrays
    // time O(n)
    // using priorityqueue, put all number into PQ and pop until mid position
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }

        PriorityQueue<Integer> nums = new PriorityQueue<>();
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        for (int i = 0; i < len1; i++) {
            nums.add(nums1[i]);
        }
        for (int i = 0; i < len2; i++) {
            nums.add(nums2[i]);
        }
        int len = nums.size();
        if (len == 1) {
            return nums.poll() + 0.0;
        }
        boolean isEven = len % 2 == 0;
        int mid = len/2;
        double res = 0.0;
        for (int i = 0; i < mid; i++) {
            res = nums.poll() + 0.0;
        }
        if (!isEven) {
            return nums.poll() + 0.0;
        } else {
            return (res + nums.poll())/2.0;
        }
    }

    // o(n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            list.add(nums2[j]);
        }
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1))/2.0;
        } else {
            return list.get(list.size() / 2) + 0.0;
        }
    }



    /*************************/
    // 分治法。时间复杂度 log(n + m)log(n+m)
    public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length + B.length;
        
        if (n % 2 == 0) {
            return (
                findKth(A, 0, B, 0, n / 2) + 
                findKth(A, 0, B, 0, n / 2 + 1)
            ) / 2.0;
        }
        
        return findKth(A, 0, B, 0, n / 2 + 1);
    }

    // find kth number of two sorted array
    // K is 1 based number, as for index it should be k - 1
    public static int findKth(int[] A, int startOfA,
                              int[] B, int startOfB,
                              int k){       
        // A has already been passed                          
        if (startOfA >= A.length) {
            return B[startOfB + k - 1];
        }

        // B has already been passed
        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }

        // k == 1 means we only need the first smallest element
        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }
        
        // 拿到 A 和 B 的 half of K 的位置的数
        /*
        A =  1 2 3
        B = 4 5
        K = 3
        halfKthOfA = (0 + 2 - 1 < A.length ? A[0 + 2 - 1] : Integer.MAX_VALUE = 2
        halfKthOfB = 5

        2 < 5
        it means we shoud abandon left half of A
        next Interation of findKth should start from the first element after 2 in A
        otherwise, abandon the right half of B
        

        */
        int halfKthOfA = startOfA + k / 2 - 1 < A.length
            ? A[startOfA + k / 2 - 1]
            : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k / 2 - 1 < B.length
            ? B[startOfB + k / 2 - 1]
            : Integer.MAX_VALUE; 
        
        if (halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        } else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    }
}