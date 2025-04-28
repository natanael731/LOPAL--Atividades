package EstruturasCondicionais;

public class guardachuva {

	public static void main(String[] args) {
		boolean TemGuardaChuva =true;
		boolean EstaChovendo = true;
		
		if (TemGuardaChuva && EstaChovendo) {
			System.out.println("Você pode sair de casa tranquilo!");
			
		} else if (EstaChovendo) {
			System.out.println("Você está sem guarda-chuva");
			
		}else {
			System.out.println("Não está chovendo");
		}

	}

}
