class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : map.keySet()){
            int fre = map.get(key);
            freq[fre].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >=0; i--){
            if (!freq[i].isEmpty()){
                for (int num : freq[i]){
                    if (k != 0){
                    k--;
                    res[index]= num;;
                    index++;
                    }else{
                    return res;
                    }
                }
            }
        }
        return res;
    }
}
