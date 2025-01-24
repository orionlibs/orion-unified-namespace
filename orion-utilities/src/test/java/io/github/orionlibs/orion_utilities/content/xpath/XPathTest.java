package io.github.orionlibs.orion_utilities.content.xpath;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.orionlibs.orion_utilities.ATest;
import io.github.orionlibs.orion_utilities.content.XPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class XPathTest extends ATest
{
    @Test
    void testXPathValidator()
    {
        assertFalse(XPath.isValid("/"));
        assertTrue(XPath.isValid("/level 1"));
        assertTrue(XPath.isValid("/level 1/level2"));
        assertTrue(XPath.isValid("/level 1/level2/level+3"));
        assertTrue(XPath.isValid("/level 1/level2/level+3/level 4/level 5/level 6"));
        assertFalse(XPath.isValid("level 1"));
        assertFalse(XPath.isValid("level 1/level2"));
    }
}
