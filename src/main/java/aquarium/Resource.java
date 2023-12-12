package aquarium;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class Resource {

    protected int width;
    protected int height;

    public ImageView imageView;

    public Resource(int width, int height) {
        this.width = width;
        this.height = height;
        this.imageView = getImageView();
    }

    abstract protected String getFileName();

    private ImageView getImageView() {
        Image image = new Image(getClass().getResourceAsStream("/"+getFileName()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(this.width);
        imageView.setFitHeight(this.height);

        return imageView;
    }
}
