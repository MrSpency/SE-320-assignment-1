import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;;


public class HWfour {
    public static final double NUM_TO_FORMAT = 12345.678;
    public static final String NUM_TO_FORMAT_STRING = "12,345.678";
    public static void main(String[] args) {
        //PROBLEM 1        
        // Create a LinkedHashSet
        LinkedHashSet<String> linkedHashSet_one = new LinkedHashSet<>();
        LinkedHashSet<String> linkedHashSet_two = new LinkedHashSet<>();

        //linkedHashSet_one
        linkedHashSet_one.add("George");
        linkedHashSet_one.add("Jim");
        linkedHashSet_one.add("John");
        linkedHashSet_one.add("Blake");
        linkedHashSet_one.add("Kevin");
        linkedHashSet_one.add("Michael");

        //linkedHashSet_two
        linkedHashSet_two.add("George");
        linkedHashSet_two.add("Katie");
        linkedHashSet_two.add("Kevin");
        linkedHashSet_two.add("Michelle");
        linkedHashSet_two.add("Ryan");

        Set<String> union = new LinkedHashSet<>(linkedHashSet_one); //clone the set to preserve the orginal set
        union.addAll(linkedHashSet_two); //add all elements of linkedHashSet_one to linkedHashSet_two (duplicates are removed)
        System.out.println("Union: " + union);
        
        Set<String> difference = new LinkedHashSet<>(linkedHashSet_one); //clone the set to preserve the orginal set
        difference.removeAll(linkedHashSet_two); //remove elements in linkedHashSet_two from linkedHashSet_one
        System.out.println("Difference: " + difference);

        Set<String> intersection = new LinkedHashSet<>(linkedHashSet_one); //clone the set to preserve the orginal set
        intersection.retainAll(linkedHashSet_two); //retain elements that are only present in both sets
        System.out.println("Intersection: " + intersection);



        ////PROBLEM 2
        System.out.println("-------------------------------");
        Set<String> treeSet_words = new TreeSet<>(); //create TreeSet to hold nonduplicate words
        try {
            File file = new File("textfile.txt");

            Scanner scanner = new Scanner(file);

            //read words one by one
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.replace(",", "").toLowerCase(); //replace all commas with empty words
                word = word.replace("'", "").toLowerCase(); //replace all apostrophes with empty words
                //convert all words to lowercase to make the collection case-insenstive
                
                if(!word.isEmpty()){ //ensure empty words are not added
                    treeSet_words.add(word); 
                }


            }
            scanner.close();
            System.out.println("Nonduplicate words in ascending order: ");
            for (String word : treeSet_words){
                System.out.print(word + " ");
            }



            } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            }

            //PROBLEM 3
            System.out.println("");
            System.out.println("-------------------------------");

            //section 1
            //Locale UK; //not nessary
            NumberFormat nf = NumberFormat.getInstance(Locale.UK); //create a num object for UK locale
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
            String UK_Numformat = nf.format(NUM_TO_FORMAT); //convert java number to locale specific string form
            System.out.println("Formatted number in UK locale: " + UK_Numformat);

            //section 2
            NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
            String US_priceformat = cf.format(NUM_TO_FORMAT);
            System.out.println("Formatted currency in US locale: " + US_priceformat);

            //section 3
            try{
                NumberFormat pf = NumberFormat.getInstance(Locale.US);
                Number parsedNumber = pf.parse(NUM_TO_FORMAT_STRING);
                //double parsedDouble = parsedNumber.doubleValue();
                System.out.println("Parsed number: " + parsedNumber);
            } catch (ParseException e){
                System.out.println("Error parsing double: " + e.getMessage());
            }
    }
}
