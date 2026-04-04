class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)){
            return 0;
        }
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i < size; i++){
                String currWord = queue.poll();
                if (currWord.equals(endWord)){
                    return level;
                }
                char[] arr = currWord.toCharArray();
                // ['c', 'a', 't']
                for (int j =0; j < arr.length; j++){
                    char original = arr[j];
                    for (char k = 'a'; k <= 'z'; k++){
                        arr[j] = k;
                        String ns = new String(arr);
                        if (set.contains(ns)){
                            queue.add(ns);
                            set.remove(ns);
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
