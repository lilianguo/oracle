/*
例子：
     7
   /  \
  5    9
/  \   /  
3    8
对于多余边5-8，9-8此处的删除需要有选择，跟之前的题目找到多余边立马不分选择删除有区别

思路:  LC 98: Validate Binary Search Tree
DFS，参数中带着左右边界，返回值为新树的根节点，如果当前节点不在当前树的范围内，返回null删除该边



*/
class RedundantEdge {
    public void deleteEdge (TreeNode root) {
        
    }
}