import java.util.UUID;

public class Person {

	private UUID id;
	private String name;
	private String email;

	private Person(String name, String email) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public  class  Factories{
		public static Person Create(String name, String email){
			return  new Person(name, email);
		}

	}

}
