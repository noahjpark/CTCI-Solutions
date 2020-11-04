/* Noah Park

The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int numBoats = 0;
        
        while(left <= right){
            if(people[left] + people[right] <= limit) left++;
            numBoats++;
            right--;
        }
        
        return numBoats;
    }
}
