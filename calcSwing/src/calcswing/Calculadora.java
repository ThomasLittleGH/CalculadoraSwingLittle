package calcswing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class Calculadora extends JFrame implements ActionListener, KeyListener {

    // Definicion de variables
    JPanel panelBoton, panelText;
    private static final int COLUMNAS = 4;
    private static final int FILAS = 4;
    JTextArea text;
    int num = 0, aux = -12345, count = 0, countTotal = 0;
    String result = "", numText = "", blob = "";
    char[] array;
    char sym = 'o';
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bC, bEqual, bDivision, bMult, bSubstraction, bSum;

    public Calculadora() {
        // Inicio los contenedores
        initPanel();
        initText();
        initButtons();

    }

    private void initPanel() {
        // Instancian los paneles y les doy atributos
        panelBoton = new JPanel();
        panelText = new JPanel();
        panelText.setBounds(0, 0, 400, 100);
        panelText.setBackground(Color.black);
        panelBoton.setBounds(0, 100, 400, 500);
        panelBoton.setBackground(Color.green);
        // Le asigno el gridlayout a los paneles
        GridLayout layout = new GridLayout(FILAS, COLUMNAS);
        panelBoton.setLayout(layout);
        panelText.setLayout(new GridLayout(1, 0));
        // Agrego los paneles al JPanel
        this.add(panelText);
        this.add(panelBoton);
    }

    private void initText() {
        // Inicializo los contenedores de texto y le asigno atributos
        text = new JTextArea();
        text.setBackground(Color.gray);
        text.setForeground(Color.white);
        Font font = new Font("Comic Sans MS", Font.ITALIC, 50);
        text.setFont(font);
        // Agrego el JText area al panel y le bloqueo al usuario la capacidad de escribir sin keyListener
        panelText.add(text);
        text.setFocusable(false);
    }

    private void initButtons() {
        // Se instancian los botones
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bC = new JButton("C");
        bEqual = new JButton("=");
        bDivision = new JButton("/");
        bMult = new JButton("*");
        bSubstraction = new JButton("-");
        bSum = new JButton("+");
        // Se le dice al ActionListener que 'escuche' cuando se presiona un boton
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bC.addActionListener(this);
        bEqual.addActionListener(this);
        bDivision.addActionListener(this);
        bMult.addActionListener(this);
        bSubstraction.addActionListener(this);
        bSum.addActionListener(this);
        // le asigno Key Listener a los botones
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b4.addKeyListener(this);
        b5.addKeyListener(this);
        b6.addKeyListener(this);
        b7.addKeyListener(this);
        b8.addKeyListener(this);
        b9.addKeyListener(this);
        b0.addKeyListener(this);
        bC.addKeyListener(this);
        bEqual.addKeyListener(this);
        bDivision.addKeyListener(this);
        bMult.addKeyListener(this);
        bSubstraction.addKeyListener(this);
        bSum.addKeyListener(this);
        // Anado al panel los botones
        panelBoton.add(b7);
        panelBoton.add(b8);
        panelBoton.add(b9);
        panelBoton.add(bDivision);
        panelBoton.add(b4);
        panelBoton.add(b5);
        panelBoton.add(b6);
        panelBoton.add(bMult);
        panelBoton.add(b1);
        panelBoton.add(b2);
        panelBoton.add(b3);
        panelBoton.add(bSubstraction);
        panelBoton.add(b0);
        panelBoton.add(bEqual);
        panelBoton.add(bC);
        panelBoton.add(bSum);
    }

    public static void main(String[] args) throws Exception {
        Calculadora ventana = new Calculadora(); // Se instancia un objeto tipo formulario
        ventana.setTitle("Calculadora");
        ventana.setLocationRelativeTo(null); // Centra en pantalla el formulario
        ventana.setSize(400, 620);
        ventana.setResizable(false);
        ventana.setLayout(null); // Define el tipo de contenedor a utilizar
        ventana.setVisible(true); // El formulario se hace visible
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public int calculate(int num1, int num2, char _operation) {
        // Metodo que identifica la operacion y la realiza
        int ress = 0;
        if (_operation == '+') {
            ress = (num1 + num2);
        }
        if (_operation == '-') {
            ress = (num1 - num2);
        }
        if (_operation == 'x' || _operation == '*') {
            ress = (num1 * num2);
        }
        if (_operation == '/') {
            ress = (num1 / num2);
        }

        return ress;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Metodo que identifica cuando un boton ha sido presionado y añade el caracter correspondiente al JTextArea
        if (e.getSource() == b0) {
            result = result + "0";
            text.setText(result);
        }
        if (e.getSource() == b1) {
            result = result + "1";
            text.setText(result);
        }
        if (e.getSource() == b2) {
            result = result + "2";
            text.setText(result);
        }
        if (e.getSource() == b3) {
            result = result + "3";
            text.setText(result);
        }
        if (e.getSource() == b4) {
            result = result + "4";
            text.setText(result);
        }
        if (e.getSource() == b5) {
            result = result + "5";
            text.setText(result);
        }
        if (e.getSource() == b6) {
            result = result + "6";
            text.setText(result);
        }
        if (e.getSource() == b7) {
            result = result + "7";
            text.setText(result);
        }
        if (e.getSource() == b8) {
            result = result + "8";
            text.setText(result);
        }
        if (e.getSource() == b9) {
            result = result + "9";
            text.setText(result);
        }
        if (e.getSource() == bC) {
            result = "";
            text.setText(result);
        }
        if (e.getSource() == bEqual) {
            calcular();
        }
        if (e.getSource() == bDivision) {
            result = result + "/";
            text.setText(result);
        }
        if (e.getSource() == bMult) {
            result = result + "x";
            text.setText(result);
        }
        if (e.getSource() == bSum) {
            result = result + "+";
            text.setText(result);
        }
        if (e.getSource() == bSubstraction) {
            result = result + "-";
            text.setText(result);
        }

    }

    private void calcular() throws NumberFormatException {
        // Metodo dedicado a separar las ecuaciones en porciones digeribles paraluego ser calculadas
        countTotal = result.length();
        array = result.toCharArray();
        for (char n : array) {
            // Pregunto si el character ingresado es una operacion o no
            if (n == '+' || n == '-' || n == 'x' || n == '/' || n == '*') {
                if (aux == -12345) {
                    aux = Integer.parseInt(numText);
                    numText = "";
                }

                if (sym == 'o') {
                    sym = n;
                } else {
                    if (num == 0) {
                        num = Integer.parseInt(numText);
                        numText = "";
                    }
                    num = calculate(num, aux, sym);
                    aux = -12345;
                    sym = n;

                }
            } else {
                numText = numText + Character.toString(n);
            }
            // Contador para saber si termine de procesar la operacion
            count = count + 1;
            
            if (count == countTotal) {
                if (num > 0) {
                    num = calculate(num, Integer.parseInt(numText), sym);

                } else {
                    num = calculate(Integer.parseInt(numText), aux, sym);
                }
                // reestablesco el valor de las variables
                text.setText("" + num);
                num = 0;
                aux = -12345;
                count = 0;
                result = "";
                numText = "";
                sym = '0';
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Al apretarse una tecla la añado al JTextArea y a la ecuacion (guardada en la variable result)
        blob = Character.toString(e.getKeyChar());
        if (e.getKeyChar() == '=') {
            calcular();
        } else {
            // reviso si la tecla apretada es un igua, la c, o un numero y el programa actua acorde
            if (e.getKeyChar() == 'c') {
                result = "";
                text.setText(result);
            } else {

                result = result + blob;
                text.setText(result);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
