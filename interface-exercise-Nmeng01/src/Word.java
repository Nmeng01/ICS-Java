package edu.nyu.cs;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Word extends OrderedThing implements SequentiallyOrdered {
    
    private ArrayList<Character> charList;
    private int wordPos;

    public Word(String word, int pos) {
        char[] chars = word.toCharArray();
        this.charList = new ArrayList<>();
        for(char ch: chars) {
            this.charList.add(new Character(ch));
        }
        this.wordPos = pos;
    }
    
    public OrderedThing getFirst() {
        OrderedThing first = this.charList.get(0);
        return first;
    }

    public OrderedThing getLast() {
        OrderedThing last = this.charList.get(this.charList.size() - 1);
        return last;
    }

    public ArrayList<OrderedThing> getSequence() {
        ArrayList<OrderedThing> thingList = new ArrayList<>();
        for(Character ch : this.charList) {
            thingList.add(ch);
        }
        return thingList;
    }

    public int getPosition() {
        return this.wordPos;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for(Character c : this.charList) {
            temp.append(c.toString());
        }
        String output =  "'" + temp.toString() + "'" + " at position: " + getPosition();
        return output;
    }
}
