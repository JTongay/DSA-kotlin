package datastructures

class LinkedList(value: Int) {
	private var head: Node?
	private var tail: Node?
	private var length: Int

	init {
		val newNode = Node(value)
		head = newNode
		tail = newNode
		length = 1
	}

	fun printList() {
		var temp: Node? = head
		while (temp != null) {
			println(temp.value)
			temp = temp.next
		}
	}

	fun append(value: Int) {
		val newNode = Node(value)
		if (isEmpty()) {
			head = newNode
			tail = newNode
		} else {
			tail?.next = newNode
			tail = newNode
		}
		length++
	}

	fun removeLast(): Node? {
		if (isEmpty()) {
			return null
		}
		var temp: Node? = head
		var preTemp = head
		while (temp?.next != null) {
			preTemp = temp
			temp = temp.next
		}
		tail = preTemp
		tail?.next = null
		length--
		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp
	}

	fun prepend(value: Int) {
		val newNode = Node(value)
		if (isEmpty()) {
			head = newNode
			tail = newNode
		} else {
			newNode.next = head
			head = newNode
		}
		length++
	}

	fun removeFirst(): Node? {
		if (isEmpty()) {
			return null
		}
		val temp = head
		head = head?.next
		temp?.next = null
		length--
		if (isEmpty()) {
			tail = null
		}
		return temp
	}

	fun get(index: Int): Node? {
		if (index < 0 || index >= length) {
			return null
		}
		var temp = head
		for (i in 0..<index) {
			temp = temp?.next
		}
		return temp
	}

	fun set(index: Int, value: Int): Boolean {
		val temp = get(index)
		if (temp != null) {
			temp.value = value
			return true
		}
		return false
	}

	fun insert(index: Int, value: Int): Boolean {
		if (index < 0 || index > length) {
			return false
		}
		if (index == 0) {
			prepend(value)
			return true
		}
		if (index == length) {
			append(value)
			return true
		}
		val newNode = Node(value)
		val temp = get(index - 1)
		newNode.next = temp?.next
		temp?.next = newNode
		length++
		return true
	}

	fun remove(index: Int): Node? {
		if (index < 0 || index >= length) {
			return null
		}
		if (index == 0) {
			return removeFirst()
		}
		if (index == length - 1) {
			return removeLast()
		}
		val prev = get(index - 1)
		val temp = prev?.next
		prev?.next = temp?.next
		temp?.next = null
		length--
		return temp
	}

	fun reverse() {
		var temp = head
		head = tail
		tail = temp
		var after: Node? = temp?.next
		var before: Node? = null
		for (i in 0..< length) {
			after = temp?.next
			temp?.next = before
			before = temp
			temp = after
		}
	}

	fun getHead(): Int? {
		println("Head: ${head?.value}")
		return head?.value
	}

	fun getTail(): Int? {
		println("Tail: ${tail?.value}")
		return tail?.value
	}

	fun getLength(): Int {
		println("Length: $length")
		return length
	}

	// Interview Questions!! Leetcode style :/
	// Should use the slow and fast pointer technique (Floyd's Tortoise and Hare Algorithm) to find the middle
	fun findMiddle(): Node? {
		var slow = head
		var fast = head

		do {
			slow = slow?.next
			fast = fast?.next?.next
		} while (fast?.next != null)

		return slow
	}

	// Detect if there is a cycle or loop present in the LinkedList
	// Should use Floyd's Tortoise and Hare Algo
	// Use two pointers, a slow and fast
	// Slow pointer moves one step at a time, while fast pointer moves 2 steps at a time
	// If there is a loop in the linkedList, the two pointers will eventually meet at some point
	// If there is no loop, the fast pointer will reach the end of the list
	fun hasLoop(): Boolean {
		var slow = head
		var fast = head
		do {
			slow = slow?.next
			fast = fast?.next?.next
			if (slow == fast) {
				return true
			}
		} while (fast?.next != null)
		return false
	}

	// Find Kth Node from end
//	fun findKthFromEnd(k: Int): Node? {
//
//	}

	private fun isEmpty() = length == 0

	inner class Node(var value: Int, var next: Node? = null)
}
