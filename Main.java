package Prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static float calculateAvgDistance(Node src, Node dest, HashMap<String, ArrayList<Node>> graph)
	{
		int noOfPaths=0;
		float res=0;
		Queue<Node> queue=new LinkedList<>();
		queue.add(src);
		while(!queue.isEmpty())
		{
			Node s=queue.poll();
			String str="";
			String name;
			name=s.getName();
			str+=name.charAt(name.length()-1);
			//System.out.println("String: "+str);
			if(dest.getName().equals(str))
			{
				noOfPaths+=1;
				res+=s.getVal();
			}
			ArrayList<Node> list=graph.get(str);
			for (Node node : list) {
				if(!(s.getName().contains(node.getName())))
				queue.add(new Node(s.getName()+node.getName(), s.getVal()+node.getVal()));
			}				
			//System.out.println(queue+"\n");
		}
		return res/noOfPaths;
	}
	public static void main(String[] args) {
		
		HashMap<String, ArrayList<Node>> newGraph=new HashMap<>();
		Scanner sc=new Scanner(System.in);
	    newGraph.put("A", new ArrayList<>(Arrays.asList(new Node("B", 12), new Node("C", 13), new Node("D", 11), new Node("E", 8))));
	    newGraph.put("B", new ArrayList<>(Arrays.asList(new Node("A", 12), new Node("C", 3))));
	    newGraph.put("C", new ArrayList<>(Arrays.asList(new Node("A", 13), new Node("B", 3), new Node("E", 4))));
	    newGraph.put("D", new ArrayList<>(Arrays.asList(new Node("A", 11), new Node("E", 7))));
	    newGraph.put("E", new ArrayList<>(Arrays.asList(new Node("A", 8), new Node("C", 4), new Node("D", 7))));
	    for (String key : newGraph.keySet()) {
	        System.out.println(key + ":" + newGraph.get(key));
	    }
	    String ip1=sc.nextLine();
	    Node src=new Node(ip1, 0);
	    String ip2=sc.nextLine();
	    Node des=new Node(ip2, 0);
	    //String str="C";
	    //ArrayList<Node> wanted=newGraph.get(str);
	    try {
	    	float res=calculateAvgDistance(src, des, newGraph);
	    	System.out.println("Average path Length: "+res);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Check Inputs... Enter Valid inputs...");
		}
	    //String st="";
	    //st+="D";
	    //System.out.println(des.getName().equals(st));
	    //System.out.println(wanted);
	    //System.out.println(newGraph);
	}

}
