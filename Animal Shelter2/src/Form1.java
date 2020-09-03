import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class Form1 {
    private JTabbedPane List;
    private JComboBox cmbSpecies;
    private JTextField txtAnimalName;
    private JRadioButton rdoMale;
    private JRadioButton rdoFemale;
    private JTextField txtBadHabits;
    private JButton btnAddAnimal;
    private JTextField txtReservor;
    private JButton btnReserve;
    private JPanel jpanel;
    private JPanel panel;
    private JList lstAnimals;
    private JPanel Animals;
    private JLabel llblBadHabits;
    private JTabbedPane Webshop;
    private JTabbedPane Product;
    private JTextField txtProdName;
    private JSpinner spnPrice;
    private JButton btnAddProd;
    private JList lstProducts;
    private JButton btnDeleteProduct;
    private JButton btnDeleteAnimal;

    private Reservation reservations = new Reservation();

    private Webshop webshop = new Webshop();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form1");
        frame.setContentPane(new Form1().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void RefreshAnimals(){
        lstAnimals.removeAll();
        lstAnimals.setListData(reservations.Animals().toArray());
        if(lstAnimals.getSelectedValue() != null) { btnDeleteAnimal.setEnabled(true);} else { btnDeleteAnimal.setEnabled(false);};
        if(lstAnimals.getSelectedValue() != null) { btnReserve.setEnabled(true);} else { btnReserve.setEnabled(false);};
    }

    private void RefreshProducts()
    {
        lstProducts.removeAll();
        lstProducts.setListData(webshop.Products().toArray());
        if(lstProducts.getSelectedValue() != null) { btnDeleteProduct.setEnabled(true);} else { btnDeleteProduct.setEnabled(false);};
    }

    public Form1() {
        btnAddAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gender gender = rdoMale.isSelected() ? Gender.MALE : Gender.FEMALE;

                if (cmbSpecies.getSelectedItem().equals("Cat"))
                {
                    reservations.NewCat(
                            txtAnimalName.getText(), gender, txtBadHabits.getText());
                }
                else if (cmbSpecies.getSelectedItem().equals("Dog"))
                {
                    reservations.NewDog(txtAnimalName.getText(), gender);
                }

                RefreshAnimals();
            }
        });


        lstAnimals.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Animal a = (Animal) lstAnimals.getSelectedValue();

                if (lstAnimals.getSelectedValue() != null) {
                    if(a.IsReserved() == false) {
                        btnReserve.setEnabled(true);
                        btnDeleteAnimal.setEnabled(true);
                    }
                } else {
                    btnReserve.setEnabled(false);
                    btnDeleteAnimal.setEnabled(false);
                }
            }
        });

        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal animal = (Animal) lstAnimals.getSelectedValue();

                if (animal != null)
                {
                    animal.Reserve(txtReservor.getText());
                    RefreshAnimals();
                }
            }
        });

        cmbSpecies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbSpecies.getSelectedItem().equals("Dog")){
                    txtBadHabits.setEnabled(false);
                } else if (cmbSpecies.getSelectedItem().equals("Cat")){
                    txtBadHabits.setEnabled(true);
                }
            }
        });

        btnAddProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                webshop.NewProduct((Integer) spnPrice.getValue(), txtProdName.getText());

                RefreshProducts();
            }
        });

        lstProducts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Product p = (Product) lstProducts.getSelectedValue();

                if (lstProducts.getSelectedValue() != null) {
                        btnDeleteProduct.setEnabled(true);
                } else {
                    btnDeleteProduct.setEnabled(false);
                }
            }
        });

        btnDeleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p = (Product) lstProducts.getSelectedValue();
                webshop.RemoveProducts(p);
                RefreshProducts();
            }
        });

        btnDeleteAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal a= (Animal) lstAnimals.getSelectedValue();
                reservations.RemoveAnimal(a);
                RefreshAnimals();
            }
        });
    }
}
