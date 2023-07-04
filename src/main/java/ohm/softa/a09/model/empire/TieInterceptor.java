package ohm.softa.a09.model.empire;

import ohm.softa.a09.model.Fighter;
import ohm.softa.a09.model.Force;
import javafx.scene.image.Image;
import ohm.softa.a09.model.ImgWrapper;

public class TieInterceptor extends Fighter {

	public TieInterceptor(String pilot, ImgWrapper fighterImage) {
		super(pilot, fighterImage);
	}

	@Override
	public Force getSideOfForce() {
		return Force.DarkSide;
	}

	@Override
	public String getFighterType() {
		return "Tie Interceptor";
	}
}
