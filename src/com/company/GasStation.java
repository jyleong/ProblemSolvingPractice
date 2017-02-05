package com.company;

/**
 * Created by JamesL on 2/4/2017.
 */
/*
* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note:
The solution is guaranteed to be unique.

#################################
IDEA:
Figure out a place to start and validate, if at the end of the "circuit"
the amount of cost is greater than the gas, we know it cant compelte the circuit
if the gas is greater, it can complete the circuit.
Now must find a place to start, so either start from beginning or end and check
indice
amount += gas[i] - cost[i]
* */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost){

        int amount = gas[gas.length-1] - cost[cost.length-1];
        int endIndex = gas.length-1;
        int startIndex = 0;
        while(startIndex < endIndex) {
            if (amount >= 0) {
                amount = amount + gas[startIndex] - cost[startIndex];
                startIndex++;
            }
            else {
                endIndex--;
                amount = amount + gas[endIndex] - cost[endIndex];

            }
        }
        return (amount >= 0)? startIndex: -1;

    }

    public static void main(String[] args) {
        //write your test cases here
    }
}
