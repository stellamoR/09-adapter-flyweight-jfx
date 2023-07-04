package ohm.softa.a09.model.rebellion;

import ohm.softa.a09.model.Fighter;
import ohm.softa.a09.model.Force;
import javafx.scene.image.Image;
import ohm.softa.a09.model.ImgWrapper;

public class AWing extends Fighter {

	public AWing(String pilot, ImgWrapper fighterImage) {
		super(pilot, fighterImage);
	}

	@Override
	public Force getSideOfForce() {
		return Force.LightSide;
	}

	@Override
	public String getFighterType() {
		return "A-Wing";
	}
}
