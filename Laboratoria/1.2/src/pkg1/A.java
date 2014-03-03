package pkg1;

public class A {
    
    protected int number;
    String name;

    public A(int _number, String _name) {
	number = _number;
	name = _name;
    }

    public A() {
	number = 0;
	name = "default";
    }
    public String getName() {
	return this.name;
    }
    public void callDecrement() {
	decrement();
    }
    
    public void callChangeName() {
	changeName();
    }
    
    public void callIncrement() {
	increment();
    }

    private void increment() {
	++number;
    }

    protected void decrement() {
	--number;
    }

    void changeName() {
	name = "change name from A";
    }

    public int getNumber(){
    	return this.number;
    }
    
}


//odp: Pola o dostępie pakietowym są widziane w klasach pochodnych W klasie z pakietu, ale nie są widoczne w klasach pochodnych W klasie spoza pakietu.
