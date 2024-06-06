package _008_Generics._01_Lab._01_Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(13);
        int removed = jar.remove();
        System.out.println(removed);
    }
}
