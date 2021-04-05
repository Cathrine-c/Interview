package java_1020.java;


import java.util.*;

public class MapInterview {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    //复制带随机指针的链表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        //遍历链表
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        //再遍历一遍链表得到新链表
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);//通过旧链表.next得到新链表.next
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }

    //石头中有多少颗宝石
    public int numJewelsInstones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int ret = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }


    public int numJewelsInstones1(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }


    public int numJewelsInstones2(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }

    static class myComparator implements Comparator<String> {
        private Map<String, Integer> map;

        public myComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;//降序排序
        }
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            int count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.sort(arrayList, new myComparator(map));
        return arrayList.subList(0, k);
    }


    public List<String> topKFrequent1(String[] words, int k) {
        //用map来实现，K：字符，V：它出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            int count = map.getOrDefault(s, 0);//遍历字符串，看字符是否出现过，没有个数就为0
            map.put(s, count + 1);
        }
        ArrayList<String> arrayList = new ArrayList<>();//用顺序表来存储高频词，比较高频词出现的次数，按高到低排序
       /* Collections.sort(arrayList,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int count1=map.get(o1);
                int count2=map.get(o2);
                if (count1 == count2) {
                    return o1.compareTo(o2);
                }
                return count2-count1;

            }
        }
        );*/

        //匿名内部类，不需要知道它的名字，只需要使用它的方法，使用完了就销毁
        Collections.sort(arrayList, (o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        });
        return arrayList.subList(0, k);
    }


//    public Node copyRandomList2(Node head){
//        Node current = head;
//        while (current!=null){
//            Node newNode= new Node(current.val);
//            Node newLast=head;
//            newNode.next
//        }
//

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                int index = map.get(x);
                return new int[]{index, i};
            }
            map.put(target - x, i);
        }
        return null;
    }

    public int numJewelsInStone(String S,String J){
        Set<Character> set = new HashSet<>();
        for (char c:J.toCharArray()){
            set.add(c);
        }
        int count=0;
        for (char s:S.toCharArray()){
            if (set.contains(s)){
                count++;
            }
        }
        return count;
    }


    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int x:nums){
            //遍历数组，数字出现次数命名为value，判断这个value是否为0
            int value=map.get(x);
            //如果这个值为空，说明是第一次出现
            if (value ==0) {
                //如果不存在，就返回默认值0
                map.getOrDefault(x,0);
            }
            //否则，就为1，表示已经存在
            map.put(x,value+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return -1;
    }


}




