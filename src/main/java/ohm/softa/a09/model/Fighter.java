package ohm.softa.a09.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javafx.scene.image.Image;

/**
 * @author Peter Kurfer
 */

public abstract class Fighter {

	private final String pilot;
	private final ImgWrapper imgWrapper;

	public Fighter(String pilot,ImgWrapper imgWrapper) {
		this.pilot = pilot;
		this.imgWrapper = imgWrapper;
	}

	public String getPilot() {
		return pilot;
	}

	public Image getFighterImage() {
		return imgWrapper.getImage();
	}

	public abstract Force getSideOfForce();

	public abstract String getFighterType();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Fighter)) return false;

		Fighter fighter = (Fighter) o;

		return new EqualsBuilder()
			.append(getPilot(), fighter.getPilot())
			.append(getFighterType(), fighter.getFighterType())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getPilot())
			.append(getFighterType())
			.toHashCode();
	}
}
