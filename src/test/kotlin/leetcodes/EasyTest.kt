package leetcodes

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class EasyLeetCodeTests {
	@Nested
	inner class RemoveDupesSortedArray {
		@Test
		fun`Returns the number of unique items in an array`() {
			val input = intArrayOf(0,0,1,1,1,2,2,3,3,4)
			val response = removeDupesSortedArray(input)

			assertEquals(response, 5)
		}
	}

	@Nested
	inner class RemoveElement {
		@Test
		fun`Returns the size of the leftover array after removing instances of the input val`() {
			val input = intArrayOf(0,1,2,2,3,0,4,2)
			val response = removeElement(input, 2)

			assertEquals(response, 5)
		}
	}

	@Nested
	inner class NeedleInHaystack {
		@Test
		fun`Returns the index of the first occurrence`() {
			val haystack = "sadbutsad"
			val needle = "sad"
			val response = findIndexFirstOccurrence(
				haystack = haystack,
				needle = needle
			)

			assertEquals(response, 0)
		}

		@Test
		fun`Returns -1 if the needle is not in the haystack`() {
			val haystack = "leetcode"
			val needle = "leeto"
			val response = findIndexFirstOccurrence(
				haystack = haystack,
				needle = needle
			)

			assertEquals(response, -1)
		}
	}

	@Nested
	inner class SearchInsert {
		@Test
		fun`Returns the index of the input value on a sorted list where the value is present`() {
			val input = intArrayOf(1,3,5,6)
			val target = 5
			val response = searchInsert(input, target)

			assertEquals(response, 2)
		}

		@Test
		fun`Returns the index of the input value on a sorted list where the value would be if present inside of the existing array`() {
			val input = intArrayOf(1,3,5,6)
			val target = 2
			val response = searchInsert(input, target)

			assertEquals(response, 1)
		}

		@Test
		fun`Returns the index of the input value on a sorted list where the value would be if present outside of the existing array`() {
			val input = intArrayOf(1,3,5,6)
			val target = 7
			val response = searchInsert(input, target)

			assertEquals(response, 4)
		}
	}
}