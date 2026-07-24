package exercise_2;

public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();

    // Factories can also contain business logic that relies on the product
    public void generateDocument() {
        Document doc = createDocument();
        doc.open();
        // Additional processing could happen here
    }
}