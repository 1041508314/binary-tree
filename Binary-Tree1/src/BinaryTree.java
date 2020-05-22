/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/22
 * @Content:
 */
class Node{
    public char val;
    public Node left;//左孩子
    public Node right;//右孩子
    public Node(char val){
        this.val = val;
    }
}
public class BinaryTree {

    public Node buildTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;

    }

    //三种遍历都要用递归来实现
    //前序遍历
    void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val +" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    void inOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    void postOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    //遍历思路 求节点个数  (以前序遍历)
    static int size = 0;
    void getSize1(Node root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }


    //子问题思路 求节点个数
    int getSize2(Node root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) +1 ;
    }


    //遍历思路 求叶子节点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }else{
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }

    }


    //子问题思路 求叶子节点个数
    int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);

    }


    //子问题思路 求第k层节点个数
    int getLevelSize(Node root , int k){
        if(root == null){
            return 0;
        }else if(k == 1){
            return 1;
        }else{
            return getLevelSize(root.left,k-1) + getLevelSize(root.right, k-1);
        }
    }


    //获取二叉树的高度
    int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }


    //查找val所在节点 没有的话返回null
    //按照 根——》左——》右 的顺序进行查找 (前序遍历)
    //一旦找到 立即返回 不需要在其他位置查找
    Node find(Node root,char val){
        if(root == null){
            return null;
        }
        //1.判断根节点是不是查找的数字val
        //2.如果不是 去左边找
        Node left = find(root.left,val);
        if(left != null){
            return left;
        }
        //3.再去右边找
        Node right = find(root.right,val);
        if(right != null){
            return right;
        }
        return null;
    }
}
