package edu.nyu.cs;

import java.util.ArrayList;

public class Sentence implements SequentiallyOrdered {
    
    private ArrayList<Word> wordList;

    public Sentence(String sentence) {
        String[] words = sentence.split("[^\\w']+");
        this.wordList = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            this.wordList.add(new Word(words[i], i));
        }
    }

    public OrderedThing getFirst() {
        OrderedThing first = this.wordList.get(0);
        return first;
    }

    public OrderedThing getLast() {
        OrderedThing last = this.wordList.get(this.wordList.size() - 1);
        return last;
    }

    public ArrayList<OrderedThing> getSequence() {
        ArrayList<OrderedThing> thingList = new ArrayList<>();
        for(Word word : this.wordList) {
            thingList.add(word);
        }
        return thingList;
    }
}
