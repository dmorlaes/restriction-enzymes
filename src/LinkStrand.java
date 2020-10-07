//I don't want friends, I want audis"

//Dmitri Morales
//Ritvik Janamsetty


/**
 * Implementation of LinkStrand from the IDnaStrand interface
 */
public class LinkStrand implements IDnaStrand {

    /**
     * Calls the initialize method of the LinkStrand
     * @param s string containing the DNA strand
     */
    public LinkStrand(String s) {
        initialize(s);
    }

    /**
     * Initializes an empty LinkStrand
     */
    public LinkStrand() {
        this("");

    }

    /**
     * Node class for implementation of nodes
     */
    private class Node {
        String info;
        Node next;

        /**
         * defines a node
         * @param s information stored in node
         */
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
     * returns size of LinkStrand
     * @return size of LinkStrand
     */
    @Override
    public long size() {
        return mySize;
    }

    /**
     * initializes an instance of LinkStrand
     * @param source initializes private variables based on
     *               source DNA from constructor
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
     * returns LinkStrand from given data
     * @param source is data from which object constructed
     * @return LinkStrand from given data
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    /**
     * append dna to end of string
     * @param dna
     *            is the string appended to this strand
     * @return modified LinkStrand
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
     * reverses a copy of the current instance of LinkStrand
     * @return reversed LinkStrand
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
     * returns number of appends
     * @return number of appends
     */
    @Override
    public int getAppendCount() {
        return myAppend;
    }

    /**
     * Efficently finds charecter at given index in a LinkStrand Instance
     * @param index specifies which character will be returned
     * @return the charecter at specified index
     */
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

    /**
     * Appends and returns all of the strings stored
     * in each node in an LinkStrand Instance
     * @return string equivalent of LinkStrand
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
