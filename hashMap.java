package java_1026.java;
/*
hash表：开散列的方式解决hash冲突
 */
class Node{
    public int key;
    public int value;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;

    }
}
public class hashMap {
    //array就是hash表的本体，数组的每个元素又是一个链表的头结点
    private Node[] array=new Node[101];
    //表示当前hash表中的元素个数
    private int size=0;

    private int hashFun(int key){
        return key%array.length;
    }
    //如果key已经存在，就修改当前value的值
    //如果key不存在，就插入新的键值对
    public void put(int key,int value) {
        //把key映射成数组下标
        int index=hashFun(key);
        //根据下标找到对应的链表
        Node list=array[index];
        for (Node cur=list;cur!=null;cur=cur.next){
            if (cur.key==key){
                cur.value=value;
            }
        }
        //新节点头插到指定链表的头部
        Node newNode=new Node(key, value);
        newNode.next=list;
        array[index]=newNode;
        size++;
    }
}
