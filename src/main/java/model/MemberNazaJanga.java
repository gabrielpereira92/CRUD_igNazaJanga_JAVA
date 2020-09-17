package model;

public class MemberNazaJanga {

	private Long id;
	private String nameMember;
	private String email;
	private String dateOfBirth;
	private String fatherName;
	private String motherName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameMember() {
		return nameMember;
	}

	public void setNameMember(String nameMember) {
		this.nameMember = nameMember;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "MemberNazaJanga [id=" + id + ", nameMember=" + nameMember + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
	}
	
}
