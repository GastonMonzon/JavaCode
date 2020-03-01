package com.company;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            if (currentItem.compareTo(newItem) < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (currentItem.compareTo(newItem) > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                System.out.println(newItem.getValue() + " is already on the list");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem currentItem=this.root;
        ListItem parentItem=currentItem;
        while(currentItem!=null){
            if(currentItem.compareTo(item)<0){
                parentItem=currentItem;
                currentItem=currentItem.next();
            }else if(currentItem.compareTo(item)>0){
                parentItem=currentItem;
                currentItem=currentItem.previous();
            }else{
                performRemoval(currentItem, parentItem);
                System.out.println("Removing item " + item.getValue());
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        if(item.next()==null){
            //no right tree, so make parent point to left tree(which may be null)
            if(parent.next()==item){
                //item is right child of its parent
                parent.setNext(item.previous());
            }else if(parent.previous()==item){
                //item is left child of its parent
                parent.setPrevious(item.previous());
            }else {
                //parent is item so its the root of the tree
                this.root = item.previous();
            }
            }else if(item.previous()==null){
                //no left tree so make parent point to right tree(which may be null)
                if(parent.next()==item){
                    //item is right child of its parent
                    parent.setNext(item.next());
            }else if(parent.previous()==item){
                    //item is left child of its parent
                    parent.setPrevious(item.next());
                }else{
                    //parent is item so its the root
                    this.root=item.next();
                }
        }else{
            //from the right subtree find the leftmost value which is the smallest
            ListItem current=item.next();
            ListItem leftmostParent=item;
            while(current.previous()!=null){
                leftmostParent=current;
                current=current.previous();
            }
            //insert value into item to be deleted
            item.setValue(current.getValue());
            //and delete the smallest
            if(leftmostParent==item){
                //current points to smallest node
                item.setNext(current.next());
            }else{
                //point the smallest node's parent to the smallest node's right child(which may be null)
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if(root!=null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
