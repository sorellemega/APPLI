package modele;

public class Sauvegarder {
	Address numeroDeTelephone;
	CodeSecret code;
	Telephone telephone;
	
	public Sauvegarder(Address numeroDeTelephone, CodeSecret code,
			Telephone telephone) {
		super();
		this.numeroDeTelephone = numeroDeTelephone;
		this.code = code;
		this.telephone = telephone;
	}

	public Address getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(Address numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public CodeSecret getCode() {
		return code;
	}

	public void setCode(CodeSecret code) {
		this.code = code;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

}
