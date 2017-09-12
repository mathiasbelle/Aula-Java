import java.util.Scanner;

public class Exercicio7{

	public static void main(String[] arg){

		String nome, situacao="Reprovado";
		float media=0;

		Scanner scan= new Scanner(System.in);
		System.out.print("Digite o nome do aluno: ");
		nome=scan.next();
		System.out.print("Digite a nota da M1: ");
		media+=scan.nextFloat();
		System.out.print("Digite a nota da M2: ");
		media+=scan.nextFloat();
		System.out.print("Digite a nota da M3: ");
		media+=scan.nextFloat();

		media/=3;
		if(media >= 5.75)
			situacao="Aprovado";
		System.out.println("Nome: "+nome+"\nMédia: "+media+"\nSituação: "+situacao);

	}

}
