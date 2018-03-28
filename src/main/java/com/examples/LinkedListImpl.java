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
       if(position == 1){
           first = dummy;
           dummy.setLinkedNode(temp);
           return ;
       }
       position = position - 1;
       for(int i = 1; i<position;i++){
           temp = temp.linkedNode;
       }
       Node next = temp.getLinkedNode();
       temp.setLinkedNode(dummy);
       dummy.setLinkedNode(next);
   }

   private void removeAtEnd(){
       Node temp = first;
       while(temp.getLinkedNode().getLinkedNode()!= null){
           temp = temp.getLinkedNode();
       }
       System.out.println(temp.getData());
       temp.setLinkedNode(null);
   }

   private void removeAtStart(){
      Node temp = first;
      first = first.getLinkedNode();
      temp.setLinkedNode(null);
   }

   private void removeAtPosition(int position){
       Node temp = first;
       if(position == 1){
           temp = temp.getLinkedNode();
           first = temp;
           return ;
       }
       position = position-1;
       for(int i = 0; i<position-1; i++){
           temp = temp.linkedNode;
       }
       temp.setLinkedNode(temp.getLinkedNode().getLinkedNode());
   }

   private void removeElementsGraterThanMe(int x){

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
        linkedList.insertAtStart(15);
        linkedList.printElements();
        linkedList.insertAtPosition(3,10);
        System.out.println("========");
        linkedList.printElements();
        System.out.println("========");
        linkedList.removeAtEnd();
        System.out.println("========");
        linkedList.printElements();
        linkedList.removeAtStart();
        System.out.println("========");
        linkedList.printElements();
        linkedList.removeAtPosition(4);
        System.out.println("========");
        linkedList.printElements();

    }
}
