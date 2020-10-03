//I don't want friends, I want audis"

//Dmitri Morales
//Ritvik Janamsetty

public class LinkStrand implements IDnaStrand {
    /**
     * Initializes link strand
     * @param s
     */
    public LinkStrand(String s) {
        initialize(s);
    }
    /**
     * Initializes link strand
     * no parameter and allows you to use "this"
     *
     */
    public LinkStrand() {
        this("");

    }

    /**
     * Creating the linkNode class here
     */
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

    /**
     * overriden size() method
     * @return mySize
     */
    @Override
    public long size() {
        return mySize;
    }

    /**
     * initializes all instance variables
     * @param source
     */
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

    /**
     * Gets the source for the link strand
     * @param source is data from which object constructed
     * @return the link strand
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    /**
     * Appending the node to the linkstrand
     * @param dna
     *            is the string appended to this strand
     * @return  the newly appended linkstrand
     */
    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna);
        myLast = myLast.next;
        mySize += myLast.info.length();
        myAppend++;
        return this;
    }

    /**
     * Reverses the order of the linkstrand
     * @return the reversed linkstrand
     */
    @Override
    public IDnaStrand reverse() {
        Node list = myFirst;
        LinkStrand ls = new LinkStrand();
        while (list != null) {
            StringBuilder reverse = new StringBuilder(list.info);
            String revNuc = reverse.reverse().toString();
            Node revNode = new Node (revNuc);
            ls.mySize += revNode.info.length();
            revNode.next = ls.myFirst;
            ls.myFirst = revNode;
            ls.myAppend++;
            list = list.next;
        }
        return ls;

    }

    /**
     *
     * @return the amount of times appended
     */
    @Override
    public int getAppendCount() {
        return myAppend;
    }

    /**
     * Finds the char at the specific index called
     * @param index specifies which character will be returned
     * @return the char at the index "index"
     */
    @Override
    public char charAt(int index) {
        if (index < 0 || (this.size() <= index)) {
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

    /**
     * Creates a toString method for the linkStrand
     * @return the string from the string builder
     */
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
