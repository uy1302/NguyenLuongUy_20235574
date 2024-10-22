import javax.swing.JOptionPane;
public class Operations {
    public static void main(String[] args) {
        String Num1, Num2;

        Num1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number: ", JOptionPane.INFORMATION_MESSAGE);
        Num2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number: ", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(Num1);
        double num2 = Double.parseDouble(Num2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product  = num1*num2;
        if (num2 == 0){
            JOptionPane.showMessageDialog(null, "Please enter number different from 0");
        }
        else{
            double quotient = num1/num2;
            JOptionPane.showMessageDialog(null, "The sum is: "+sum + "\n" +"The difference is: " + difference + "\n" + "The product is: "+ product + "\n" + "The quotient is: " + quotient, "Operations",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
