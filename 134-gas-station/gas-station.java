class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0, totalCost=0;
        int start=0 , tank=0;

        for(int i=0; i<gas.length; i++){
            total+=gas[i];
            totalCost+=cost[i];
            tank+=gas[i]-cost[i];

            if(tank < 0){
                start=i+1;
                tank=0;
            }
        }
        return total < totalCost ? -1:start;
    }
}