
public class BST {
		
		
	int SPACE = 10;
	//Node root = null;
	int count=0;
		public Node insert(Node node, int data)
		{
			if (node == null)
				return createNewNode(data);
			
			if (data < node.data)
				node.left = insert(node.left, data);
			
			else if (data > node.data)
				node.right = insert(node.right, data);
			
			return node;
		}
		
		public Node createNewNode(int data)
		{
			Node node = new Node();
			node.data = data;
			node.left = null;
			node.right = null;
			
			return node;
		}
		
		
		/*public void print2D(Node r, int space, String str) {
			
		    if (r == null) // Base case  1
		      return;
		    
		    space += SPACE; // Increase distance between levels   2
		    print2D(r.right, space, str); // Process right child first 3 
		    System.out.println();
		    for (int i = SPACE; i < space; i++) // 5 
		    	System.out.print(" "); // 5.1  
		    System.out.println(str); // 6
		    count++;
		    print2D(r.left, space, str); // Process left child  7
		    
		  }*/
		

}