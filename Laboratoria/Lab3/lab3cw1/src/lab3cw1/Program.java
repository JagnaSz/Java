package lab3cw1;

import java.util.LinkedList;


public class Program {

	public static void main(String[] args) {
		 double w = 0.5;
		 LinkedList<Double> list = new LinkedList<Double>();
		list.add(10.2);
		
		Var ft = new Var();
		ft.changeVar(w);
		System.out.println(w);
		ft.changeList(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}