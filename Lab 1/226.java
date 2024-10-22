import javax.swing.JOptionPane;

public class Equationroots {
    public static void main(String[] args) {
        String strdegree;
        strdegree = JOptionPane.showInputDialog(null, "Please input the degree: ", JOptionPane.INFORMATION_MESSAGE);
        String NumofVar;
        NumofVar = JOptionPane.showInputDialog(null, "Please input the number of variables: ", JOptionPane.INFORMATION_MESSAGE);
        double degree = Double.parseDouble(strdegree);
        double numofvar = Double.parseDouble(NumofVar);
        if(degree == 1){
            if(numofvar == 1){
                String stra,strb;
                stra = JOptionPane.showInputDialog(null, "Please input a: ", JOptionPane.INFORMATION_MESSAGE);
                strb = JOptionPane.showInputDialog(null, "Please input b: ", JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(stra);
                double b = Double.parseDouble(strb);
                double sol = -b/a;
                JOptionPane.showMessageDialog(null, "The sum is: " + sol,"Solutions" ,JOptionPane.INFORMATION_MESSAGE);
            }
            String strnum1, strnum2, strnum3, strnum4, strnum5, strnum6;
            strnum1 = JOptionPane.showInputDialog(null, "Please input a11: " , JOptionPane.INFORMATION_MESSAGE);
            strnum2 = JOptionPane.showInputDialog(null, "Please input a12: ", JOptionPane.INFORMATION_MESSAGE);
            strnum3 = JOptionPane.showInputDialog(null, "Please input a21: ", JOptionPane.INFORMATION_MESSAGE);
            strnum4 = JOptionPane.showInputDialog(null, "Please input a22: ", JOptionPane.INFORMATION_MESSAGE);
            strnum5 = JOptionPane.showInputDialog(null, "Please input b1: ", JOptionPane.INFORMATION_MESSAGE);
            strnum6 = JOptionPane.showInputDialog(null, "Please input b2: ", JOptionPane.INFORMATION_MESSAGE);

            double a11 = Double.parseDouble(strnum1);
            double a12 = Double.parseDouble(strnum2);
            double a21 = Double.parseDouble(strnum3);
            double a22 = Double.parseDouble(strnum4);
            double b1 = Double.parseDouble(strnum5);
            double b2 = Double.parseDouble(strnum6);

            double D = a11*a22 - a12*a21;
            double D1 = b1*a22 - b2*a12;
            double D2 = a11*b2 - a21*b1;
            if(D == 0){
                if(D1 == 0 && D2 ==0){
                    JOptionPane.showMessageDialog(null, "Infinite solution");
                }
                else{
                    JOptionPane.showMessageDialog(null, "No solution");
                }
            }
            else{
            double sol1 = D1/D;
            double sol2 = D2/D;
            
            JOptionPane.showMessageDialog(null, "x1 is: " + sol1 +"\n" +"x2 is: " + sol2, "Solutions",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            String strnum1, strnum2, strnum3;
            strnum1 = JOptionPane.showInputDialog(null, "Please input a: " , JOptionPane.INFORMATION_MESSAGE);
            strnum2 = JOptionPane.showInputDialog(null, "Please input b: " , JOptionPane.INFORMATION_MESSAGE);
            strnum3 = JOptionPane.showInputDialog(null, "Please input c: " , JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(strnum1);
            double b = Double.parseDouble(strnum2);
            double c = Double.parseDouble(strnum3);
            double delta = Math.pow(b,2) - 4*a*c;
            if(delta < 0){
                JOptionPane.showMessageDialog(null,"No solution");
            }
            else{
                if(delta == 0){
                    double sol = -b /(2*a) ;
                    JOptionPane.showMessageDialog(null, "The solution is: "+sol,"Solution",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    double sol1 = (-b + Math.pow(delta,0.5))/(2*a);
                    double sol2 = (-b - Math.pow(delta,0.5))/(2*a);
                    JOptionPane.showMessageDialog(null, "The first solution is: "+sol1 + "\n" + "The second solution is: "+sol2 ,"Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
