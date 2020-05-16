import java.util.*;

public class SortNearlySorted {
    public static void main(String[] args) {
        SortNearlySorted sns = new SortNearlySorted();
        int[] nums = {1,2,3,5,6,4,8,7};
        int k = 2;
        int j = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            if(i>k)
                nums[j++] = minHeap.poll();
            minHeap.add(nums[i]);
        }
        while(minHeap.size()>0) {
            nums[j++] = minHeap.poll();
        }
        for(int i=0; i<nums.length; i++) {
            System.out.println("" + nums[i] + " ");
        }
    }
}