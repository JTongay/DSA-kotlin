package datastructures

fun main(args: Array<String>) {
    val linkedList = LinkedList(1)

    linkedList.append(2)
    linkedList.getHead()
    linkedList.getTail()
    linkedList.getLength()
    linkedList.printList()

    println(linkedList.removeLast()?.value)
    println(linkedList.removeLast()?.value)
    println(linkedList.removeLast()?.value)

    prependTest()
    removeFirstTest()
    getTest()
    setTest()
    insertTest()
    removeTest()
    reverseTest()
    findMiddleTest()
}

fun prependTest() {
    println("Prepend Test")
    val linkedList = LinkedList(2)

    linkedList.append(3)
    linkedList.prepend(1)
    linkedList.printList()
    linkedList.getHead()
    println("-------------------------")
}

fun removeFirstTest() {
    println("removeFirst test")
    val linkedList = LinkedList(2)
    linkedList.append(1)

    // 2 items - Returns 2 Node
    println(linkedList.removeFirst()?.value)
    // 1 item - Returns 1 Node
    println(linkedList.removeFirst()?.value)
    // 0 items - Returns null
    println(linkedList.removeFirst()?.value)
    println("-------------------------")
}

fun getTest() {
    println("get test")
    val linkedList = LinkedList(0)

    linkedList.append(1)
    linkedList.append(2)
    linkedList.append(3)

    println("Getting value: ${linkedList.get(2)?.value}\n")

    linkedList.printList()

    println("--------------------------")
}

fun setTest() {
    println("set test")
    val linkedList = LinkedList(11)
    linkedList.append(3)
    linkedList.append(23)
    linkedList.append(7)

    linkedList.set(1, 4)

    linkedList.printList()
    println("--------------------------")
}

fun insertTest() {
    println("insert test")
    val linkedList = LinkedList(0)
    linkedList.append(2)

    linkedList.insert(1, 1)
    linkedList.printList()
    println("--------------------------")
}

fun removeTest() {
    println("remove test")
    val linkedList = LinkedList(11)
    linkedList.append(3)
    linkedList.append(23)
    linkedList.append(7)

    linkedList.remove(2)

    linkedList.printList()
    println("--------------")
}

fun reverseTest() {
    println("reverse test")
    val linkedList = LinkedList(1)
    linkedList.append(2)
    linkedList.append(3)
    linkedList.append(4)

    linkedList.printList()

    linkedList.reverse()
    linkedList.printList()
    println("-----------------------------")
}

fun findMiddleTest() {
    println("findMiddle test")
    val linkedList = LinkedList(1)

    linkedList.append(2)
    linkedList.append(3)

    println(assert(linkedList.findMiddle() == linkedList.get(1)).let { true })
}