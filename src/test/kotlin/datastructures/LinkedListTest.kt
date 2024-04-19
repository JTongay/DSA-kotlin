package datastructures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable


internal class LinkedListTest {
	@Nested
	inner class AppendTest {
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
	inner class PrependTest {
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
}