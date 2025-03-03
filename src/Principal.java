import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

 public static void main(String[] args) throws InterruptedException {

//	 var conta = new Conta();
//	 var reader = new Scanner(System.in);
//
//	 System.out.print("Informe o valor para sacar: ");
//     var sacar = reader.nextDouble();
//
//	 var isValid = conta
//			 .Sacar(sacar);
//
//	 if(!isValid)
//		 System.out.println("Invalid");
//
//	 var person = Person.Factories.Create("Isaias", "Barros@gmail.com");
//     var personII = Person.Factories.Create("Barros", "isaias@gmail.com");
//	 var list = new ArrayList<Person>();
//
//	 list.add(personII);
//	 list.add(person);
//
//  for(var i :list){
//
//	  System.out.println(i.getId());
//	  System.out.println(i.getEmail());
//	  System.out.println(i.getName());
//	  System.out.println("===========================");
//  }
//	 System.out.println("Cached with success");
	 System.out.println("\t============================");
	 System.out.println("\tWelcome To School System ADM");
	 System.out.println("\t============================");

	 var student = new ArrayList<Estudante>();
	 var turma = new ArrayList<Turma>();
	 var read = new Scanner(System.in);
	 var option =-1;

	 do{

		 System.out.println("\t[ 1 ] - Cadatrar Turma");
		 System.out.println("\t[ 2 ] - Cadatrar Estudante");
		 System.out.println("\t[ 3 ] - Listar Turmas");
		 System.out.println("\t[ 4 ] - Listar Estudantes");
		 System.out.println("\t[ 5 ] - Sair");
		 System.out.print("Opcao: ");
         option = read.nextInt();

		 switch (option){
			 case 1:
				 turma
					 .add(CreateTurma(read));
				 break;
			 case 2:
		 		student
					  .add(CreateStudent(read));
				 break;
			 case 3:
				 ListarCadastros(turma);
				 break;
			 case 4:
				 ListarCadastros(student);
				 break;
			 default:
				 System.out.println("Opção inválida");
				 break;
		 }
		 System.out.println("Clique para prosseguir");
	 	Thread.sleep(220);

	 }while(option != 5);
 }
 public static  <T> void ListarCadastros(ArrayList<T> list){

	 if(!list.isEmpty()) {
		 for (T item : list){
			 System.out.println(item.toString());
		 }
	 }
	 else
		 System.out.println("Lista vazia");
 }
 public  static Turma CreateTurma(Scanner scanner){

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

	 return Turma.Factories.Create(codigo, turma, capacidade);
 }
  public static  Estudante CreateStudent( Scanner scanner){

	  String name;
	  String cellPhone;
	  String address;
	  String responsible;

	  System.out.print("name: ");
	  name = scanner.next();
	  System.out.print("");
	  System.out.print("cellphone: ");
	  cellPhone = scanner.next();
	  System.out.print("");
	  System.out.print("address: ");
	  address = scanner.next();
	  System.out.print("");
	  System.out.print("responsible: ");
	  responsible = scanner.next();
	  System.out.print("");


	  return  Estudante.Factories.Create(name, cellPhone, address, responsible);
  }
}
