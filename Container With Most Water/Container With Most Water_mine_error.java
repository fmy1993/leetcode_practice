
public class local_solution {

	public static void main(String[] args) {
		int[] test={1,2,1};//{1,8,6,2,5,4,8,3,7};//{1,8,6,2,5,4,8,25,7};
		local_solution ls =new local_solution();
		ls.maxArea(test);

	}
	
	
	public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int area_left = 0;
        int area_right = 0;

        int step_left = 0;
        int step_right = 0;

        int boundary_left = 0;
        int boundary_right = 0;
        if(height==null||len<2)
            return 0;
        if(len==2)
            return getArea(0,1,height);
        max = getHighestIndex(height);
        step_left = max;
        step_right = max;
        boundary_left = max;
        boundary_right = max;
        // area_left = getArea(step_left-1,max,height);
        // area_right = getArea(max,step_left+1,height);
        int loop = len;
        while(loop+20>0){//consider last time
            if(step_left>0)
                step_left--;
                
            if(step_right<len-1)
                step_right++;

            //控制下标和计算语句最好分开处理
            area_left = getArea(step_left,boundary_right,height);
            area_right = getArea(boundary_left,step_right,height);

            if(area_left>area_right&&boundary_left>=0){
                boundary_left=step_left;
                if(boundary_left>0)
                    step_right=boundary_right;
            }
                
            if(area_left<area_right&&boundary_right<=len-1){
                boundary_right=step_right;
                if(boundary_right<len-1)
                    step_left=boundary_left;
            }
             if(area_left==area_right&&boundary_right<=len-1&&boundary_left>=0){
                boundary_right++;
                boundary_left++;
                step_right = boundary_right;
                step_left = boundary_left;
            }
 
            loop--;

            if(step_left==0&&step_right==len-1)
                return getArea(boundary_left,boundary_right,height);
        }

        // long=end-start
        // height = low(end,start)

        //randomly choose? one rectangle,value equal to height(i,i+1),

        //only have 2 ways,turn left and right
        //choose highest num as start index
        //highest num must be contained in final rectangle
        //what is end condition?
        //1.range of array
        //2. if moving  decrease sum both sides, keep the two side flags,but continue till the          end
        return getArea(boundary_left,boundary_right,height);
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
