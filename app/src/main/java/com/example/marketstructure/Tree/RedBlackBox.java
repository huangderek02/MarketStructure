package com.example.marketstructure.Tree;

public class RedBlackBox<T extends Comparable<T>> {

    Node<T> root;

    public RedBlackBox(){
        root = null;
    }

    public void rotateRight(Node<T> x){
        if(x.parent != null){
            if(x.parent.right.name.equals(x.name)){
                x.parent.right = x.left;
            }else{
                x.parent.left = x.left;
            }
        }
        x.left.parent = x.parent;
        x.parent = x.left;
        x.left = x.parent.right;
        x.left.parent = x;
        x.parent.right = x;
    }

    public void rotateLeft(Node<T> x){
        if(x.parent != null){
            if(x.parent.left.name.equals(x.name)){
                x.parent.left = x.right;
            }else{
                x.parent.right = x.right;
            }
        }
        x.right.parent = x.parent;
        x.parent = x.right;
        x.right = x.parent.left;
        x.right.parent = x;
        x.parent.left = x;
    }

    public void insert(Textbook book){
        Node<T> node = new Node<T>(book);
        if(node != null){
            insert(node);
        }
    }

    private void insert(Node<T> x){
        if(root == null){
            root = x;
        }else{
            if(search(x.name) != null){
                return;
            }
            insertRecurse(root, x);
        }

        while (x.name != root.name && x.parent.color == Color.RED){
            boolean left = x.parent == x.parent.parent.left;
            Node<T> uncle = left ? x.parent.parent.right : x.parent.parent.left;

            if(uncle.color == Color.RED){
                x.parent.color = Color.BLACK;
                uncle.color = Color.BLACK;
                x.parent.parent.color = Color.RED;
                x = x.parent.parent;
            }else{
                if(x.name == (left ? x.parent.right.name : x.parent.left.name)){
                    x = x.parent;
                    if(left){
                        if(x.name == root.name){
                            root = x.right;
                        }
                        rotateLeft(x);
                    }else{
                        if(x.name == root.name){
                            root = x.left;
                        }
                        rotateRight(x);
                    }
                }
                x.parent.color = Color.BLACK;
                x.parent.parent.color = Color.RED;

                if(left){
                    if(root.name == x.parent.parent.name){
                        this.root = x.parent;
                    }
                    rotateRight(x.parent.parent);
                }else{
                    if(root.name == x.parent.parent.name){
                        this.root = x.parent;
                    }
                    rotateLeft(x.parent.parent);
                }
            }
        }

        root.color = Color.BLACK;
    }

    private void insertRecurse(Node<T> root, Node<T> x){
        int temp = root.name.getTitle().compareTo(x.name.getTitle());

        if(temp > 0){
            if(root.left.name == null){
                root.left = x;
                x.parent = root;
            }else{
                insertRecurse(root.left, x);
            }
        }else if(temp < 0){
            if(root.right.name == null){
                root.right = x;
                x.parent = root;
            }else{
                insertRecurse(root.right, x);
            }
        }else{
            root.amount.addAll(x.amount);
        }
    }

    //Search under maintenance
    public Node<T> search(Textbook name){
        return find(root,name.getTitle());
    }

    private Node<T> find(Node<T> x, String v){
        if(x.name == null){
            return null;
        }

        int temp = v.compareTo(x.name.getTitle());
        if(temp < 0){
            return find(x.left, v);
        }else if(temp > 0){
            return find(x.right, v);
        }else{
            return x;
        }
    }
}

