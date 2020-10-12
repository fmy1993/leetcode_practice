class Solution {
    public int maxArea(int[] height) {
        int len = height.length;

        if(height==null||len<2)
            return 0;
        if(len==2)
            return getArea(0,1,height);
     
        int step_left = 0;
        int step_right = len-1;
        int loop = len;
        int diversion = -1;
        int max_volume = getArea(step_left,step_right,height);
        int temp_volume = 0;
        int left_side = step_left;
        int right_side = step_right;
        while(step_left!=step_right){
            diversion = getSmallerSide(step_left,step_right,height);
            if(diversion == 0)
                step_left++;
            if(diversion == 1)
                step_right--;
           
            temp_volume = getArea(step_left,step_right,height);
            if(temp_volume>max_volume){
                max_volume = temp_volume;
                left_side = step_left;
                right_side = step_right; 
            }
            loop--;
        }
        return  getArea(left_side,right_side,height);  
    }
    /*
        0 stands for left side, 1 stands for right side
    */
    public int getSmallerSide(int left,int right,int[] height){
        return height[left]>height[right]?1:0;
    }

     public int getHighestIndex(int[] height){
            int max = 0;
            int len = height.length;
            for(int i=0;i<len;i++){
                if(height[i]>max)
                    max = i;
            }
            return max;
        }
    public int getArea(int startindex,int endindex,int[] height){
        int bottom = endindex-startindex;
        int sum = (height[startindex]>height[endindex])?bottom*height[endindex]:bottom*height[startindex];
        return sum;//bottom;//
    }
}