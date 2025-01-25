package io.github.orionlibs.core.hierarchy;

import java.util.ArrayList;
import java.util.List;

public class Hierarchy
{
    protected TreeNode root;
    protected int numberOfLevels;
    protected int maximumNumberOfAllowedLevels;


    public Hierarchy(String rootName, Object rootValue)
    {
        this.root = new TreeNode(rootName, rootValue, null);
        this.numberOfLevels = 0;
        this.maximumNumberOfAllowedLevels = Integer.MAX_VALUE;
    }


    public Hierarchy(int maximumNumberOfAllowedLevels, String rootName, Object rootValue)
    {
        this(rootName, rootValue);
        this.maximumNumberOfAllowedLevels = maximumNumberOfAllowedLevels;
    }


    public Hierarchy()
    {
        this.numberOfLevels = 0;
        this.maximumNumberOfAllowedLevels = Integer.MAX_VALUE;
    }


    public Hierarchy(int maximumNumberOfAllowedLevels)
    {
        this.numberOfLevels = 0;
        this.maximumNumberOfAllowedLevels = maximumNumberOfAllowedLevels;
    }


    public TreeNode addNode(String parentPath, String childName, Object childValue) throws Exception
    {
        if(root == null)
        {
            this.root = new TreeNode(childName, childValue, null);
            numberOfLevels++;
        }
        TreeNode parent = findNodeByPath(parentPath, root);
        TreeNode child = null;
        if(parent != null)
        {
            if(numberOfLevels + 1 > maximumNumberOfAllowedLevels)
            {
                throw new Exception("No new nodes can be added, because the maximum allowed hierarchy depth has been reached");
            }
            else
            {
                child = parent.addChild(childName, childValue);
                numberOfLevels++;
            }
        }
        return child;
    }


    public TreeNode removeNode(String nodePath)
    {
        TreeNode node = findNodeByPath(nodePath, root);
        TreeNode childToRemove = null;
        if(node != null && node.getParent() != null)
        {
            childToRemove = node.getParent().removeChild(node.getName());
            numberOfLevels--;
        }
        return childToRemove;
    }


    private TreeNode findNodeByPath(String path, TreeNode currentNode)
    {
        if(currentNode.getXPath().equals(path))
        {
            return currentNode;
        }
        for(TreeNode child : currentNode.getChildren())
        {
            TreeNode result = findNodeByPath(path, child);
            if(result != null)
            {
                return result;
            }
        }
        return null;
    }


    public List<String> getTreeXPaths()
    {
        List<String> treeXPaths = new ArrayList<>();
        collectXPathsRecursively(root, treeXPaths);
        return treeXPaths;
    }


    private void collectXPathsRecursively(TreeNode node, List<String> xPaths)
    {
        if(node == null)
        {
            return;
        }
        xPaths.add(node.getXPath());
        for(TreeNode child : node.getChildren())
        {
            collectXPathsRecursively(child, xPaths);
        }
    }


    public TreeNode getRoot()
    {
        return root;
    }


    public int getNumberOfLevels()
    {
        return numberOfLevels;
    }
}
