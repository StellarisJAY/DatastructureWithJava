
/**
 * 链表类
 * @param <T>
 */
public class LinkedList<T> {
    private int length;        // 记录链表长度
    private LinkedNode<T> head; // 链表的头结点, 头结点不存数据

    public LinkedList(){
        this.head = new LinkedNode<>();
        this.length = 0;
    }

    /**
     * 链表尾部插入
     * @param data
     */
    public void append(T data){
        LinkedNode<T> node = head;
        while(node.getNext() != null){
            node = node.getNext();
        }
        // 遍历完成后，当前node为最后一个结点
        // 设置最后一个结点的next为新的结点，完成尾插
        node.setNext(new LinkedNode(data));
        this.length++;
    }

    /**
     * 链表头部插入
     * @param data
     */
    public void headInsertion(T data){
        LinkedNode<T> newHead = new LinkedNode<>(data);
        newHead.setNext(this.head.getNext());
        this.head.setNext(newHead);
    }

    /**
     * 插入到第pos个结点位置，规定头结点为0位置
     * @param pos
     * @param data
     * @return
     */
    public int insert(int pos, T data){
        if(pos <= 0 || pos > length + 1) return 0;
        LinkedNode<T> node = this.head;
        int i = 0;
        while(node != null && i < pos-1){
            node = node.getNext();
            i++;
        }
        LinkedNode<T> newNode = new LinkedNode<>(data);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        return 1;
    }

    /**
     * 删除第一个结点
     */
    public void deleteHead(){
        if(head.getNext() != null){
            head.setNext(head.getNext().getNext());
            length--;
        }
    }

    /**
     * 删除尾节点
     */
    public void deleteEnd(){
        LinkedNode<T> node = this.head;
        while(node.getNext().getNext() != null){
            node = node.getNext();
        }
        node.setNext(null);
        length--;
    }

    /**
     * 删除第pos位置结点
     * @param pos
     * @return
     */
    public int delete(int pos){
        if(pos <= 0 || pos > length)return 0;
        int i = 0;
        LinkedNode<T> node = head;
        while(node.getNext() != null && i < pos-1){
            node = node.getNext();
            i++;
        }
        node.setNext(node.getNext().getNext());
        length--;
        return 1;
    }

    /**
     * 获取第pos个元素
     * @param pos
     * @return
     */
    public T get(int pos){
        if(pos<=0 || pos > length) return null;
        int i = 0;
        LinkedNode<T> node = head;
        while(node != null && i < pos){
            node = node.getNext();
            i++;
        }
        return node==null ? null:node.getData();
    }

    /**
     * 获取data在链表中的位置
     * @param data
     * @return
     */
    public int indexOf(T data){
        int i = 0;
        LinkedNode<T> node = head;
        while(node != null){
            if(node.getData() == data) return i;
            node = node.getNext();
            i++;
        }
        return -1;
    }

    /**
     * 更新pos位置的数据
     * @param pos
     * @param data
     * @return
     */
    public int update(int pos, T data){
        if(pos <= 0 || pos > length) return 0;

        LinkedNode<T> node = head;
        int i = 0;
        while(node != null && i < pos){
            node = node.getNext();
            i++;
        }
        node.setData(data);
        return 1;
    }

    public int getLength() { return length;
    }
    public LinkedNode<T> getHead() {
        return head;
    }
    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedNode<T> node = head.getNext();
        while(node != null){
            sb.append(node.getData() + ",");
            node = node.getNext();
        }
        return sb.toString();
    }
}


/**
 * 链表结点类
 * @param <T>
 */
class LinkedNode<T>{
    private T data;       // 结点数据
    private LinkedNode next;  // 指向下一个结点

    public LinkedNode() {

    }

    /**
     * 创建新的结点，自动赋值next为null
     * @param data
     */
    public LinkedNode(T data){
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public LinkedNode getNext() {
        return next;
    }
    public void setNext(LinkedNode next) {
        this.next = next;
    }

}
