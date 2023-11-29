package edu.nyu.cs;

public class Character extends OrderedThing {
    
    private char ch;

    public Character(char c) {
        this.setCharacter(c);
    }

    public void setCharacter(char chr) {
        this.ch = chr;
    }

    public char getCharacter() {
        return this.ch;
    }

    public String toString() {
        String s = "" + this.ch;
        return s;
    }
}
