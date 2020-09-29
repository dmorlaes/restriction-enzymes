//I don't want freinds, I want audis"

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkStrand implements IDnaStrand{

    public LinkStrand(String s) {
        initialize (s);
    }
    public LinkStrand(){
        this("");

    }

    private class Node {
        String info;
        Node next;
        public Node (String s) {
            info = s;
            next = null;

        }
    }
    private Node myFirst, myLast;
    private long mySize;
    private int myAppend;


    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        myFirst = new Node(source);
        myLast = myFirst;
        mySize = myFirst.info.length();
        myAppend = 0;

    }

    @Override
    public IDnaStrand getInstance(String source) {

        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node (dna);
        myLast = myLast.next;
        mySize += myLast.info.length();
        myAppend++;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        Node n = myFirst;
        ArrayList<String> arr = new ArrayList<>();
        arr.add(n.info);
        while (n.next != null) {
            arr.add(n.next.info);
            n = n.next;
        }
        Node list = null;

        for (int i = arr.size() - 1; i >= 0; i--){

            list = list.next;
            StringBuilder rev = new StringBuilder(arr.get(i));
            list = new Node (rev.reverse().toString());




        }

        return ;





    }

    @Override
    public int getAppendCount() {
        return myAppend;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    public String toString(Node n) {
        n = myFirst;
        StringBuilder ret = new StringBuilder();
        ret.append(n.info);
        while ( n.next != null) {
            ret.append(n.next.info);
            n = n.next;
        }
        return ret.toString();
    }

    //Dmitri Morales


}
