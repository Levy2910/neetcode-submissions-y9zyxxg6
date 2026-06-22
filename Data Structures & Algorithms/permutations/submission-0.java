class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, int index, List<Integer> temp){
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }else if (temp.size() < nums.length ){
            for (int i= 0; i < nums.length; i++){
                if (!temp.contains(nums[i])){
                    temp.add(nums[i]);
                    backtrack(nums, res, 0, temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
