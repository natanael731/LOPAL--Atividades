package EstruturasCondicionais;

public class booleanteste {

	public static void main(String[] args) {
		
		int idade = 20;
		boolean TemConvite = true;
		
		
		if(idade >= 18 && TemConvite) {
			System.out.println("Você pode participar do evento!");
			
		} else if(idade <-18) {
			System.out.println("Você precisa ter 18 anos ou mais para participar do evento");
			
		} else {
			System.out.println("Você não tem um convite válido!");
		}
	}

}
