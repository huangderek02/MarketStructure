package com.example.marketstructure.Tree;

import java.util.Map;
import java.util.Set;

public class Node<T> {
    /*
    *  Node will store like this Book will available or not like:
    *  - Book name: Java 4
    *  - amount: (Set that contain class with this book name).size()
    * */
    Color color;
    Textbook name;
    Set<Textbook> amount;
    Node <T> parent;
    Node <T> left, right;

    public Node(Textbook book){
        this.name = book;
        this.amount.add(book);
        this.color = Color.RED;
        this.parent = null;

        this.left = new Node<T>();
        this.right = new Node<T>();
        this.left.parent = this;
        this.right.parent = this;
    }

    public Node(){
        this.name = null;
        this.color = Color.BLACK;
    }
}
