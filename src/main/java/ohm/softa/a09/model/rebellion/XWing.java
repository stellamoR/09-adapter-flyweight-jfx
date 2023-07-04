package ohm.softa.a09.model.rebellion;

import ohm.softa.a09.model.Fighter;
import ohm.softa.a09.model.Force;
import ohm.softa.a09.model.*;
import javafx.scene.image.Image;

public class XWing extends Fighter {

	public XWing(String pilot, ImgWrapper fighterImage) {
		super(pilot, fighterImage);
	}

	@Override
	public Force getSideOfForce() {
		return Force.LightSide;
	}

	@Override
	public String getFighterType() {
		return "X-Wing";
	}
}
