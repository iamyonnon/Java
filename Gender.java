package entity;

/**
 * @author chinh
 * @version 1.0
 * @created 16-Nov-2021 2:29:26 PM
 */
public enum Gender {
	M("Male"), F("Female");

	private String gender;

	private Gender() {

	}

	private Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
}