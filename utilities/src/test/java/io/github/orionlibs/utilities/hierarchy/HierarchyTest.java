package io.github.orionlibs.utilities.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.utilities.ATest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class HierarchyTest extends ATest
{
    @Test
    void testHierarchyXPathForTags() throws Exception
    {
        Hierarchy hierarchy = new Hierarchy("Enterprise 1", null);
        TreeNode root = hierarchy.getRoot();
        assertEquals("/Enterprise 1", root.getXPath());
        TreeNode node1 = hierarchy.addNode("/Enterprise 1", "Site 1", null);
        assertEquals("/Enterprise 1/Site 1", node1.getXPath());
        TreeNode node2 = hierarchy.addNode("/Enterprise 1/Site 1", "Area 1", null);
        assertEquals("/Enterprise 1/Site 1/Area 1", node2.getXPath());
        TreeNode node3 = hierarchy.addNode("/Enterprise 1/Site 1", "Area 2", null);
        assertEquals("/Enterprise 1/Site 1/Area 2", node3.getXPath());
    }


    @Test
    void testHierarchyXPaths() throws Exception
    {
        Hierarchy hierarchy = new Hierarchy("Enterprise 1", null);
        hierarchy.addNode("/Enterprise 1", "Site 1", null);
        hierarchy.addNode("/Enterprise 1/Site 1", "Area 1", null);
        hierarchy.addNode("/Enterprise 1/Site 1", "Area 2", null);
        hierarchy.addNode("/Enterprise 1/Site 1/Area 2", "Work Center 1", null);
        List<String> xPaths = hierarchy.getTreeXPaths();
        assertEquals("/Enterprise 1", xPaths.get(0));
        assertEquals("/Enterprise 1/Site 1", xPaths.get(1));
        assertEquals("/Enterprise 1/Site 1/Area 1", xPaths.get(2));
        assertEquals("/Enterprise 1/Site 1/Area 2", xPaths.get(3));
        assertEquals("/Enterprise 1/Site 1/Area 2/Work Center 1", xPaths.get(4));
    }
}
