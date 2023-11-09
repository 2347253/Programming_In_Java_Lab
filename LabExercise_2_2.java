public class LabExercise_2_2
{
public static void main(String args[])
    {
    StringBuffer sb=new StringBuffer("Good Morning to Everybody Present here");  
    sb.append(", Today we will learn java");
    sb.insert(0, "->");
    System.out.println(sb);
    sb.replace(7, 14, "Afternoon");
    System.out.println(sb);
    sb.delete(0, 6);
    System.out.println(sb);
    char s=sb.charAt(2);
    System.out.println(s);

    
    sb.setCharAt(0, '+');
    System.out.println(sb);

    int m=sb.length();
    System.out.println(m);

    System.out.println(sb.capacity());
    sb.ensureCapacity(40);
    System.out.println(sb.capacity());
    
    String sp = sb.toString();
    System.out.println(sp);

    String k=sb.substring(24);
    System.out.println(k);
    String l=sb.substring(1,23);
    System.out.println(l);
      

    }
}
