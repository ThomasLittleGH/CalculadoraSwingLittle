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

public class Calculadora extends JFrame implements ActionListener {
    private JPanel panBut, panOut;
    private static final int COLUMNAS = 4;
    private static final int FILAS = 4;
    private JTextArea text;
    private int num = 0, aux = -12345, count = 0, countTotal = 0;
    private String result = "", numText = "";
    private char[] array;
    private char sym = 'o';
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bC, bEqual, bDivision, bMult, bSubstraction, bSum;

    public Calculadora() {
        initPanel();
        initText();
        initButtons();
        // hola
    }

    private void initPanel() {
        panBut = new JPanel();
        panOut = new JPanel();
        panOut.setBounds(0, 0, 400, 100);
        panOut.setBackground(Color.black);
        panBut.setBounds(0, 100, 400, 500);
        panBut.setBackground(Color.red);
        GridLayout layout = new GridLayout(FILAS, COLUMNAS);
        panBut.setLayout(layout);        
        panOut.setLayout(new GridLayout(1, 0));
        this.add(panOut);
        this.add(panBut);
    }

    private void initText() {
        text = new JTextArea();
        text.setBackground(Color.gray);
        text.setForeground(Color.white);
        Font font = new Font("Comic Sans MS", Font.ITALIC, 50);
        text.setFont(font);
        panOut.add(text);
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
        // Anado al panel
         panBut.add(b7);
         panBut.add(b8);
         panBut.add(b9);
         panBut.add(bDivision);
         panBut.add(b4);
         panBut.add(b5);
         panBut.add(b6);
         panBut.add(bMult);
         panBut.add(b1);
         panBut.add(b2);
         panBut.add(b3);
         panBut.add(bSubstraction);
         panBut.add(b0);
         panBut.add(bEqual);
         panBut.add(bC);
         panBut.add(bSum);

    }

    public static void main(String[] args) throws Exception {
        Calculadora ventana = new Calculadora(); // Se instancia un objeto tipo formulario
        ventana.setTitle("Calculadora");
        ventana.setLocationRelativeTo(null); // Centra en pantalla el formulario
        ventana.setSize(415, 639);
        ventana.setResizable(false);
        ventana.setLayout(null); // Define el tipo de contenedor a utilizar
        ventana.setVisible(true); // El formulario se hace visible
    }

    public int calculate(int num1, int num2, char _operation) {
        int ress = 0;
        if (_operation == '+') {
            ress = (num1 + num2);
        }
        if (_operation == '-') {
            ress = (num1 - num2);
        }
        if (_operation == 'x') {
            ress = (num1 * num2);
        }
        if (_operation == '/') {
            ress = (num1 / num2);
        }

        return ress;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b0) {
            result = result + "0";
            
        }
        if (e.getSource() == b1) {
            result = result + "1";
            
        }
        if (e.getSource() == b2) {
            result = result + "2";
            
        }
        if (e.getSource() == b3) {
            result = result + "3";
            
        }
        if (e.getSource() == b4) {
            result = result + "4";
            
        }
        if (e.getSource() == b5) {
            result = result + "5";
            
        }
        if (e.getSource() == b6) {
            result = result + "6";
            
        }
        if (e.getSource() == b7) {
            result = result + "7";
            
        }
        if (e.getSource() == b8) {
            result = result + "8";
            
        }
        if (e.getSource() == b9) {
            result = result + "9";
            
        }
        if (e.getSource() == bC) {
            result = "";
            
        }
        if (e.getSource() == bEqual) {
            countTotal = result.length();
            array = result.toCharArray();
            for (char n : array) {
                if (n == '+' || n == '-' || n == 'x' || n == '/') {
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
                }

                else {
                    numText = numText + Character.toString(n);
                }

                count = count + 1;

                if (count == countTotal) {
                    if (num > 0) {
                        num = calculate(num, Integer.parseInt(numText), sym);

                    } else {
                        num = calculate(Integer.parseInt(numText), aux, sym);
                    }
                    text.setText(""+num);
                    num = 0;
                    aux = -12345;
                    count = 0;
                    result = "";
                    numText = "";
                    sym = '0';
                }
            }
        }
        if (e.getSource() == bDivision) {
            result = result + "/";
            
        }
        if (e.getSource() == bMult) {
            result = result + "x";

        }
        if (e.getSource() == bSum) {
            result = result + "+";

        }
        if (e.getSource() == bSubstraction) {
            result = result + "-";

        }
        text.setText(result);
    }
}
