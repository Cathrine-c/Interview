package java_1101.java;


import java.util.*;


class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != 0 && in.length != 0) {
            TreeNode treeNode = new TreeNode(pre[0]);
            int i=0;
            while (pre[0]!=i){
                i++;
            }
            int[] inLeft=new int[i];
            int[] inRight = new int[in.length-i-1];
            for (int j = 0;j<inLeft.length;j++){
                inLeft[j]=in[j];
            }
            for (int j=0;j<inRight.length;j++){
                inRight[j] = in[j+inLeft.length+1];
            }

            int[] preLeft = new int[i];
            int[] preRight = new int[in.length-i-1];
            for (int j=0;j<preLeft.length;j++){
                preLeft[j] = pre[j+1];
            }
            for (int j=0;j<preRight.length;j++){
                preRight[j]=pre[j+preLeft.length+1];
            }
            treeNode.left= reConstructBinaryTree(preLeft,inLeft);
            treeNode.right = reConstructBinaryTree(preRight,inRight);
            return treeNode;
        }
        return null;
    }


    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    public int minNumberInRotateArray1(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i=0;i<array.length-1;i++){
            if (array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }


    public int minNumberInRotateArray2(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int left=0;
        int right = array.length-1;
        int mid = -1;
        while (array[left]<array[right]){
            if (right - left == 1) {
                break;
            }

            mid=left+(right-left)/2;
            if (array[mid]>=array[left]){
               left=mid;
            }
            if (array[mid]<=array[right]){
                right=mid;
            }
        }
        return array[mid];
    }


    //要求输入一个整数n，输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
    //n<=39
    public static int Fibonacci(int n) {
        if (n == 0 ) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        while (n <= 39) {
             return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
        return 0;
    }


    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
    // （先后次序不同算不同的结果）。
    public static int JumpFloor(int target) {
        if (target<1){
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int num1=1;
        int num2=2;
        int num=0;
        for (int i=3;i<target;i++){
            num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        return num;
    }


    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    // 求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        while (target>1){
            return 2*JumpFloorII(target-1);
        }
        return -1;
    }


//用2*1的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        while (target > 2) {
            return RectCover(target-1)+RectCover(target-2);
        }
        return 0;
    }


//输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n&1;
            n=n>>1;
        }
        return sum;
    }


//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
//保证base和exponent不同时为0
    public double Power(double base, int exponent) {
        if (base != 0||exponent !=0) {
            double ret = Math.pow(base,exponent);
            return ret;
        }
        return 0;
    }


    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    public static int[] reOrderArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while (left<right){
            if (left<right&&array[left] % 2 != 0) {
                left++;
            }
            if (left<right&&array[right] % 2 == 0) {
                right--;
            }
            int tmp = array[right];
            array[right] = array[left];
            array[left] = tmp;
        }

        return array;
    }

    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray2(int [] array) {
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-i-1;j++){
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }


     //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null||k<1) {
            return null;
        }
        ListNode p=head;
        ListNode q=head;

        while (k > 0) {
            if (p == null) {
                return null;
            }
            p=p.next;
            k--;
        }

        while (p != null) {
            p=p.next;
            q=q.next;
        }
        return q;
    }

    //输入一个链表，反转链表后，输出新链表的表头。
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev=null;
        while (head != null) {
            ListNode cur=head.next;
            head.next=prev;
            prev=head;
            head = cur;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next = null;

         public ListNode(int val) {
             this.val = val;
             this.next = next;
         }


    }
   //输入两个单调递增的链表，输出两个链表合成后的链表，合成后的链表满足单调不减规则。
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newHead.next = list1;
                newHead=list1;
                list1 = list1.next;
            } else {
               newHead.next = list2;
                newHead=list2;
                list2 = list2.next;
            }
        }
            if (list1 != null) {
                newHead.next=list1;
            }
            if (list2 != null) {
               newHead.next=list2;
            }

        return tmp.next;
    }

    //递归法：合并两个有序单链表
    public static ListNode Merge1(ListNode list1, ListNode list2) {
            if (list1 != null) {
                return list1;
            }
            if (list2 != null) {
                return list2;
            }
            if (list1.val < list2.val) {
                list1.next = Merge1(list1.next, list2);
                return list1;
            } else {
                list2.next = Merge1(list2.next, list1);
                return list2;
            }
        }



    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //输入两棵二叉树A，B，判断B是不是A的子结构。约定空树不是任意一个树的子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        //两棵树必须不为空
        if (root1 != null && root2 != null) {
            //如果根节点值相同，继续判断左子树和右子树是否相同
              if (root1.val==root2.val){
                  result = doTree1HasTree2(root1,root2);
              }
              //如果根结点值不相同，则判断左子树是否包含
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }
            //如果左子树依然不相同，继续判断右子树是否相同
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    private boolean doTree1HasTree2(TreeNode node1, TreeNode node2) {

        if (node1 == null&&node2!=null) {
            return false;
        }
        if (node2 == null) {
            return true;
        }
        //如果某个节点的值没有对应上，则返回false
        if (node1.val != node2.val) {
            return false;
        }

        return doTree1HasTree2(node1.left,node2.left) &&doTree1HasTree2(node1.right,node2.right);
    }


    //操作给定的二叉树，将其变换为源二叉树的镜像。
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        if (root.left != null) {
            Mirror(root.left);
        }

        if (root.right != null) {
            Mirror(root.right);
        }

    }


