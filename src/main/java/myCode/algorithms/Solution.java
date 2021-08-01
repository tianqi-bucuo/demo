package myCode.algorithms;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        String num = "11235813213455890144";
//        System.out.println(isAdditiveNumber(num));
        System.out.println(Long.MAX_VALUE);
    }

    public static boolean isAdditiveNumber(String num) {
        List<Long> nums = new ArrayList<>();
        return helper(num, 0, nums);
    }

    private static boolean helper(String num, int start, List<Long> nums) {
        if (start == num.length()) {
            return nums.size() > 2;
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0')   return false;
            long cur = Long.parseLong(num.substring(start, i + 1));
            if (nums.size() >= 2) {
                if (cur > nums.get(nums.size() - 1) + nums.get(nums.size() - 2)) {
                    return false;
                }else if (cur < nums.get(nums.size() - 1) + nums.get(nums.size() - 2)) {
                    continue;
                }
            }
            nums.add(cur);
            if (helper(num, i + 1, nums)) {
                return true;
            }
            nums.remove(nums.size() - 1);
        }
        return false;
    }
}