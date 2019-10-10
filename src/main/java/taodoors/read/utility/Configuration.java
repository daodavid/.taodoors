package taodoors.read.utility;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * read configuration files
 * Singleton
 */
public class Configuration {
    public static String folder = "configuration";
    public static String defaultFile = "config.xml";

    private static Configuration configuration = null;
    private DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder = null;

    private Configuration() throws ParserConfigurationException {
        dbFactory=DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
    }

    public static synchronized Configuration getInstance() throws ParserConfigurationException {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    private void init() {

    }

    /***
     * open Doucumnet
     * @param fileName
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */

    public Document openDocument(String fileName) throws ParserConfigurationException, IOException, SAXException {
        if (fileName == null) {
            fileName = defaultFile;
        }
        String file = folder + '/' + fileName;
        File xmlFile = new File(file);
        Document doc = this.dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();
        return doc;
    }


    public String getConfigurationByTagName(String file, String tag) throws IOException, SAXException, ParserConfigurationException {
        Document doc = openDocument(file);
        NodeList nList = doc.getElementsByTagName(tag); //web_content_folder
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                return eElement.getFirstChild().getTextContent();
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String tag = Configuration.getInstance().getConfigurationByTagName(null, "web_content_folder");
        System.out.println(tag);

    }
}