//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
//如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//       则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> array = new ArrayList<>();
    //用魔方的思想，每次取出第一行，然后逆时针旋转90°，继续前面步骤
    int row = matrix.length;
        while (row != 0) {
        //第一行添加到顺序表
        for (int i=0;i<matrix.length;i++){
            array.add(matrix[0][i]);
        }
        if (row == 1) {
            break;
        }
        matrix = reverse(matrix);
        row = matrix.length;

    }
        return array;
}

    //翻转矩阵
    private int[][] reverse(int[][] matrix) {
        //获取矩阵的行和列
        int rows = matrix.length;
        int col = matrix[0].length;
        //初始化新矩阵
        int[][] newMatrix = new int[col][rows-1];

        for (int j=col-1;j>=0;j--){
            for (int i=1;i<rows;i++){
                newMatrix[col-1-j][i-1]=matrix[i][j];
            }
        }
        return newMatrix;
    }


//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
    Stack<Integer> minStack = new Stack<>();//辅助栈，用来存放当前元素中的最小元素
    Stack<Integer> dataStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }


    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    Stack<Integer> minStack1 =new Stack<>();
    Stack<Integer> dataStack1 = new Stack<>();

    public void push1(int node){
        dataStack1.push(node);
        //如果最小栈里元素为空，或者node值小于最小栈的栈顶元素，就把node放进去
        if (minStack1.isEmpty() || node < minStack1.peek()) {
            minStack1.push(node);
        }else{
            //否则，
            minStack1.push(minStack1.peek());
        }
    }

    public void pop1(){
        dataStack1.pop();
        minStack1.pop();
    }

    public int top1(){
        return dataStack1.peek();
    }

    public int min1(){
        return minStack1.peek();
    }


//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int popIndex = 0;
        for(int i=0;i<pushA.length;i++) {
            s.push(pushA[i]);
            while (!s.empty() && s.peek() == popA[popIndex]) {
                s.pop();
                popIndex++;
            }
        }
        return s.empty();
    }


    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。(层序遍历)
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }


    //输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
    // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        find(root,target,result,path);
        return result;
    }

    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= target;

        if (target < 0) {
            return;
        }
        if (target == 0 && root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        find(root.left,target,result,new ArrayList<Integer>(path));
        find(root.right,target,result,new ArrayList<Integer>(path));
    }


//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
// 对此链表进行深拷贝，并返回拷贝后的头结点。
// 输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

    public RandomListNode Clone(RandomListNode pHead) {
       Map<RandomListNode,RandomListNode> map = new HashMap<>();
       for (RandomListNode cur = pHead;cur!=null;cur = cur.next){
           map.put(cur,new RandomListNode(cur.label));
       }
       for (RandomListNode cur = pHead;cur!=null;cur = cur.next){
           RandomListNode newCur = map.get(cur);
           newCur.next = map.get(cur.next);
           newCur.random = map.get(cur.random);
       }
       return map.get(pHead);

    }


//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
//要求不能创建任何新的结点，只能调整树中结点指针的指向。
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.right);
        if (pre != null) {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.left);
        return pre;
    }


    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    //例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
//切割字符串，用Substring
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) {
            return result;
        }
        reslve(str,"",result);
        return result;

    }

    private void reslve(String str, String s, ArrayList<String> result) {
        //如果str里没有字符，而且result也没有包含s，就把s添加进去
        if (str.length() == 0) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        //循环切割字符串str,
            for (int i= 0;i<str.length();i++){
                reslve(str.substring(0,i)+str.substring(i+1,str.length()),s+str.charAt(i),result);
            }
    }

//数组中有一个数字出现的次数超过数组长度的一半，找出这个数字。
//例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半
//因此输出2。如果不存在则输出0。
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:array){
            Integer Value = map.get(i);
            if (Value==null){
                map.put(i,1);
            }else{
                map.put(i,Value+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>=array.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }

      TreeNode prev = null;
      TreeNode head = null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    public void inOrder(TreeNode pRootOfTree){
        if (pRootOfTree != null) {
            inOrder(pRootOfTree.left);
        }

        if (head == null) {
            head=pRootOfTree;
        }
        if (prev == null) {
            pRootOfTree.left = null;
        }else{
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
        }
        prev = pRootOfTree;
        inOrder(pRootOfTree.right);

    }


    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }

        for (int i = 0;i<input.length;i++){
            list.add(input[i]);
        }
        for (int i = 0;i<k;i++){
            for (int j = 0;j<input.length-i-1;j++){
                if (input[j]<input[j+1]){
                    int t = input[j];
                    input[j] = input[j+1];
                    input[j+1] = t;
                }
            }
            list.add(input[input.length-i-1]);
        }
        return list;
    }


    //例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0){
            return 0;
        }
        int max = array[0];
        for (int i=1;i<array.length;i++){
            array[i] +=array[i-1]>0?array[i-1]:0;
            max = Math.max(max,array[i]);
        }
        return max;
    }


    //求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    // 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次
    //把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n>0) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            for (int i = 0;i<chars.length;i++){
                if (chars[i] == 1) {
                    count++;
                }
            }
            n-=1;
        }
        return count;
    }





    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入一个整数：");
//        int n = scanner.nextInt();
////        int ret = Fibonacci(n);
////        System.out.println(ret);
//        int t =JumpFloor(n);
//        System.out.println(t);
//        int[] array={1,2,3,4,5,6,7};
//        int[] ret=reOrderArray(array);
//        System.out.println(Arrays.toString(ret));
//        String s = "祝你考出好成绩！";
//        System.out.println(s.length());
       // System.out.println(Math.floor(-8.5));
//        StringBuffer a=new StringBuffer("A");
//
//        StringBuffer b=new StringBuffer("B");
//
//
//        System.out.println(a+"." +b);



    }
    }

