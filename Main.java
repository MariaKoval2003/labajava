import java.net.SocketPermission;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList someStrings = new ArrayList();
        String menu = "1. Add element. \n" +
                "2. Delete element from the end. \n" +
                "3. Search for the repeating elements. \n" +
                "4. Reverse all strings. \n" +
                "5. Search for the substring. \n" +
                "6. Display collection. \n" +
                "7. The longest strings. \n" +
                "8. Exit." ;

        int flag = 0;

        someStrings.add("Hello");
        someStrings.add("HowRU");
        someStrings.add("Fine");
        someStrings.add("Thanks");
        someStrings.add("Exams");
        someStrings.add("Summer");
        someStrings.add("Food");
        someStrings.add("MoreFood");
        someStrings.add("Hello");
        someStrings.add("Summer");
        someStrings.add("Autumn");
        someStrings.add("Learning");
        someStrings.add("Night");
        someStrings.add("Chill");

        while(flag==0) {
            System.out.println(menu);
            Scanner in1 = new Scanner(System.in);
            System.out.print("Write a number: ");
            int choice = in1.nextInt();

            switch (choice) {
                case (1):
                    System.out.println("Write your string: \n");
                    Scanner in2 = new Scanner(System.in);
                    String addedString = in2.nextLine();
                    someStrings.add(addedString);
                    break;
                case (2):
                    String deletedString = (someStrings.get(someStrings.size() - 1)).toString();
                    someStrings.remove(someStrings.get(someStrings.size()-1));
                    System.out.println("You've deleted: " + " ' " + deletedString + " ' ");
                    break;
                case (3):
                    Map<String, Integer> words = new HashMap<String, Integer>();
                    for (int i = 0; i < someStrings.size(); i++) {
                        String tempString = someStrings.get(i).toString();

                        if (!words.containsKey(tempString)) {
                            words.put(tempString, 1);
                        } else {
                            words.put(tempString, words.get(tempString) + 1);
                        }
                    }
                    for (Map.Entry<String, Integer> entry : words.entrySet()) {
                        if(entry.getValue()>1) {
                            System.out.println("String = " + entry.getKey() + ", Times = " + entry.getValue());
                        }
                    }
                    break;
                case (4):
                    int counter;
                    for (counter = 0; counter < someStrings.size(); counter++) {
                        String reverse = new StringBuffer(someStrings.get(counter).toString()).reverse().toString();
                        System.out.println(reverse);
                    }
                    break;
                case (5):
                    System.out.println("Enter the substring: \n");
                    Scanner in3 = new Scanner(System.in);
                    String subStr = in3.nextLine();
                    int existingSubstrings = 0;
                    for(int i = 0; i<someStrings.size()-1; i++){
                        if(someStrings.get(i).toString().lastIndexOf(subStr) != -1){
                            existingSubstrings++;
                            System.out.println("Your substring contains in: " + someStrings.get(i).toString());
                        }
                    }
                    if(existingSubstrings==0){
                        System.out.println("Your substring doesn't contain in any string. :( \n");
                    }
                    break;
                case (6):
                    for(int i = 0; i<someStrings.size()-1; i++){
                        System.out.println("["+ i + "]" + someStrings.get(i));
                    }
                    break;
                case (7):
                    ArrayList sortedStrings = new ArrayList();
                    sortedStrings = someStrings;

                    class StringLengthSort implements Comparator<String>{
                        @Override
                        public int compare(String o1, String o2) {
                            if(o1.length() < o2.length()){
                                return 1;
                            }else{
                                if(o1.length() > o2.length()){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                        }
                    }
                    Comparator<String> stringLengthComparator = new StringLengthSort();
                    Collections.sort(sortedStrings, stringLengthComparator); // sorting
                    for(Object str : sortedStrings){
                        System.out.println(str.toString() + " : " + str.toString().length() + " symbols ");
                    }
                    break;
                case (8):
                    flag = 1;
                    break;
                default:
                    System.out.println("Something is wrong with your choice!");
            }
        }
    }
}
