package pkg1;

public class B extends A {
    public B() {

    }

    protected void decrement() {
	number-= 3;
    }

    void changeName() {
	name = "change name from B";
    }

    private void increment() {
	number += 3;
    }
}