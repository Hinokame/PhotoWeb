package com.andrew.helper;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Rita on 12/07/2015.
 */
public class FileHelper {
    public void lookForFile(File file) {
        // working on parsing xml
        DOMParser parser = new DOMParser();
        try {
            parser.parse(file.getPath());
            Document doc = parser.getDocument();
            // Get the document's root XML node
            NodeList root = doc.getChildNodes();
            // Navigate down the hierarchy to get tomcat-users
            Node comp = getNode("tomcat-users", root);
            System.out.print(comp);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected Node getNode(String tagName, NodeList nodes) {
        for (int x = 0; x < nodes.getLength(); x++) {
            Node node = nodes.item(x);

            if (node.getNodeName().equalsIgnoreCase(tagName)) {

                return node;
            }
        }

        return null;
    }


}
