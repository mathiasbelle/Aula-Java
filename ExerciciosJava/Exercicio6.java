import java.util.Scanner;

public class Exercicio6{

	public static void main(String[] args){

		Scanner scan= new Scanner(System.in);
		float[] vetor= new float[10];
		float soma=0, media=0, maior=0, menor=0;
		for(int i=0;i<10;i++){
			System.out.print("Digite o "+(i+1)+"º número: ");
			vetor[i]=scan.nextFloat();
			if(i==0){
				menor=maior=vetor[i];
			}else{
				if(vetor[i]<menor)
					menor=vetor[i];
				if(vetor[i]>maior)
					maior=vetor[i];
			}
			soma+=vetor[i];
			media+=vetor[i];

		}
		media/=10;
		System.out.println("\nRESULTADOS\n");
		System.out.print("A soma dos números é "+soma+"\nA média dos números é "+media+
			"\nO maior número é "+maior+"\nO menor número é "+menor+"\n");

	}

}
