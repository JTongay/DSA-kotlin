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
		for (i in 0 until index) {
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
		for (i in 0 until length) {
			after = temp?.next
			temp?.next = before
			before = temp
			temp = after
		}
	}

	fun getHead() {
		println("Head: ${head?.value}")
	}

	fun getTail() {
		println("Tail: ${tail?.value}")
	}

	fun getLength() {
		println("Length: $length")
	}

	private fun isEmpty() = length == 0

	inner class Node(var value: Int, var next: Node? = null)
}
