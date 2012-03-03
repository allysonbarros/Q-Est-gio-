package helpers;

import java.util.Arrays;
import java.util.List;

public class DadosHelper {
	public static List<String> getEstadosBrasileiros(){
		String[] estados = new String[] {"RN","AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		return Arrays.asList(estados);
	}
}
