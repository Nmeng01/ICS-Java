package edu.nyu.cs;

public class TestSequence {
    public static void main(String[] args) {
        String s = "Hello. My name is Nicholas Meng. I study computer science";
        Sentence sentence = new Sentence(s);
        System.out.println(sentence.getFirst());
        System.out.println(sentence.getLast());
        System.out.println(sentence.getSequence().toString());
        System.out.println(((SequentiallyOrdered)sentence.getFirst()).getFirst());
        System.out.println(((SequentiallyOrdered)sentence.getLast()).getLast());
        System.out.println(((SequentiallyOrdered)sentence.getLast()).getSequence());
    }
}
