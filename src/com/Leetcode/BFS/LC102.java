package com.Leetcode.BFS;

import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LC102 {
    //BFS
//    public List<List<Integer>> levelOrder(TreeNode root){
//        if(root == null)
//            return new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            List<Integer> cur = new ArrayList<>();
//            for(int i = 0; i < size; i++){
//                TreeNode n = q.poll();
//                cur.add(n.val);
//                if(n.left != null)
//                    q.add(n.left);
//                if(n.right != null)
//                    q.add(n.right);
//            }
//            res.add(cur);
//        }
//        return res;
//    }


    //DFS
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, int level){
        if(root == null)
            return;
        if(level >= res.size())
            res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        if(root.left != null)
            dfs(root.left, res, level + 1);
        if(root.right != null)
            dfs(root.right, res, level + 1);
    }
}
