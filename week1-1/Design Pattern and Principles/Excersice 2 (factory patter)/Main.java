public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

// Interface
interface Document {
    
    void open();
}

// Concrete Document Classes
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }
}

// Abstract Factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete Factories
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
