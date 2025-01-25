package io.github.orionlibs.utilities.document.xml.tasks;

import io.github.orionlibs.core.exception.Assert;
import java.io.File;
import java.io.IOException;
import jakarta.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class OpenXMLFileTask
{
    public static Document run(File XMLFilePath) throws JAXBException, ParserConfigurationException, SAXException, IOException
    {
        Assert.notNull(XMLFilePath, "The given XMLFilePath is null.");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document XMLDocument = dBuilder.parse(XMLFilePath);
        XMLDocument.normalizeDocument();
        return XMLDocument;
    }
}