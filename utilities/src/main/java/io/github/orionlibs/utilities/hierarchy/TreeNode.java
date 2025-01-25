package io.github.orionlibs.utilities.hierarchy;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TreeNode
{
    private String name;
    private Object value;
    private TreeNode parent;
    private CopyOnWriteArrayList<TreeNode> children;


    public TreeNode(String name, Object value, TreeNode parent)
    {
        this.name = name;
        this.value = value;
        this.parent = parent;
        this.children = new CopyOnWriteArrayList<>();
    }


    public String getXPath()
    {

        if(parent == null)
        {
            return "/" + name;
        }

        return parent.getXPath() + "/" + name;
    }


    public TreeNode addChild(String childName, Object value)
    {
        TreeNode child = new TreeNode(childName, value, this);
        children.add(child);
        return child;
    }


    public TreeNode removeChild(String childName)
    {
        TreeNode childToRemove = null;

        for(TreeNode child : children)
        {

            if(child.name.equals(childName))
            {
                childToRemove = child;
                children.remove(child);
            }

        }

        return childToRemove;
    }


    public List<TreeNode> getChildren()
    {
        return children;
    }


    public TreeNode getParent()
    {
        return parent;
    }


    public String getName()
    {
        return name;
    }


    public Object getValue()
    {
        return value;
    }
}
