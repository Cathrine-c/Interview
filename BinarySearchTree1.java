package java_1023.java;



class TreeNode{
    public int key;
    TreeNode left;
    TreeNode right;


    public TreeNode( int val) {
        this.left = left;
        this.right = right;
        this.key = key;
    }
}
public class BinarySearchTree1 {
    private TreeNode root=null;
    public TreeNode find(int key){
        TreeNode cur=root;
        while (cur!=null){
            if (key<cur.key) {
                cur=cur.left;
            }else if (key>cur.key){
                cur=cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }

//插入操作
    public boolean insert(int key){
        TreeNode cur=root;
        TreeNode parent=null;
        if (root == null) {
            root=new TreeNode(key);
            return true;
        }
        while (cur!=null){
            if (key<cur.key) {
                parent=cur;
                cur=cur.left;
            } else if (key > cur.key) {
                parent=cur;
                cur=cur.right;
            }else{
                return true;
            }
        }
        return false;
    }

    //删除操作
    public boolean remove(int key){
        TreeNode cur=root;
        TreeNode parent = null;
        if (root == null) {
            return true;
        }
            while (cur != null) {
                if (key < cur.key) {
                    parent = cur;
                    cur = cur.left;
                } else if (key > cur.key) {
                    parent = cur;
                    cur = cur.right;
                } else {
                    removeKey(parent, cur);

                }
            }
        return false;
    }

    private void removeKey(TreeNode parent, TreeNode cur) {
        //cur的左子树为空
        if (cur.left== null) {
            if (cur == root) {
                //1.1
                root=cur.right;
                //1.2如果cur是parent的左子树，cur的左子树为空，右子树非空
            } else if (cur == parent.left) {
                parent.left=cur.right;
                //1.3如果cur是parent的右子树，cur的左子树为空，右子树非空
            }else{
                parent.right=cur.right;
            }

            //cur的右子树为空
        }else if (cur.right == null) {
            if (cur==root){
                //2.1
                root=cur.left;
                //2.2cur为parent的左子树，cur的右子树为空，左子树非空
            } else if (cur == parent.left) {
                parent.left=cur.left;
                //2.3cur为parent的右子树，cur的右子树为空，左子树非空
            }else {
                parent.right=cur.left;
            }
        }else {
            TreeNode scapeGoat=root;
            TreeNode goatParent=null;
            while (scapeGoat.left!=null){
                goatParent=scapeGoat;
                scapeGoat=scapeGoat.left;
            }
            cur.key=scapeGoat.key;
            if (scapeGoat == goatParent.left) {
                goatParent=scapeGoat;
                goatParent.left=scapeGoat.right;
            }else {
               goatParent.right=scapeGoat.right;
            }
        }
    }
}
