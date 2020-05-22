/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/22
 * @Content:
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();


        binaryTree.getSize1(root);
        System.out.println("节点的个数：" + binaryTree.size);

        System.out.println("节点的个数：" + binaryTree.getSize2(root));

        binaryTree.getLeafSize1(root);
        System.out.println("叶子节点个数：" + binaryTree.leafSize);
        System.out.println("叶子节点个数：" +binaryTree.getLeafSize2(root));

        System.out.println("===========");
        System.out.println("第k层节点的个数");
        System.out.println(binaryTree.getLevelSize(root, 3));


        System.out.println("查找节点val:");
        Node ret = binaryTree.find(root,'E');
        System.out.println(ret.val);
    }
}
