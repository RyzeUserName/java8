package com.lft.java8.search;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-25 15:16
 */
public class WikiParser {
    private Elements elements;
    private Deque<String> deque;

    public WikiParser(Elements elements) {
        this.elements = elements;
        this.deque = new ArrayDeque<>();
    }

    public Element findFirstLink() {
        for (Element element : elements) {
            Element firstLink = findFirstLinkPara(element);
            if (firstLink != null) {
                return firstLink;
            }
            if (!deque.isEmpty()) {
                System.err.println("Warning: unbalanced parentheses.");
            }
        }
        return null;
    }

    private Element findFirstLinkPara(Element element) {
        Iterable<Node> nodes = new WikiNodeIterable(element);
        for (Node node : nodes) {
            if (node instanceof TextNode) {
                processTextNode((TextNode) node);
            }
            if (node instanceof Element) {
                Element element1 = processElement((Element) node);
                if (element1 != null) {
                    return element1;
                }
            }
        }
        return null;
    }

    private Element processElement(Element node) {
        if (validLink(node)) {
            return node;
        }
        return null;

    }

    private boolean validLink(Element node) {
        //是不是超链
        if (!node.tagName().equals("a")) {
            return false;
        }
        //是不是斜体
        if (isItalic(node)) {
            return false;
        }
        //括号里
        if (isInParens(node)) {
            return false;
        }
        //书签
        if (startWith(node, "#")) {
            return false;
        }
        // a Wikipedia help page
        if (startWith(node, "/wiki/Help:")) {
            return false;
        }
        return true;
    }

    private boolean startWith(Element node, String s) {
        return node.attr("href").startsWith(s);
    }

    private boolean isInParens(Element node) {
        return !deque.isEmpty();
    }

    private boolean isItalic(Element node) {
        for (Element start = node; start != null; start = start.parent()) {
            if (start.tagName().equals("i") || start.tagName().equals("em")) {
                return true;
            }
        }
        return false;
    }

    private void processTextNode(TextNode node) {
        StringTokenizer st = new StringTokenizer(node.text(), " ()", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("(")) {
                deque.push(token);
            }
            if (token.equals(")")) {
                if (deque.isEmpty()) {
                    System.err.println("Warning: unbalanced parentheses.");
                }
                deque.pop();
            }
        }
    }
}
