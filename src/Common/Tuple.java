package Common;

public class Tuple {

	public int Key;
	
	public int Value;
	
	public char CharValue;
	
	public Tuple(int key, int value) {
		this.Key = key;
		this.Value = value;
	}
	
	public Tuple(int key, char charValue) {
		this.Key = key;
		this.CharValue = charValue;
	}
}
