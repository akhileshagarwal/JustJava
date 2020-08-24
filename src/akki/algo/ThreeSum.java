package akki.algo;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listArrayList = new ArrayList<>();
        if(nums.length<3){
            return listArrayList;
        }else {
            long count= IntStream.of(nums).filter(value -> value == 0).count();
            if(count==nums.length){

                listArrayList.add(new ArrayList(Arrays.asList(0,0,0)));
                return listArrayList;
            }
        }

        IntStream.of(nums).boxed().forEach(System.out::println);
        Arrays.sort(nums);

        int zeroIndex = 0;
        for (int i = 0 ; i< nums.length;i++){
            if(nums[i]>-1){
                zeroIndex = i;
                break;
            }
        }



      //  int zeroIndex = Arrays.binarySearch(nums, 0);
        int numsLength = nums.length;
        if (zeroIndex >0) {
           // if (numsLength - zeroIndex < numsLength / 2) {
                for (int i = zeroIndex + 1; i < numsLength; i++) {
                    int positiveNum = nums[i];
                    int negativeNumIndex = Arrays.binarySearch(nums, 0, zeroIndex , -1*positiveNum);
                    if (negativeNumIndex >-1) {
                        listArrayList.add(new ArrayList<>(Arrays.asList(nums[negativeNumIndex], 0, positiveNum)));
                    }
                }
           // }


        //find for negative numbers equivalent positive numbers
        for (int i = 0; i < zeroIndex; i++) {
            int positiveNumArray[] = Arrays.copyOfRange(nums,zeroIndex+1, numsLength  );
            listArrayList.addAll(twoSum(positiveNumArray, nums[i]));
        }

        //find for positive numbers equivalent negative numbers
        for (int i = zeroIndex+1; i < numsLength; i++) {
            int negativeNumArray[]  = Arrays.copyOfRange(nums,0, zeroIndex );
            listArrayList.addAll(twoSum(negativeNumArray, nums[i]));
        }
        }

        return listArrayList;


    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> listArrayList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement;
            if(nums[i] <0){
                complement = target + nums[i];
                if (map.containsKey(-1*complement)) {
                    listArrayList.add(new ArrayList<>(Arrays.asList(-1*complement, nums[i], target)));
                }
            }else {
                complement = Math.abs(target) - Math.abs(nums[i]);
                if (map.containsKey(complement)) {
                    listArrayList.add(new ArrayList<>(Arrays.asList(complement, nums[i], target)));
                }
            }


            map.put(nums[i], i);
        }
        return listArrayList;
    }

}
