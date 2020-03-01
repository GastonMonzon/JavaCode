package com.company;

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightlink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightlink=item;
        return this.rightlink;
    }

    @Override
    ListItem previous() {
        return this.leftItem;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftItem=item;
        return this.leftItem;
    }

    @Override
    int compareTo(ListItem item) {
        if(item!=null){
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}
