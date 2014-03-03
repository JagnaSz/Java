package mypkg;


import java.io.IOException;

public interface Algorythm {
	public String crypt(String nazwa) throws IOException;
	public String decrypt(String nazwa) throws IOException;
}
