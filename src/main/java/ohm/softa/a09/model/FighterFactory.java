package ohm.softa.a09.model;

import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;
import ohm.softa.a09.resource.ResourceLoader;
import ohm.softa.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;
	private final ResourceLoader<Image> imageResourceLoader;
	private Map<Integer, ImgWrapper> alreadyLoaded = new HashMap<>();

	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		imageResourceLoader = new ResourceLoader<>(Image::new);
	}

	/**
	 * Create a random Fighter
	 *
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 * @return a new Fighter instance
	 */
	public Fighter createFighter() {
		Integer rand = random.nextInt(NumberOfKnownFighterTypes);
		if(alreadyLoaded.containsKey(rand)){
			switch (rand) {
				case 0:
					return new AWing(nameGenerator.generateName(), alreadyLoaded.get(rand));
				case 1:
					return new XWing(nameGenerator.generateName(), alreadyLoaded.get(rand));
				case 2:
					return new YWing(nameGenerator.generateName(), alreadyLoaded.get(rand));
				case 3:
					return new TieBomber(nameGenerator.generateName(), alreadyLoaded.get(rand));
				case 4:
					return new TieFighter(nameGenerator.generateName(), alreadyLoaded.get(rand));
				default:
					return new TieInterceptor(nameGenerator.generateName(), alreadyLoaded.get(rand));
			}


		}
		ImgWrapper newImageWrapper;
		FxImageLoaderAdapter ldr = new FxImageLoaderAdapter();
		switch (rand) {
			case 0:
				newImageWrapper = new ImgWrapper(imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/awing.jpg"));
				alreadyLoaded.put(rand, newImageWrapper);
				return new AWing(nameGenerator.generateName(),newImageWrapper);
			case 1:
				newImageWrapper = new ImgWrapper(ldr.loadImage("fighter/xwing.jpg"));
				alreadyLoaded.put(rand, newImageWrapper);
				return new XWing(nameGenerator.generateName(),newImageWrapper);
			case 2:
				newImageWrapper = new ImgWrapper(ldr.loadImage("fighter/ywing.jpg"));
				alreadyLoaded.put(rand, newImageWrapper);
				return new YWing(nameGenerator.generateName(), newImageWrapper);
			case 3:
				newImageWrapper =  new ImgWrapper(ldr.loadImage( "fighter/tiebomber.jpg"));
				alreadyLoaded.put(rand, newImageWrapper);
				return new TieBomber(nameGenerator.generateName(), newImageWrapper);
			case 4:
				newImageWrapper = new ImgWrapper(ldr.loadImage("fighter/tiefighter.jpg"));
				alreadyLoaded.put(rand, newImageWrapper);
				return new TieFighter(nameGenerator.generateName(), newImageWrapper );
			default:
				newImageWrapper =  new ImgWrapper(ldr.loadImage( "fighter/tieinterceptor.jpg"));
				alreadyLoaded.put(rand, newImageWrapper);
				return new TieInterceptor(nameGenerator.generateName(),newImageWrapper);
		}
	}
}
