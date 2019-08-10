package com.in28minutes.login;

public class Token {
	String Name;
	String Pass;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public Token(String name, String pass) {
		super();
		Name = name;
		Pass = pass;
	}
}
