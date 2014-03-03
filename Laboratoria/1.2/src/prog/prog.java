package prog;

import pkg1.*;
import pkg2.*;

public class prog {
    
    public static void main(String[] args) {
	A cA = new A(2,"Aga");
	B cB = new B();
	C cC = new C();
	
	System.out.println(cA.getName());
	cA.callChangeName();
	System.out.println(cA.getName());
	cB.callChangeName();
	System.out.println(cB.getName());
	cC.callChangeName();
	System.out.println(cC.getName());
	
	System.out.println();
	cA.callDecrement();
	System.out.println(cA.getNumber());
	cB.callDecrement();
	System.out.println(cB.getNumber());
	cC.callDecrement();
	System.out.println();
	cA.callIncrement();
	System.out.println(cA.getNumber());
	cB.callIncrement();
	System.out.println(cB.getNumber());
	cC.callIncrement();
	}
}

/*error: pkg2/C: name is not public in pkg1.A; cannot be accessed from outside package*/