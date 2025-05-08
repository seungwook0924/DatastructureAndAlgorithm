package Data_Structure.List;

public class SinglyLinkedList<E>
{
    class Node<E>
    {
        E data;
        Node<E> next;

        Node(E data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;

    SinglyLinkedList() { this.head = null; }

    public void printList()
    {
        Node<E> currentNode = head;
        if (currentNode == null)
        {
            System.out.println("Empty");
            return;
        }
        while (currentNode != null)
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    //리스트의 가장 뒷쪽에 데이터 추가
    public void add(E data)
    {
        Node<E> newNode = new Node<>(data);
        if (head == null) head = newNode;
        else
        {
            Node<E> currentHead = head;
            while (currentHead.next != null) currentHead = currentHead.next;
            currentHead.next = newNode;
        }
    }

    //리스트의 원하는 인덱스에 데이터 삽입
    public void insert(E data, int idx)
    {
        if (head == null)
        {
            add(data);
            return;
        }
        Node<E> newNode = new Node<>(data);
        Node<E> currentNode = head;
        if (currentNode != null && idx == 0)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        for (int i = 0; i < idx - 1; ++i)
        {
            if (currentNode == null)
            {
                System.out.println("Error");
                return;
            }
            currentNode = currentNode.next;
        }
        if (currentNode == null)
        {
            System.out.println("Invalid index");
            return;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    //앞쪽의 데이터 삭제
    public void delete()
    {
        if (head == null) System.out.println("Empty");
        else head = head.next;
    }

    //특정 데이터의 내용을 포함하는 노드 삭제
    public void delete(E data)
    {
        if (head == null) System.out.println("Empty");
        else if (head.data.equals(data)) head = head.next;
        else
        {
            Node<E> currentHead = head;
            while (currentHead.next != null && !currentHead.next.data.equals(data))
            {
                currentHead = currentHead.next;
            }
            if (currentHead.next != null) currentHead.next = currentHead.next.next;
            else currentHead.next = null;
        }
    }

    //해당 데이터가 존재하는지 아닌지 확인
    public void search(E data)
    {
        if (head == null)
        {
            System.out.println("Invalid");
            return;
        }
        else
        {
            Node<E> currentHead = head;
            while (currentHead != null && !currentHead.data.equals(data))
            {
                currentHead = currentHead.next;
            }
            if (currentHead == null)  System.out.println("Invalid");
            else System.out.println("Valid");
        }
    }

    public static void main(String args[])
    {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.insert(0, 0);
        sll.insert(0, 2);
        sll.insert(0, 4);
        sll.delete();
        sll.delete(1);
        sll.delete(0);
        sll.printList();
    }
}
