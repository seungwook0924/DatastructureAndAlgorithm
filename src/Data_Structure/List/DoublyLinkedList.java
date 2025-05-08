package Data_Structure.List;

public class DoublyLinkedList<E>
{
    class Node<E>
    {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    //리스트를 앞쪽부터 출력
    public void printList()
    {
        Node<E> currentNode = head;
        while(currentNode != null)
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    //리스트를 뒷쪽부터 출력
    public void printList(boolean back)
    {
        if(back == false) printList();
        else
        {
            Node<E> currentNode = tail;
            while(currentNode != null)
            {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.prev;
            }
            System.out.println();
        }
    }

    //리스트 앞쪽에 추가
    public void add(E data)
    {
        Node<E> newNode = new Node(data);
        Node<E> currentNode = head;
        if(currentNode == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    //리스트 뒷쪽에 추가
    public void add(E data, boolean back)
    {
        if(back == false) add(data);
        else
        {
            Node<E> newNode = new Node(data);
            Node<E> currentNode = tail;
            if(currentNode == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                head.prev = newNode;
                newNode.prev = null;
                head = newNode;
            }
        }
    }

    //원하는 인덱스에 노드 삽입
    public void insert(E data, int idx)
    {
        Node<E> newNode = new Node(data);
        if(head == null) add(data);
        if (head == null || idx == 0)
        {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = newNode;
        }
        else
        {
            Node<E> currentNode = head;
            for(int i = 0; i < idx - 1; ++i)
            {
                if(currentNode == null)
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
            if (currentNode.next != null) currentNode.next.prev = newNode;
            newNode.prev = currentNode;
            currentNode.next = newNode;
            if(newNode.next == null) tail = newNode;
        }
    }

    //노드를 앞 또는 뒷부분 삭제
    public void delete(boolean back)
    {
        if (head == null) System.out.println("Empty");
        else if(back == false) //앞부분 삭제
        {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // 리스트에 하나의 노드만 있었고 삭제한 경우
        }
        else //뒷부분 삭제
        {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null; // 리스트에 하나의 노드만 있었고 삭제한 경우
        }
    }

    //특정 데이터의 내용을 포함하는 노드 삭제
    public void delete(E data)
    {
        if (head == null) System.out.println("Empty");
        else
        {
            Node<E> currentNode = head;
            while(currentNode.next != null && !currentNode.next.data.equals(data))
            {
                currentNode = currentNode.next;
            }
            if(currentNode.next != null)
            {
                currentNode.next = currentNode.next.next;
                currentNode.next.next.prev = currentNode;
            }
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
        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.insert(0,0);
        dll.insert(0,2);
        dll.insert(0,4);
        dll.insert(0,6);
        dll.printList();
        dll.delete(false);
        dll.printList();
        dll.delete(true);
        dll.printList();
        dll.search(9);
    }
}
