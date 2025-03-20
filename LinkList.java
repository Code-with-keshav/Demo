package com.collectionfarmwork;

public class LinkList {
   // Insert Node in between linked list
	Node head;
	private int size;
	
	class Node{
		String data;
		Node next;
		
		 Node(String data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head==null) {
			newNode.next = head;
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
//	add element in last of linked list
	public void addLast(String data) {
		Node lastNode = new Node(data);
		// corner case
		if(head==null) {
			lastNode.next = head;
			head = lastNode;
			return;
		}
		Node secondLast = head;
		//secondLast.next = head.next;
		while(secondLast.next!=null) {
			secondLast  = secondLast.next;
		
		}
		secondLast.next = lastNode;
	}
	// delete last element from linked list
	public void removeLast() {
		if(head==null) {
			System.out.println("The List IS Empty");
			return;
		}
		size--;
		if(head.next == null) {
			System.out.println("Only one node present in list");
			head = null;
			return;
		}
		Node secondLast = head;
		Node last = secondLast.next;
	
		while(last.next != null) {
			secondLast = secondLast.next;
			last = last.next;
		}
	    secondLast.next = null;
	}
	// remove first element from the list
	public void removeFirst() {
		if(head==null) {
			System.out.println("The List IS Empty ");
			return;
		}
		size--;
		if(head.next == null) {
			System.out.println("Only one node present in list");
			head = null;
			return;
		}
		
		head = head.next;
		
	}
	public void addInBet(int index,String data) {
		if( index<0 || index>size )
		{
			System.out.println("Index Out Of Bond !");
			return;
		}
		
		Node newNode = new Node(data);
		size++;
		// corner case 1
		if(head==null || index==0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		// coner case 2
		if(head.next==null && index==1) {
			head.next = newNode; 
			return;
		}
	    Node currNode = head;
	    Node nextNode = currNode.next;
		for(int i=1;i<size;i++) {
			 
			if(i==index) {
				
				currNode.next = newNode;
				newNode.next = nextNode;
				break;
			}
			currNode = currNode.next;
		    nextNode = nextNode.next;
		}
	}
	public void reverseList(Node head) {
		if(head==null)return;
		reverseList(head.next);
		System.out.println(head.data+" ");
	}
	
	public String getIndex(String data) {
		if(head==null) {
			return "The list is empty !" ;
		}
		Node getNode = head;
		try {
		for(int i=0;i<size;i++) {
		
		if(getNode.data == data) {
			return data+" found at index :"+i ;
		  }
	
		getNode = getNode.next;
		}
		return data+" Not found in this list";
		}catch(NullPointerException e) {
			return data+" Not found in this list";
		}
	}
	
	public void printList() {
		if(head==null) {
			System.out.println("The List IS Empty Now");
			return;
		}
		Node currNode = head;
		while(currNode != null ) {
			System.out.print(currNode.data+"-->");
			currNode = currNode.next;
		}
		System.out.println("null");
	}
	  
	public int getSize() {
		return size;
	}
	
	
	
	
	public static void main(String[] args) {
		 
		LinkList list = new LinkList();
		
		// add first
		list.addFirst("is");
		list.addFirst("This");
		list.printList();
		
		// add last
		list.addLast("LinkedList");
		list.printList();
		
		//remove last
		list.removeLast();
	    //list.printList();
	    
	    //remove First 
	    list.removeFirst();
	    //list.printList();
	    
	    System.out.println(list.getSize());
	    list.addInBet(0, "This");
	    list.addInBet(2, "List");
	    list.addInBet(2, "a");
	    list.printList();
	      
	    
	    LinkList intLL = new LinkList();
	    intLL.addInBet(0, "6");
	    intLL.addInBet(1, "8");
	    intLL.addInBet(2, "3");
	    intLL.addInBet(3, "7");
	    intLL.addInBet(4, "5");
	    
	    System.out.println(intLL.getIndex("1"));
	    
	   intLL.reverseList(intLL.head); 
	   
		 
	}
}
