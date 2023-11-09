import java.util.Arrays;

public class LabExercise_2_1
{
public static void main(String[] args)
{

String text1 = "We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative.The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";

String text2 = "Hello World";

String text3 = "We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative.The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";

String text4 = "";

//charAt()
System.out.println("The character at index 1 is: " + text1.charAt(1));

//compareTo
System.out.println(text1.compareTo(text2));
System.out.println(text1.compareTo(text3)+" Means they are equal lexocigraphically");

//concat
System.out.println("The concatenated string is: " + text1.concat(text2));

//contains
System.out.println(text1.contains("families"));
System.out.println(text1.contains("Families"));

//endswith
System.out.println(text2.endsWith("d"));

//equals
System.out.println(text1.equals(text2));
System.out.println(text1.equals(text3));

//equalsIgnoreCase
System.out.println(text1.equalsIgnoreCase(text2));
System.out.println(text1.equalsIgnoreCase(text3));

//format
String formattedString = String.format("The text is: %s", text2);
System.out.println(formattedString);

//getBytes
System.out.println(text1.getBytes());

//getChars
char[] cha = new char[20];
text2.getChars(1,5,cha,0);
System.out.println("The chars of the text are: " +cha);

//indexOf
System.out.println(text1.indexOf("families"));

//intern
System.out.println(text2.intern());

//isEmpty
System.out.println(text1.isEmpty());
System.out.println(text4.isEmpty());	

//join()
String new1 = String.join(" + ", "one", "two", "three");   
System.out.println(new1);

//lastIndexOf
System.out.println(text2.lastIndexOf("World"));

//length
System.out.println(text1.length());

//replace
System.out.println(text2.replace("World", "Java"));

//replaceAll
System.out.println(text3.replaceAll(" ", "  "));

//split
String str = "Shawn Biju Thomas";
String[] arrOfStr = str.split(" ");

System.out.println(Arrays.toString(arrOfStr));

System.out.println(text2.startsWith("n"));

String s1 = text2.substring(1, 6);
System.out.println("Substring: " + s1);

System.out.println(text2.toCharArray());

System.out.println(text1.toLowerCase());
System.out.println(text1.toUpperCase());

System.out.println(text3.trim());

String s6 = String.valueOf(30);
System.out.println(s1 + s6);

}
}
