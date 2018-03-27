package com.examples;

class Node{
    int data;
    Node linkedNode;

    public Node(int data, Node linkedNode) {
        this.data = data;
        this.linkedNode = linkedNode;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLinkedNode() {
        return linkedNode;
    }

    public void setLinkedNode(Node linkedNode) {
        this.linkedNode = linkedNode;
    }
}

public class LinkedListImpl {
    Node first,last;
    int size;
   private void insertAtStart(int data){
       Node node = new Node(data,null);
       if(first == null){
           first = node;
           last = node;
       }
       else{
           Node temp = first;
           first = node;
           first.setLinkedNode(temp);
       }
       size ++;
   }
   private void insertAtPosition(int position, int data){
       Node dummy = new Node(data,null);
       Node temp = first;
       position = position -1;
       for(int i = 1; i<position;i++){
           temp = temp.linkedNode;
       }
       Node next = temp.getLinkedNode();
       temp.setLinkedNode(dummy);
       dummy.setLinkedNode(next);
   }

   private void printElements(){
       Node node = first;
       while(node!=null){
           System.out.println(node.data);
           node = node.getLinkedNode();
       }
   }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insertAtStart(5);
        linkedList.insertAtStart(7);
        linkedList.insertAtStart(9);
        linkedList.insertAtStart(12);
        linkedList.printElements();
        linkedList.insertAtPosition(4,10);
        System.out.println("========");
        linkedList.printElements();

    }
}