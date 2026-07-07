package exercise_2;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document (.pdf)...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document.");
    }
}