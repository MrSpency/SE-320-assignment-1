import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class removeDuplicates {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("A");
        list1.add("B");
        list1.add("B");
        list1.add("C");
        list1.add("C");
        System.out.println("Before: " + list1);
        removeDuplicates(list1);
        System.out.println("After: " + list1);
    }

    /**
    * Removes all duplicates from List lst
    * @param lst the list to remove duplicates from. 
    * requires the list to be non-null. 
    * requires the list to be sorted.
    * requires elements must be comparable using `equals` method.
    */
    public static void removeDuplicates(List lst) {
        if (lst == null || lst.size() == 0) return;
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();
        while(elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex)) lst.remove(nex);
            else pre = nex;
        }
    }
}