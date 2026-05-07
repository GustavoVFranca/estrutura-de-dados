package EstruturasLineares.Pilha;

public class MetodosPilha {
	
	public static String ReverterStringPilha(String texto) {
		IPilha pilha = new PilhaDinamica();
		for(int i = 0; i < texto.length(); i++) {
			pilha.push((int) texto.charAt(i));
		}
		String resultado = "";
		while(!pilha.vazia()) {
			resultado += (char) pilha.pop();
		}
		return resultado;
	}
	public static String decimalParaBinario(int numero) {
	    IPilha pilha = new PilhaDinamica();

	    if (numero == 0) return "0";
	    while (numero > 0) {
	        int resto = numero % 2;
	        pilha.push(resto);
	        numero = numero / 2;
	    }
	    StringBuilder binario = new StringBuilder();

	    while (!pilha.vazia()) {
	        binario.append(pilha.pop());
	    }

	    return binario.toString();
	}
	public static boolean estaBalanceado(String texto) {
	    IPilha pilha = new PilhaDinamica();

	    for (int i = 0; i < texto.length(); i++) {
	        char c = texto.charAt(i);

	        if (c == '(' || c == '{' || c == '[') {
	            pilha.push((int) c);
	        } else {
	            if (pilha.vazia()) {
	                return false;
	            }

	            char topo = (char) pilha.pop();

	            if ((c == ')' && topo != '(') ||
	                (c == '}' && topo != '{') ||
	                (c == ']' && topo != '[')) {
	                return false;
	            }
	        }
	    }
	    return pilha.vazia();
	}

}
