/**
 * The DoublyLinkedList class has 3 fields:
 * prev : used to store the reference of the previous node
 * data : used to store the data of Any kind
 * next : used to store the reference of the next node
 */
class DoublyLinkedList {

    data class Node(var prev: Node? = null, val data: Any, var next: Node? = null)

    companion object {

        /**
         * It is the head of the doubly linked list
         */
        var head: Node? = null

        /**
         * Inserts the given node at the beginning of the doubly linked list
         */
        fun insertFirst(node: Node) {
            node.prev = null
            node.next = head
            head = node
        }

        /**
         * Inserts the given node at the end of the doubly linked list
         */
        fun insertLast(node: Node) {
            if(head == null) {
                head = node
            }
            else {
                var temp = head
                while (temp?.next != null) {
                    temp = temp.next
                }
                node.prev = temp
                temp?.next = node
            }
        }

        /**
         * Inserts the given node before a specified node in the doubly linked list
         */
        fun insertBefore(node: Node, next_node: Node) {
            node.prev = next_node.prev
            node.next = next_node

            next_node.prev = node
            if(node.prev != null) {
                node.prev?.next = node
            }
        }

        /**
         * Inserts the given node after a specified node in the doubly linked list
         */
        fun insertAfter(node: Node, prev_node: Node) {
            node.next = prev_node.next
            node.prev = prev_node

            prev_node.next = node
            if(node.next != null) {
                node.next?.prev = node
            }
        }

        /**
         * Deletes a particular node from the doubly linked list
         * Throws exception if the node to be deleted is not present in the doubly linked list
         */
        fun deleteNode(node: Node) {
            var temp = head

            while (temp != null && temp != node) {
                temp = temp.next
            }

            if(temp == null) {
                throw IllegalArgumentException("Node is not present in the doubly linked list")
            }
            else {
                if(temp.prev == null) {     // whether the element to be deleted is the first element in the linked list
                    temp.next?.prev = null
                    head = temp.next
                }
                else {
                    temp.prev?.next = temp.next
                    if(temp.next != null) { // whether the element to be deleted is the last element in the linked list
                        temp.next?.prev = temp.prev
                    }
                }
            }
        }

        /**
         * Reverses the doubly linked list
         */
        fun reverse() {
            var temp = head
            if(head == null) {
                return
            }
            else {
                while (true) {
                    val t = temp?.prev
                    temp?.prev = temp?.next
                    temp?.next = t

                    if(temp?.prev == null) {
                        break
                    }
                    else {
                        temp = temp.prev
                    }
                }
                head = temp
            }
        }

        /**
         * Traverses along the linked list in forward direction and prints each element
         */
        fun traverseInOrder() {
            var temp = head
            while (temp != null) {
                println(temp.data)
                temp = temp.next
            }
        }

        /**
         * Traverses along the linked list in reverse direction and prints each element
         */
        fun traverseReverseOrder(temp: Node? = head) {
            if(temp != null) {
                traverseReverseOrder(temp.next)
                println(temp.data)
            }
        }
    }
}

fun main(args: Array<String>) {
    DoublyLinkedList.insertLast(DoublyLinkedList.Node(data = "abhay"))
    DoublyLinkedList.insertLast(DoublyLinkedList.Node(data = 12345))
    DoublyLinkedList.insertLast(DoublyLinkedList.Node(data = 'c'))
    DoublyLinkedList.insertLast(DoublyLinkedList.Node(data = 4.5))

    DoublyLinkedList.traverseInOrder()

    DoublyLinkedList.reverse()
    DoublyLinkedList.traverseInOrder()
    DoublyLinkedList.traverseReverseOrder()
}
