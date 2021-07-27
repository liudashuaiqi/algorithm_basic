package class08二叉树的递归套路;
//leetcodo98题 给定一个二叉树，判断其是否是一个有效的二叉搜索树
//已测试 正确
public class Code03_IsBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public class Info{
        boolean isBST;
        public int min;
        public int max;
        public Info(boolean isBST,int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return process(root).isBST;
    }
    public Info process(TreeNode root){
        if(root == null){
            return null;
        }
        Info xInfo = process(root.left);
        Info yInfo = process(root.right);

        boolean isBST = (xInfo == null? true: xInfo.max < root.val&&xInfo.isBST==true ) && (yInfo == null?true: root.val < yInfo.min && yInfo.isBST == true);

        int min = root.val;
        if(xInfo != null){
            min = xInfo.min;
        }

        int max = root.val;
        if(yInfo != null){
            max = yInfo.max;
        }
        return new Info(isBST,min,max);
    }
}
