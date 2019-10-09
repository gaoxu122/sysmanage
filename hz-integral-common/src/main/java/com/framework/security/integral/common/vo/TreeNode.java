package com.framework.security.integral.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
*TreeNode
 *
*@description
 *
*@author jianghx
*@create 2018/8/23 16:09
**/
public class TreeNode {
    protected int id;
    protected int parentId;

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    List<TreeNode> children = new ArrayList<TreeNode>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void add(TreeNode node){
        children.add(node);
    }
}
