package DynamicProgramming;

/**
 * Created by Lin on 2017/7/11.
 */
public class GasStation {
    /**
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
     * You begin the journey with an empty tank at one of the gas stations.
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     *
     * @see <a href="https://leetcode.com/problems/gas-station/#/description">LeetCode</a>
     *
     * @param gas An array
     * @param cost An array
     * @return Index if you can travel around the circuit once, otherwise return -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int index = 0;

        // 检查是否可走完全程
        int sum = 0;
        for(int i = 0; i < gas.length; i++) sum += gas[i] - cost[i];
        if(sum < 0) return -1;

        // index必为最大子序列的头元素
        int curSum = 0;
        for(int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            if(curSum < 0){
                curSum = 0;
                index = i + 1;
            }
        }

        return index;
    }
}
