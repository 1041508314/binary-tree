/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/23
 * @Content:
 */
/**
 *
 * 判断两棵树是否相同
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

class solution{
    public boolean isSameTree(TreeNode p,TreeNode q){
        if((p == null && q != null) || (p != null && q ==null)){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left , q.left) &&isSameTree(p.right , q.right);
    }
}
