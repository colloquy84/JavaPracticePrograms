package com.pandeyar.saxparser;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("deprecation")
public class SaxParserDemo extends HandlerBase {
    protected static final String XML_FILE_NAME = "D:/Arun-Pandey/WorkSpace/NewMAven/src/main/java/saxparser/library1.xml";
    static private Writer out;

    public static void main(String[] argv) {
        // Use the default (non-validating) parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            // Set up output stream
            out = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);

            // Parse the input
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(XML_FILE_NAME), new SaxParserDemo());

        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(0);
    }

    //===========================================================
    // Methods in SAX DocumentHandler 
    //===========================================================

    public void startDocument()
            throws SAXException {
        showData("<?xml version='1.0' encoding='UTF-8'?>");
        newLine();
    }

    public void endDocument()
            throws SAXException {
        try {
            newLine();
            out.flush();
        } catch (IOException e) {
            throw new SAXException("I/O error", e);
        }
    }

    @SuppressWarnings("deprecation")
    public void startElement(String name, AttributeList attrs)
            throws SAXException {
        showData("<" + name);
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength(); i++) {
                showData(" ");
                showData(attrs.getName(i) + "=\"" + attrs.getValue(i) + "\"");
            }
        }
        showData(">");
    }

    public void endElement(String name)
            throws SAXException {
        showData("</" + name + ">");
    }

    public void characters(char[] buf, int offset, int len)
            throws SAXException {
        String s = new String(buf, offset, len);
        showData(s);
    }

    //===========================================================
    // Helpers Methods
    //===========================================================

    // Wrap I/O exceptions in SAX exceptions, to
    // suit handler signature requirements
    private void showData(String s)
            throws SAXException {
        try {
            out.write(s);
            out.flush();
        } catch (IOException e) {
            throw new SAXException("I/O error", e);
        }
    }

    // Start a new line
    private void newLine()
            throws SAXException {
        String lineEnd = System.getProperty("line.separator");
        try {
            out.write(lineEnd);
        } catch (IOException e) {
            throw new SAXException("I/O error", e);
        }
    }
}
