package com.example.ussdtest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.example.ussdtest.Content;
import com.example.ussdtest.StateMultiLanguage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.apache.log4j.Logger;

/**
 *
 * @author halt14
 */
public class XmlParser {

//    private static final Logger logger = Logger.getLogger(XMLParser.class);

    public List<Content> loadStates(String fileName, String language) throws IOException, NullPointerException, Exception {
        StateMultiLanguage state;
        Integer stateID = 0;
        List<Content> contentList = new ArrayList<>();
        Content content = null;
        Integer contentKey = 0;
        String contentLanguage = "";
        String contenValue = "";
        int charset = 0;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        File file = new File(fileName);
        Document doc = db.parse(file);
        Element docElement = doc.getDocumentElement();
        NodeList statesNodeList = docElement.getElementsByTagName("state");
        if (statesNodeList != null && statesNodeList.getLength() > 0) {
            for (int i = 0; i < statesNodeList.getLength(); i++) {
                Node nodeState = statesNodeList.item(i);
                Element element = (Element) nodeState;
                if (nodeState.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList nodeListStateTag = element.getElementsByTagName("ID");
                    stateID = Integer.parseInt(nodeListStateTag.item(0).getChildNodes().item(0).getNodeValue());
                    nodeListStateTag = element.getElementsByTagName("content");
                    for (int j = 0; j < nodeListStateTag.getLength(); j++) {
                        Node nodeContent = nodeListStateTag.item(j);
                        Element elementContent = (Element) nodeContent;
                        if (nodeContent.getNodeType() == Node.ELEMENT_NODE) {

                            NodeList nodeListContentTag = elementContent.getElementsByTagName("key");
                            contentKey = Integer.parseInt(nodeListContentTag.item(0).getChildNodes().item(0).getNodeValue());

                            nodeListContentTag = elementContent.getElementsByTagName("language");
                            contentLanguage = nodeListContentTag.item(0).getChildNodes().item(0).getNodeValue();
                            nodeListContentTag = elementContent.getElementsByTagName("value");
                            contenValue = nodeListContentTag.item(0).getChildNodes().item(0).getNodeValue();

//                            if (contenValue.length() > 182) {
//                                contenValue = contenValue.substring(0, 182);
//                            }
                            content = new Content(contentKey, contentLanguage, contenValue, charset);
                            contentList.add(content);

                        }

                    }

                }
            }
        }
        return contentList.stream().filter(content1 -> content1.getLanguage().contains(language)).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        XmlParser parser = new XmlParser();
        try {
            List<Content> contents =
                    parser.loadStates("E:\\TinaSoft\\ishare-viettel\\ussdapp_source\\etc\\states.xml", "Vietnamese");
            System.out.println(contents.get(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//        try {
//            HashMap<Integer, StateMultiLanguage> states = new HashMap<Integer, StateMultiLanguage>();
//            List<Content> contentList =   parser.loadStates("E:\\TinaSoft\\ishare-viettel\\ussdapp_source\\etc\\states.xml");
//            List<Content> laos =
//                    contentList.stream().filter(content -> content.getLanguage().contains("Laos")).collect(Collectors.toList());
//            List<Content> vietnamese =
//                    contentList.stream().filter(content -> content.getLanguage().contains("Vietnamese")).collect(Collectors.toList());
//        } catch (Exception e) {
////            logger.info(e.getMessage());
//        }

    }
}
