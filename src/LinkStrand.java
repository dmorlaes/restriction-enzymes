//I don't want friends, I want audis"

//Dmitri Morales
//Ritvik Janamsetty

public class LinkStrand implements IDnaStrand {

    public LinkStrand(String s) {
        initialize(s);
    }

    public LinkStrand() {
        this("");

    }

    private class Node {
        String info;
        Node next;

        public Node(String s) {
            info = s;
            next = null;

        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppend;
    private long myIndex;
    private int myLocalIndex;
    private Node myCurrent;


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
        myIndex = 0;
        myLocalIndex = 0;
        myCurrent = myFirst;

    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna);
        myLast = myLast.next;
        mySize += myLast.info.length();
        myAppend++;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        Node list = myFirst;
        //ArrayList<String> arr = new ArrayList<>();
        //arr.add(n.info);
        LinkStrand ls = new LinkStrand();
        while (list != null) {
            StringBuilder reverse = new StringBuilder(list.info);
            String revNuc = reverse.reverse().toString();
            Node revNode = new Node (revNuc);
            ls.mySize += ls.myFirst.info.length();
            ls.myFirst.next = ls.myFirst;
            ls.myFirst =  revNode;
            ls.myAppend++;
        }
        return ls;
    }

    @Override
    public int getAppendCount() {
        return myAppend;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || (this.size() <= myIndex)) {
            throw new IndexOutOfBoundsException();
        }
        if (myIndex >= index) {
            myIndex = 0;
            myLocalIndex = 0;
            myCurrent = myFirst;
        }
        while (index != myIndex ) {
            myIndex ++;
            myLocalIndex ++;
            if (myCurrent.next != null && myCurrent.info.length() <= myLocalIndex ) {
                myLocalIndex = 0;
                myCurrent = myCurrent.next;
            }
        }

        return myCurrent.info.charAt(myLocalIndex);
    }

    public String toString() {
        Node n = myFirst;
        StringBuilder ret = new StringBuilder();
        while (n != null) {
            ret.append(n.info);
            n = n.next;
        }
        return ret.toString();
    }


}
