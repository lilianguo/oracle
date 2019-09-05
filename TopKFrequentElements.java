class TopKFrequentElements {
    // https://leetcode.com/problems/top-k-frequent-elements/solution/
    // time: O(NlogK)
    // space: O(N)
    // Time complexity : O(Nlog(k)). 
    // The complexity of Counter method is O(N). 
    // To build a heap and output list takes O(Nlog(k). 
    // Hence the overall complexity of the algorithm is O(Nlog(k).
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new Hashmap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> top_k = new ArrayList<>();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }
        Collections.sort(top_k);
        return top_k;
    }
}