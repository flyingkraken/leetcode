class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> r = new HashSet<>();
        find(0, nums, new LinkedList(), r);
        return new ArrayList(r);
    }

    void find(int start, int[] nums, LinkedList<Integer> list, Set<List<Integer>> r) {
        if (list.size() >= 2)
            r.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++)
            if (list.isEmpty() || list.getLast() <= nums[i]) {
                //add -> 迭代 -> removeLast, 最终实现枚举
                list.add(nums[i]);
                find(i + 1, nums, list, r);
                list.removeLast();
            }
    }
}
