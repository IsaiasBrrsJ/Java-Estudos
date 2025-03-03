import java.util.UUID;

public class Estudante {

	private UUID id;
	private  String name;
	private String cellPhone;
	private String address;
    public String responsible;

	private Estudante(String name, String cellPhone, String address, String responsible) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.cellPhone = cellPhone;
		this.address = address;
		this.responsible = responsible;
	}

	 public void  UpdateCellPhone(String cellPhone){
		this.cellPhone = cellPhone;
 	}
	public String getName() {
		return name;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getAddress() {
		return address;
	}

	public String getResponsible() {
		return responsible;
	}

	@Override
	public String toString() {
		return "Estudante{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cellPhone='" + cellPhone + '\'' +
				", address='" + address + '\'' +
				", responsible='" + responsible + '\'' +
				'}';
	}

	public static class Factories{
		public static  Estudante Create(String name, String cellPhone, String address, String responsible){
			return  new Estudante(name, cellPhone, address, responsible);
		}
	}
}
