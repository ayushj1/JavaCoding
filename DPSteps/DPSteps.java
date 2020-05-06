public class DPSteps {
    public static int[] ways;

    public static int calculateWays(int i) {
        if(i==1) 
            return 1;
        if(i==2)
            return 2;
        if(i==3)
            return 4;
        if(ways[i] != 0)
            return ways[i];
        ways[i] = calculateWays(i-1) + calculateWays(i-2) + calculateWays(i-3);
        return ways[i];
    }

    public static void main(String[] args) {
        ways = new int[11];
        System.out.println("Number of ways of reaching 10 steps are: " + calculateWays(10));
    }
}