package com.lft.java8.search;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-24 10:08
 */
public class WikiFetcher {
    private long lastRequestTime = -1;
    private long minInterval = 1000;

    public Elements fetchWikipedia(String url) throws IOException {
        sleepIfNeeded();
        Connection conn = Jsoup.connect(url).timeout(5000);
        Document doc = conn.get();
        Element content = doc.getElementById("pane-news");
        Elements paras = content.select("a");
//        Element content = doc.getElementById("mw-content-text");
//        Elements paras = content.select("p");
        return paras;
    }

    public Elements fetchWikipedia1(String url) throws IOException {
        sleepIfNeeded();
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();
        Element content = doc.getElementById("mw-content-text");
        Elements paras = content.select("p");
        return paras;
    }

    public Elements readWikipedia(String url) throws IOException {
        URL realURL = new URL(url);
        String slash = File.separator;
        String filename = "resources" + slash + realURL.getHost() + realURL.getPath();
        InputStream stream = WikiFetcher.class.getClassLoader().getResourceAsStream(filename);
        Document doc = Jsoup.parse(stream, "UTF-8", filename);
        Element content = doc.getElementById("pane-news");
        Elements paras = content.select("a");
        return paras;
    }

    private void sleepIfNeeded() {
        if (lastRequestTime != -1) {
            long currentTime = System.currentTimeMillis();
            long nextRequestTime = lastRequestTime + minInterval;
            if (currentTime < nextRequestTime) {
                try {
                    Thread.sleep(nextRequestTime - currentTime);
                } catch (InterruptedException e) {
                    System.err.println("Warning: sleep interrupted in fetchWikipedia.");
                }
            }
        }
        lastRequestTime = System.currentTimeMillis();
    }

    public static void main(String[] args) throws IOException {
        WikiFetcher wf = new WikiFetcher();
        String url = "https://news.baidu.com";
        //String url = "https://zh.wikipedia.org/wiki/Java_(programming_language)";
        Elements paragraphs = wf.fetchWikipedia(url);
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.attr("href") + paragraph.text());
        }
    }

}
