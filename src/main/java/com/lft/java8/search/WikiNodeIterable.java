package com.lft.java8.search;

import org.jsoup.nodes.Node;

import java.util.*;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-24 9:48
 */
public class WikiNodeIterable implements Iterable<Node> {
    private Node node;

    public WikiNodeIterable(Node node) {
        this.node = node;
    }

    @Override
    public Iterator<Node> iterator() {
        return new WikiNodeIterator(node);
    }

    private class WikiNodeIterator implements Iterator<Node> {
        Deque<Node> stack;

        public WikiNodeIterator(Node stack) {
            this.stack = new ArrayDeque<>();
            this.stack.push(stack);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }
            Node pop = stack.pop();
            List<Node> nodes = new ArrayList<>(pop.childNodes());
            Collections.reverse(nodes);
            for (Node child : nodes) {
                stack.push(child);
            }
            return pop;
        }
    }

}
