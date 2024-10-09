import java.util.ArrayList;
public class Exercise19_03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(); //this line could just be new ArrayList<>
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> NoDuplicatesList = new ArrayList<>(); // create a new list to store non duplicates
        for (E element : list) {                           // loop through each element in the input list
            if (!NoDuplicatesList.contains(element)) {     // check if the new list already contains the current element
                NoDuplicatesList.add(element);             // if not, add the element to the new list
            }
        }
        return NoDuplicatesList;                           
    }
    
}

