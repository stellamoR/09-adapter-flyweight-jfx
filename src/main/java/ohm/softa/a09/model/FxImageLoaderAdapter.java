package ohm.softa.a09.model;

import javafx.scene.image.Image;
import ohm.softa.a09.resource.ResourceLoader;

public class FxImageLoaderAdapter {
	ResourceLoader<Image> resLoad = new ResourceLoader<>(Image::new);


	public Image loadImage(String path){
		return resLoad.loadResource(ClassLoader.getSystemClassLoader(), path);
	}
	public Image loadImage(ClassLoader cL, String path){
		return resLoad.loadResource(cL, path);
	}
}
