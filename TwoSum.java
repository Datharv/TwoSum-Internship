import java.util.*;

class TwoSum{

    private static int[] findIndicesNaive(int [] arr, int target) {

        int [] res = new int[2];
        Arrays.fill(res, -1);
        int n = arr.length;

        // Naive Brute Force Solution
        // Time Complexity - O(n2);

        // Approach :
        // To find the indices of two elements that sum up to target We can use 2 loops which represent two indices and check for each pair of indices

        for(int i = 0;i<n;i++) {
            // OUTER LOOP -
            // (i) starts from 0th index and points to the first element.
            // We iterate for every element to ge the solution

            for(int j = i+1;j<n;j++) {

                // INNER LOOP
                // (j) starts from the (i+1) and try to search the second element which satisfies the condition
                // we iterate for every element till end
                
                // checking the condition 
                if(arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;

                    // As the problem says there would be exactly one solution so after condition becomes true
                    // we can return res to save the further iteration
                    return res;
                 }

            }

        }
        // And if the problem has no solution then it will return [-1, -1] which indicates solution not exists.

        return res;
    }

    private static int[] findIndicesOptimized(int [] arr, int target) {

        int [] res = new int[2];
        Arrays.fill(res, -1);
        int n = arr.length;

        // Optimized Solution
        // Time Complexity - O(n);

        // Approach :
        // In optimized approach, We can use java framework (HASHMAP) to store the first element and to check the presence of second part of element in array.
        // Ex. Input: nums = [2,7,11,15], target = 9
        // suppose you have store 2 in map and now you check (target - arr[i]) exists in map or not
        // if yes - you got the solution print it
        // if no - you add the current element to map and move forward and everytime check if (target - current) element exists in map. 
        // As accessing element in map is O(1) time and we iterate for every element in array until we found the solution hence TC :  1 * n = O(n). and SC : O(n)
        // target = firstEle + secondEle
        // secondEle = target - firstEle

        Map<Integer, Integer> map = new HashMap<>();
        // In map we will be storing ("key":"value") pair
        // In our case key : element of array, value : index of element

        
        for (int i = 0; i < n; i++) {

            // for every element check if other part of target exists in map or not
            // for every element arr[i] check for (target-arr[i]) 
            if (map.containsKey(target - arr[i])) {
                res[1] = i;
                // we store arr[i] as second index because we are assuming that first part of target will be present in map
                res[0] = map.get(target - arr[i]);
                return res;
            }

            // if not we add the element to the map
            map.put(arr[i], i);
        }
        
        
        return res;
    }

    public static void main(String[] args) {
        
        // Using Scanner to take input from user
        Scanner read = new Scanner(System.in);

        int n = read.nextInt();
        int [] arr = new int[n];

        for(int i = 0;i<n;i++) {
            arr[i] = read.nextInt();
        }
        
        int target = read.nextInt();

        read.close();

        int [] ans = new int[2];
        ans = findIndicesOptimized(arr, target);
        
        System.out.println(Arrays.toString(ans));

    }
}

