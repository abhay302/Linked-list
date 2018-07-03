/**
 * The DoublyLinkedList class has 3 fields:
 * prev : used to store the reference of the previous node
 * data : used to store the data of Any kind
 * next : used to store the reference of the next node
 */
class DoublyLinkedList (var prev: DoublyLinkedList?, val data: Any, var next: DoublyLinkedList?)  {

    companion object {

        /**
         * It is the head of the doubly linked list
         */
        var list: DoublyLinkedList? = null

        /**
         * Stores the number of nodes in the doubly linked list
         */
        private var countNode = 0

        /**
         * The function accepts the object as the argument and adds a node to the doubly linked list
         */
        fun addNode(data: Any) {
            if(list==null) {
                list = DoublyLinkedList(null, data, null)
            }
            else {
                var temp = list
                while (temp?.next != null)
                    temp = temp.next

                temp?.next = DoublyLinkedList(temp, data, null)
            }
            countNode++
        }


        /**
         * The traverse() function traverses through the entire linked list and prints each element
         */
        fun traverse() {
            var temp = list
            while (temp!=null) {
                println(temp.data)
                temp = temp.next
            }
        }


        /**
         * The removeNode() funtion removes the node at a given index.
         * Returns true if the element is successfully removed otherwise, returns false
         */
        fun removeNode(index : Int) : Boolean {

            if(index> countNode|| index<0 || countNode<0)
                return false
            else {
                when (index) {

                    0 -> {              // whether the element to be removed is the first element in the list
                        list?.next?.prev = null
                        list = list?.next
                    }
                    countNode-1 -> {    // whether the element to be removed is the last element in the list
                        var temp = list
                        while (temp?.next?.next!=null)
                            temp = temp?.next
                        temp?.next = null
                    }
                    else -> {           // removes element if present in the middle of the list
                        var temp = list
                        for (i in 0..index-2) {
                            temp = temp?.next
                        }
                        temp?.next?.next?.prev = temp
                        temp?.next = temp?.next?.next
                    }
                }
                countNode--
                return true
            }
        }
    }

}


fun main(args: Array<String>) {
    DoublyLinkedList.addNode("abhay")
    DoublyLinkedList.addNode(12345)
    DoublyLinkedList.addNode(5.6)

    DoublyLinkedList.traverse()
    DoublyLinkedList.removeNode(2)
    DoublyLinkedList.traverse()
}
