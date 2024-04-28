package leetcodes

import kotlin.math.floor

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 *
 * Ex: [1, 1, 2]
 * Returns 2
 * Output [1, 2, _]
 */
fun removeDupesSortedArray(nums: IntArray): Int {
	nums.distinct().let {
		it.forEachIndexed {index, value ->
			nums[index] = value
		}
		return it.size
	}
}

/**
 * Given an integer array nums and an integer val, remove all occurrences of
 * val in nums in-place. The order of the elements may be changed.
 * Then return the number of elements in nums which are not equal to val.
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
	var total = 0
	nums.forEach {
		if (it != `val`) {
			nums[total] = it
			total++
		}
	}
	return total
}

/**
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
fun findIndexFirstOccurrence(haystack: String, needle: String): Int {
	var index = 0
	val loops = haystack.length - needle.length

	while (index <= loops) {
		if (haystack.subSequence(index, index + needle.length) == needle) {
			return index
		}
		index++
	}
	return -1
}

/**
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
fun searchInsert(nums: IntArray, target: Int): Int {
	if (target > nums[nums.size - 1]) {
		return nums.size
	}

	var output = nums.size
	for (i in nums.indices) {
		if (nums[i] >= target) {
			output = i
			break
		}
	}
	return output
}
