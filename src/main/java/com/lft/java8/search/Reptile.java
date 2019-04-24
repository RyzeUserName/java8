package com.lft.java8.search;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * 爬虫
 * Jsoup 解析
 * @author Ryze
 * @date 2019-04-23 15:34
 */
public class Reptile {
    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        //test3();
    }

    /**
     * 普通测试
     */
    public static void test1() throws IOException {
        String url = "https://baidu.com";
        Document document = Jsoup.connect(url).timeout(5000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)").get();
        Element element = document.getElementById("wrapper");
        Elements p = element.select("p");
        for (Element node : p) {
            System.out.println(node.text());
        }
    }

    /**
     * DFS 深度优化搜索
     * 从第一个节点开始遍历，子节点遍历，直到没有子节点，开始回溯
     *
     */
    public static void test2() throws IOException {
        String url = "https://baidu.com";
        Document document = Jsoup.connect(url).timeout(5000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)").get();
        Element body = document.body();
        recursiveDFS(body);
    }

    /**
     * 递归回溯
     */
    private static void recursiveDFS(Node element) {
        if (element instanceof TextNode && StringUtils.isNotBlank(((TextNode) element).text())) {
            System.out.println(element);
        }
        for (Node node : element.childNodes()) {
            recursiveDFS(node);
        }
    }

    /**
     * DFS 深度优化搜索  迭代
     * 从第一个节点开始遍历，子节点遍历，直到没有子节点，开始回溯
     *
     */
    public static void test3() throws IOException {
        String url = "https://baidu.com";
        Document document = Jsoup.connect(url).timeout(5000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)").get();
        Element body = document.body();
        recursiveDFS1(body);
    }

    /**
     * 栈 回溯
     */
    private static void recursiveDFS1(Node element) {
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.push(element);
        while (!nodes.isEmpty()) {
            Node pop = nodes.pop();
            if (element instanceof TextNode && StringUtils.isNotBlank(((TextNode) element).text())) {
                System.out.println(element);
            }
            List<Node> nodes1 = new ArrayList<>(pop.childNodes());
            Collections.reverse(nodes1);
            for (Node node : nodes1) {
                nodes.push(node);
            }
        }
        for (Node node : element.childNodes()) {
            recursiveDFS(node);
        }
    }
}
