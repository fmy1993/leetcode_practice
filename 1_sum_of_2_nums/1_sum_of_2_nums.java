class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result= new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<len;i++){
             if((map.containsKey(target-nums[i]))&&map.get(target-nums[i])!=i)
                 return new int[]{i,map.get(target-nums[i])};
        }
       
        /*
        for(int i=0;i<len;i++){
             for(int j=(i+1);j<len;j++){
                 if((nums[i]+nums[j])==target)
                    {
                        result[0]=i;
                        result[1]=j;
                    }
            }
        } */

        return result;
    }
}