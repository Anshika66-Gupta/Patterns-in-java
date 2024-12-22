interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    
    
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();

    }

    private void loadFromDisk() {
        System.out.println("Loading" + filename);
    }
    
    public void display() {
    System.out.println("Display" + filename);   
    }

}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        image.display();
        image.display();
    }
}