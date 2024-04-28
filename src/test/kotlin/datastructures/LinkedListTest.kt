package datastructures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue


internal class LinkedListTest {
	@Nested
	inner class Append {
		@Test
		fun `Appends a node to the end of the Linked List`() {
			// Initialize the Linked List with 1 node
			val list = LinkedList(1)
			// Assert the initial state has length of 1 and the tail's value is 1
			Assertions.assertAll(
				Executable { assertEquals(list.getTail(), 1) { "Tail was not set correctly" } },
				Executable { assertEquals(list.getLength(), 1) }
			)
			// Append 2 to the LinkedList
			list.append(2)
			// Assert the new state of the tail is 2 and the length grew by 1
			Assertions.assertAll(
				Executable { assertEquals(list.getTail(), 2) },
				Executable { assertEquals(list.getLength(), 2) }
			)
		}
	}

	@Nested
	inner class Prepend {
		@Test
		fun `Prepends a Node to the LinkedList`() {
			// Initialize the Linked List with 1 node with a value of 2
			val list = LinkedList(2)
			// Assert the Initial state has a length of 1 and head's value is 2
			Assertions.assertAll(
				Executable { assertEquals(list.getHead(), 2) },
				Executable { assertEquals(list.getLength(), 1) }
			)

			list.prepend(1)

			Assertions.assertAll(
				Executable { assertEquals(list.getHead(), 1) },
				Executable { assertEquals(list.getLength(), 2) }
			)
		}
	}

