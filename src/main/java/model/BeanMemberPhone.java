package model;

// Entidade criada para  recuperar as informações do DB das duas tabelas através do InnerJoin.
public class BeanMemberPhone {
	
	private String nameMember;
	private String email;
	private String typePhone;
	private String numberPhone;
	private String dateOfBirth;
	private String fatherName;
	private String motherName;
	
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
	public String getTypePhone() {
		return typePhone;
	}
	public void setTypePhone(String typePhone) {
		this.typePhone = typePhone;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
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
		return "BeanMemberPhone [nameMember=" + nameMember + ", email=" + email + ", typePhone=" + typePhone
				+ ", numberPhone=" + numberPhone + ", dateOfBirth=" + dateOfBirth + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + "]";
	}

	
	
	
	
}
