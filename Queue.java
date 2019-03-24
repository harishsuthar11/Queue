public interface Queue <Item>
{
  Item delete(); 
 void insert(Item item); 
  boolean isEmpty(); 
  int size(); 
}
