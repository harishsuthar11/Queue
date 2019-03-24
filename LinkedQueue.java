class LinkedQueue <Item> implements Queue <Item>
{
  private Node front, rear;
  private int size; 
 
   private class Node
  { 
    Item item;
    Node next;
  }

  public LinkedQueue()
  {
    front = null;
	rear = null;
    size = 0;
  }
 
  public boolean isEmpty()
  {
    return (size == 0);
  }

  public Item delete()
  {
    Item item = front.item;
    front = front.next;
    if (isEmpty()) 
    {
      rear = null;
    }
    size--;
    return item;
  }

  public void insert(Item item)
  {
    Node oldRear = rear;
    rear = new Node();
    rear.item = item;
    rear.next = null;
    if (isEmpty()) 
    {
      front = rear;
    }
    else 
    {
      oldRear.next = rear;
    }
    size++;
  }
 
  public int size()
  {
    return size;
  }
}
