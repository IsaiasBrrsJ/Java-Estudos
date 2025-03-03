import java.util.Scanner;
import java.util.UUID;

public class Turma {

	private  UUID id;
    private int codigo;
	private String turma;
	private  int capacidade;

	private Turma(
			int codigo,
			String turma,
			int capacidade)
	{
		id = UUID.randomUUID();
		this.codigo = codigo;
		this.turma = turma;
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return "Turma{" +
				"id=" + id +
				", codigo=" + codigo +
				", turma='" + turma + '\'' +
				", capacidade=" + capacidade +
				'}';
	}

	public  void Update(Turma turma){
		this.capacidade = turma.capacidade;
		this.turma = turma.turma;
		this.codigo = turma.codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	public String getTurma() {
		return turma;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public static  class  Factories{
		 public static  Turma Create(){

			 var scanner = new Scanner(System.in);
			 int codigo;
			 String turma;
			 int capacidade;

			 System.out.print("Codigo: ");
			 codigo = scanner.nextInt();
			 System.out.print("");
			 System.out.print("Turma: ");
			 turma = scanner.next();
			 System.out.print("");
			 System.out.print("Capacidade: ");
			 capacidade = scanner.nextInt();

			return  new Turma(codigo, turma, capacidade);
		}
   }

}

