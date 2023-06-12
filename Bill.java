import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bill {
    private JTextField id;
    private JTextField name;
    private JTextField unit;
    private JButton calcuateButton;
    private JTextArea bill;
    private JButton printButton;
    private JPanel billPanel;
    String cid;
    double charge,total;
    int count;
    JFrame frame=new JFrame();
public Bill() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(billPanel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    calcuateButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            cid = id.getText();
            count=Integer.parseInt(unit.getText());

            if(count<500)
            {
                charge=1.00;
            }
            else if(count>500 && count<600)
            {
                charge=1.80;
            }
            else if(count>600 && count<800)
            {
                charge=2.80;
            }
            else {
                charge=2.80;
            }
            total=charge*count;
            print1();
        }
    });
    printButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                bill.print();
            } catch (PrinterException ex)
            {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE,null,ex);
            }

        }
    });
}
public void print1()
{
    String cid= id.getText();
    String cname=name.getText();
    String cunit=unit.getText();

    bill.setText(bill.getText() + "\n");
    bill.setText(bill.getText() + "Electricity Bill" + "\n");
    bill.setText(bill.getText() + "\n");
    bill.setText(bill.getText()+"Customer ID: "+ cid + "\n");
    bill.setText(bill.getText()+"Customer Name: "+ cname + "\n");
    bill.setText(bill.getText()+"Unit: " +cunit + "\n");
    bill.setText(bill.getText()+"Total Amount: "+ total + "\n");


}
}
