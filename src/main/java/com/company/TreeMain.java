package com.company;

import java.util.*;

public class TreeMain {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(4);
        for(int i = 0; i < 16; i++){
            System.out.println(i + " - " + tree.contains(tree.root, i));
        }
    }

    private static class Tree<T extends Comparable<T>> {

        private Node root;

        private class Node {
            private T value;
            private Node left;
            private Node right;

            public Node(T value) {
                this.value = value;
            }
        }

        public void add(T value) {
            Objects.requireNonNull(value);
            root = appendNode(root, value);
        }

        private Node appendNode(Node current, T value) {
            if (current == null) {
                return new Node(value);
            }
            int compare = value.compareTo(current.value);
            if (compare < 0) {
                current.left = appendNode(current.left, value);
            } else if (compare > 0) {
                current.right = appendNode(current.right, value);
            }
            return current;
        }

        public boolean contains(Node current, T value) {
            if(current == null){
                return false;
            }
            int compare = value.compareTo(current.value);
            if (compare < 0) {
                return contains(current.left, value);
            } else if (compare > 0) {
                return contains(current.right, value);
            }
            return true;
        }
    }
}