import java.util.Map;

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> countMatrix = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            countMatrix.putIfAbsent(nums1[i], 0);
            countMatrix.put(nums1[i], countMatrix.get(nums1[i]) + 1);
        }
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (countMatrix.containsKey(nums2[i]) && countMatrix.get(nums2[i]) > 0) {
                intersection.add(nums2[i]);
                countMatrix.put(nums2[i], countMatrix.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        return res;
    }
}