import java.util.Stack;

public class Traductor {
    public StringBuilder posfija = new StringBuilder();
    public Traductor(String infija) {
        
        Stack<Character> operador = new Stack<>();

        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);

            if (Character.isDigit(c)) {
                // Reconocer números de más de un dígito
                StringBuilder numero = new StringBuilder();
                numero.append(c);

                // Verificar los siguientes caracteres y agregarlos al número
                while (i + 1 < infija.length() && Character.isDigit(infija.charAt(i + 1))) {
                    numero.append(infija.charAt(i + 1));
                    i++;
                }

                posfija.append(numero).append(" "); // Agregar el número a la expresión posfija
            } else if (esOperador(c)) {
                while (!operador.isEmpty() && obtenerJerarquia(operador.peek(), c)) {
                    posfija.append(operador.pop()).append(" ");
                }
                operador.push(c);
            } else if (c == '(') {
                operador.push(c);
            } else if (c == ')') {
                while (!operador.isEmpty() && operador.peek() != '(') {
                    posfija.append(operador.pop()).append(" ");
                }
                operador.pop(); // Descartar el paréntesis de apertura '('
            }
        }

        while (!operador.isEmpty()) {
            posfija.append(operador.pop()).append(" ");
        }

        
    }

    public String getPosfija(){
        return posfija.toString().trim();
    }
    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean obtenerJerarquia(char operador1, char operador2) {
        int primero = darJerarquia(operador1);
        int segundo = darJerarquia(operador2);
        return primero >= segundo;
    }

    private static int darJerarquia(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }


}
