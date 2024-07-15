import java.util.Stack;

public class ArbolExpresion {
    private Nodo raiz;

    public ArbolExpresion(String expresionPosfija) {
        raiz = construirArbolExpresion(expresionPosfija);
    }

    private Nodo construirArbolExpresion(String expresionPosfija) {
        Stack<Nodo> pila = new Stack<>();

        for (String token : expresionPosfija.split(" ")) {
            if (esOperador(token)) {
                Nodo operador = new Nodo(token);
                operador.derecho = pila.pop();
                operador.izquierdo = pila.pop();
                pila.push(operador);
            } else {
                Nodo numero = new Nodo(token);
                pila.push(numero);
            }
        }

        return pila.pop();
    }

    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int resolver() {
        return resolverRecursivo(raiz);
    }

    private int resolverRecursivo(Nodo nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("El árbol de expresión es inválido");
        }

        if (esNumero(nodo.valor)) {
            return Integer.parseInt(nodo.valor);
        } else {
            int izquierdo = resolverRecursivo(nodo.izquierdo);
            int derecho = resolverRecursivo(nodo.derecho);

            switch (nodo.valor) {
                case "+":
                    return izquierdo + derecho;
                case "-":
                    return izquierdo - derecho;
                case "*":
                    return izquierdo * derecho;
                case "/":
                    return izquierdo / derecho;
                default:
                    throw new IllegalArgumentException("Operador inválido: " + nodo.valor);
            }
        }
    }

    private boolean esNumero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
