package Prob2;

public class Node {
	private String name;
	private int val;
	public Node(String name, int val) {
		super();
		this.name = name;
		this.val = val;
	}
	public String getName() {
		return name;
	}
	public int getVal() {
		return val;
	}
	@Override
	public String toString() {
		return "Node [name=" + name + ", val=" + val + "]";
	}
	
}
