import org.mariuszgromada.math.mxparser.Expression;
import javax.swing.*;
import java.awt.event.*;
import java.text.MessageFormat;
import java.util.HashMap;

public class Form extends JFrame{

    private JButton evalButton;
    private JList<String> functionsList;
    private JMenu options;
    private JMenuBar menuBar;
    private JMenuItem reset;
    private JMenuItem exit;
    private javax.swing.JScrollPane scrollContainerPane;
    private javax.swing.JScrollPane scrollFunctionsList;
    private javax.swing.JScrollPane scrollTextArea;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private String lastOne;
    private String lastResult;
    private HashMap<Integer, String> functions;

    private Double calculate() throws Exception{
        Expression expression = new Expression(formulaInput.getText());
        if (expression.checkSyntax()) {
            return expression.calculate();
        } else {
            String errorMessage = expression.getErrorMessage();
            throw new Exception("ERROR: " +errorMessage);
        }
    }

    public void evaluate(){
        try {
            String result = MessageFormat.format(
                    "{0} = {1} \n", formulaInput.getText(),calculate());
            historyTextArea.append(result);
            String [] tab=result.split("=");
            lastResult=tab[1].replace(",",".");

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Invalid argument" , "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        lastOne = formulaInput.getText();
        formulaInput.setText("");
    }

    public Form() {

        formulaInput = new JTextField();
        evalButton = new JButton();
        scrollFunctionsList = new JScrollPane();
        functionsList = new JList<>();
        scrollTextArea = new JScrollPane();
        scrollContainerPane = new JScrollPane();
        historyTextArea = new JTextArea();
        menuBar = new JMenuBar();
        options = new JMenu();
        reset = new JMenuItem();
        exit = new JMenuItem();

        setTitle("SciCalcu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ADDING MENU:
        options.setText("Options");
        reset.setText("Reset");
        exit.setText("Exit");
        options.add(reset);
        options.add(exit);
        menuBar.add(options);
        setJMenuBar(menuBar);

        //LISTENERS:
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if(source==reset){
                    historyTextArea.setText("");
                    formulaInput.setText("");
                }

            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if(source==exit){
                    System.exit(0);
                }

            }
        });

        formulaInput.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    evaluate();
                }
                else if(evt.getKeyCode() == KeyEvent.VK_UP){
                    formulaInput.setText(lastOne);
                }
            }
        });

        evalButton.setText("Evaluate!");
        evalButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                evaluate();
            }
        });

        functionsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int index = functionsList.getSelectedIndex();
                String functionName = functions.get(index);
                if(!functionName.equals("Last")) {
                    formulaInput.setText(functionName);
                }
                else{
                    formulaInput.setText(lastResult);

                }
                functionsList.clearSelection();
                formulaInput.requestFocus();
                if (index < 6) {
                    formulaInput.setCaretPosition(formulaInput.getCaretPosition() - 1);
                }
            }
        });
        //HISTORY TEXT AREA:
        scrollFunctionsList.setViewportView(functionsList);
        historyTextArea.setColumns(20);
        historyTextArea.setRows(5);
        historyTextArea.setEditable(false);
        scrollContainerPane.setViewportView(historyTextArea);
        scrollTextArea.setViewportView(scrollContainerPane);


        //LAYOUT SETTINGS:
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollTextArea, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                        .addComponent(formulaInput))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(evalButton, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(scrollFunctionsList))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollFunctionsList, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addComponent(scrollTextArea))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(formulaInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(evalButton))
                                .addContainerGap())
        );
        pack();

        //FUNCTIONS:
        functions = new HashMap<>();
        functions.put(0,"sin()");
        functions.put(1,"cos()");
        functions.put(2,"tg()");
        functions.put(3,"log()");
        functions.put(4,"mod()");
        functions.put(5,"Euler()");
        functions.put(6,"pi");
        functions.put(7,"e");
        functions.put(8,"[phi]");
        functions.put(9,"Last");

        //FUNCTIONS MENU:
        DefaultListModel model = new DefaultListModel();
        model.addElement("Sinus");
        model.addElement("Cosinus");
        model.addElement("Tangens");
        model.addElement("Logarithm");
        model.addElement("Modulo");
        model.addElement("Euler");
        model.addElement("PI");
        model.addElement("E");
        model.addElement("Golden Ratio");
        model.addElement("Last Result");
        functionsList.setModel(model);
    }

}
