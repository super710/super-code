import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author Jinshihong
 * @Date 2020/11/9 10:28
 * @Version 1.0
 */
public class offer_07 {
    public static void main(String[] args) {
        int[] pre={3,9,20,15,7};
        int[] inor={9,3,15,20,7};
        offer_07 o=new offer_07();
        o.buildTree2(pre,inor);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if (preorder==null||preorder.length==0)
           return null;
       Map<Integer,Integer> map=new HashMap<>();
       int preLen=preorder.length;
       int inorLen=inorder.length;
       for (int i=0;i<inorLen;i++)
           map.put(inorder[i],i);

       TreeNode root=buildTree(preorder,0,preLen-1,
                                inorder,0,inorLen-1,
               map);

       return root;
    }
    public TreeNode buildTree(int[] pre,int preStart,int preEnd,
                              int[] inor,int inorStrat,int inorEnd,
                              Map<Integer,Integer> indexMap){

            if (preStart>preEnd)
                return null;

            int rootValue=pre[preStart];
            TreeNode root=new TreeNode(rootValue);

            if (preEnd==preStart)
                return root;
            else{
                int indexRoot=indexMap.get(rootValue);
                int leftNodes=indexRoot-inorStrat;
                int rightNodes=inorEnd-indexRoot;
                TreeNode left=buildTree(pre,preStart+1,preStart+leftNodes,inor,inorStrat,indexRoot-1,indexMap);
                TreeNode right=buildTree(pre,preEnd-rightNodes+1,preEnd,inor,indexRoot+1,inorEnd,indexMap);
                root.right=right;
                root.left=left;
                return root;


            }
    }

//    前序遍历，从根节点root开始，只要有左子节点，就一直会往左下方走，直到最左下角。 而中序遍历，是从最左下角往上（示例中的4-5-8-9-3），如果碰到节点有右子节点，则会转向（示例中的8-10）。
//    因此，代码中的if块是用前序数组一直构建左子树，如果碰到了inorder[inorderIndex]，表示到了左下角，这时就需要往上走并处理右子树，也就是while代码块。
    public TreeNode buildTree2(int[] preorder,int[] inorder){
       if (preorder==null||preorder.length==0)
           return null;

       Stack<TreeNode> stack=new Stack<>();
       TreeNode root=new TreeNode(preorder[0]);
       stack.push(root);

       int inoIndex=0;
       for (int i=1;i<preorder.length;i++){
           int preVal=preorder[i];

           if (stack.peek().val!=inorder[inoIndex]){
               TreeNode node=stack.peek();
               node.left=new TreeNode(preVal);
               stack.push(node.left);
           }else{
               TreeNode node=new TreeNode(0);
               while(!stack.isEmpty()&&stack.peek().val==inorder[inoIndex]){
                   node=stack.pop();
                   inoIndex++;
               }
               node.right=new TreeNode(preVal);
               stack.push(node.right);
           }


       }
        return root;

    }



}
































