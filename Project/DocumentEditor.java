import java.util.*;

// Interface for document elements like text or images
interface DocumentElement {
    void render();
}

// Concrete implementation: text element
class TextElement implements DocumentElement {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("[Text] " + text);
    }
}

// Concrete implementation: image element
class ImageElement implements DocumentElement {
    private final String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void render() {
        System.out.println("[Image] " + imagePath);
    }
}

// Document class containing multiple elements
class Document {
    private final String title;
    private final List<DocumentElement> elements;

    public Document(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void render() {
        System.out.println("\n--- Document: " + title + " ---");
        for (DocumentElement element : elements) {
            element.render();
        }
        System.out.println("--- End of Document ---\n");
    }
}

// Interface for persistence strategy
interface PersistentStorage {
    void save(Document document);
}

// File storage simulation
class FileStorage implements PersistentStorage {
    @Override
    public void save(Document document) {
        System.out.println("Saving document '" + document.getTitle() + "' to file system at /docs/" + document.getTitle() + ".txt");
        // Simulate writing to file
    }
}

// Database storage simulation
class DatabaseStorage implements PersistentStorage {
    @Override
    public void save(Document document) {
        String docId = UUID.randomUUID().toString(); // Simulate database ID
        System.out.println("Saving document '" + document.getTitle() + "' to database with ID: " + docId);
        // Simulate writing to DB
    }
}

// Main editor that uses Document and Storage
public class DocumentEditor {
    private final Document document;
    private final PersistentStorage storage;

    public DocumentEditor(String title, PersistentStorage storage) {
        this.document = new Document(title);
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void saveDocument() {
        storage.save(document);
    }

    public void renderDocument() {
        document.render();
    }

    public static void main(String[] args) {
        // Use file storage
        DocumentEditor fileEditor = new DocumentEditor("MyFirstDoc", new FileStorage());
        fileEditor.addText("Welcome to the file-based document.");
        fileEditor.addImage("file_image.png");
        fileEditor.renderDocument();
        fileEditor.saveDocument();

        // Use database storage
        DocumentEditor dbEditor = new DocumentEditor("MyDBDoc", new DatabaseStorage());
        dbEditor.addText("Welcome to the database-based document.");
        dbEditor.addImage("db_image.png");
        dbEditor.renderDocument();
        dbEditor.saveDocument();
    }
}