	@Nested
	inner class RemoveFirst {
		@Test
		fun `Removes the first node and returns the removed value`() {
			val list = LinkedList(1)
			list.append(2)

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 2) },
				Executable { assertEquals(list.getHead(), 1) }
			)

			val response = list.removeFirst()

			Assertions.assertAll(
				Executable { assertEquals(response?.value, 1) },
				Executable { assertEquals(list.getLength(), 1) },
				Executable { assertEquals(list.getHead(), 2) },
				Executable { assertEquals(list.getLength(), 1) }
			)
		}

		@Test
		fun `Removes the only node if the LinkedList has a length of 1`() {
			val list = LinkedList(1)
			val response = list.removeFirst()
			Assertions.assertAll(
				Executable { assertEquals(response?.value, 1) },
				Executable { assertEquals(list.getLength(), 0) },
				Executable { assertEquals(list.getHead(), null) },
				Executable { assertEquals(list.getTail(), null) }
			)
		}

		@Test
		fun `Returns null when called on an empty LinkedList`() {
			val list = LinkedList(1)
			list.removeFirst()
			val empty = list.removeFirst()

			assertNull(empty?.value)
		}
	}

	@Nested
	inner class RemoveLast {
		@Test
		fun `Removes the last node of a LinkedList and returns the removed node`() {
			val list = LinkedList(1)
			list.append(2)

			val response = list.removeLast()

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 1) },
				Executable { assertEquals(list.getTail(), 1) },
				Executable { assertEquals(response?.value, 2) }
			)
		}

		@Test
		fun `Removes the only node if the LinkedList has a length of 1`() {
			val list = LinkedList(1)

			val response = list.removeLast()

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 0) },
				Executable { assertEquals(response?.value, 1) },
				Executable { assertEquals(list.getHead(), null) },
				Executable { assertEquals(list.getTail(), null) }
			)
		}

		@Test
		fun `Returns null when called on an empty LinkedList`() {
			val list = LinkedList(1)
			list.removeLast()
			val empty = list.removeLast()

			assertNull(empty?.value)
		}
	}

	@Nested
	inner class Get {
		@Test
		fun `Gets the node by the input index and does not mutate the LinkedList`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val node = list.get(1)

			Assertions.assertAll(
				Executable { assertEquals(node?.value, 2) },
				Executable { assertEquals(list.getLength(), 3) }
			)
		}

		@Test
		fun `Returns null for an index out of bounds`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val negativeNode = list.get(-1)
			val pastLengthNode = list.get(8)

			Assertions.assertAll(
				Executable { assertNull(negativeNode) },
				Executable { assertNull(pastLengthNode) }
			)
		}
	}

	@Nested
	inner class Set {
		@Test
		fun `Sets the value of a node at the provided index and returns true`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val inserted = list.set(1, 4)

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 3) },
				Executable { assertTrue { inserted } },
				Executable { assertEquals(list.get(1)?.value, 4) },
				Executable { assertEquals(list.get(1)?.value, 4) },
			)
		}

		@Test
		fun `Does not set the value at an index out of bounds and returns false`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val negativeInserted = list.set(-1, 4)
			val pastLength = list.set(8, 4)

			Assertions.assertAll(
				Executable { assertFalse { negativeInserted } },
				Executable { assertFalse { pastLength } }
			)
		}
	}

	@Nested
	inner class Insert {
		@Test
		fun `Inserts a node with the given value at the given index and returns true`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val inserted = list.insert(1, 4)

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 4) },
				Executable { assertTrue { inserted } },
				Executable { assertEquals(list.get(1)?.value, 4) },
				Executable { assertEquals(list.get(2)?.value, 2) },
			)
		}

		@Test
		fun `Does not insert a node at the given out of bounds index`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val negative = list.insert(-1, 4)
			val pastLength = list.insert(8, 4)

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 3) },
				Executable { assertFalse { negative } },
				Executable { assertFalse { pastLength } },
			)
		}
	}

	@Nested
	inner class Remove {
		@Test
		fun `Removes a node at the given index and returns the node`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val removed = list.remove(1)

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 2) },
				Executable { assertEquals(removed?.value, 2) },
				Executable { assertEquals(list.get(1)?.value, 3) }
			)
		}

		@Test
		fun `Does not remove the node at an index out of bounds`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val negative = list.remove(-1)
			val pastLength = list.remove(8)

			Assertions.assertAll(
				Executable { assertNull(negative) },
				Executable { assertNull(pastLength) }
			)
		}
	}

	@Nested
	inner class Reverse {
		@Test
		fun `Reverses a LinkedList`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			list.reverse()

			Assertions.assertAll(
				Executable { assertEquals(list.getLength(), 3) },
				Executable { assertEquals(list.get(0)?.value, 3) },
				Executable { assertEquals(list.get(1)?.value, 2) },
				Executable { assertEquals(list.get(2)?.value, 1) }
			)
		}
	}

	@Nested
	inner class FindMiddle {
		@Test
		fun `Finds the middle node of a LinkedList and returns the node`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val middle = list.findMiddle()

			assertEquals(middle?.value, 2)
		}

		@Test
		fun `Returns the second of the two middle nodes if the LinkedList is an even number in length`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
				append(4)
			}

			val middle = list.findMiddle()

			assertEquals(middle?.value, 3)
		}
	}

	@Nested
	inner class HasLoop {
		@Test
		fun `Detects whether there is a loop in the LinkedList of values`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
			}

			val hasLoop = list.hasLoop()

			assertFalse { hasLoop }
		}
	}

	@Nested
	inner class FindKthFromEnd {
		@Test
		fun `Finds the 2nd Node from the end`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
				append(4)
			}

			val response = list.findKthFromEnd(2)

			assertEquals(response?.value, 3)
		}

		@Test
		fun `Returns null if index is out of bounds`() {
			val list = LinkedList(1).apply {
				append(2)
				append(3)
				append(4)
			}

			val response = list.findKthFromEnd(9)

			assertNull(response)
		}
	}

	@Nested
	inner class PartitionList {
		@Test
		fun `Partitions the list`() {
			val list = LinkedList(1).apply {
				append(4)
				append(3)
				append(2)
				append(5)
				append(2)
			}

			list.partitionList(3)

			assertEquals(true, false)
		}
	}
}