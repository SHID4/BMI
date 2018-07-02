import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyApp extends JFrame implements ActionListener {
    private JRadioButton male, female; // 男性女性のラジオボタン
    private JLabel height, weight;// 身長体重
    private JLabel bmi, idealWeight;// bmi, 理想体重
    private JTextField tHeight, tWeight; // 身長体重に関するテキスト
    private ButtonGroup g;
    private JButton okButton;
    private Panel genderPanel, infoPanel;

    public MyApp() {

        okButton = new JButton("OK");
        infoPanel = new Panel();
        genderPanel = new Panel();

        // 男女識別のラジオボタン
        male = new JRadioButton("男");
        female = new JRadioButton("女");

        // 身長,体重,BMI,理想体重のラベルを設定
        height = new JLabel("身長(cm)");
        weight = new JLabel("体重(kg)");
        bmi = new JLabel();
        idealWeight = new JLabel();

        // 身長と体重の記入欄
        tHeight = new JTextField();
        tWeight = new JTextField();
        tHeight.setColumns(5);
        tWeight.setColumns(5);

        g = new ButtonGroup();
        g.add(male);
        g.add(female);

        // 指定されたレイアウトにするためにパネルでレイアウト調整
        genderPanel.setLayout(new FlowLayout());
        genderPanel.add(male);
        genderPanel.add(female);

        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(height);
        infoPanel.add(tHeight);
        infoPanel.add(weight);
        infoPanel.add(tWeight);

        // 5行１列のレイアウト
        Container c = getContentPane();
        c.setLayout(new GridLayout(5, 1));
        c.add(infoPanel);
        c.add(genderPanel);
        c.add(okButton);
        c.add(bmi);
        c.add(idealWeight);

        okButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        double _height = Double.parseDouble(tHeight.getText()) / 100.0;// mに直して取得
        double _weight = Double.parseDouble(tWeight.getText());

        bmi.setText("あなたのBMIは" + Math.round(_weight / (_height * _height)) + "です");

        // 男性か女性かによって理想体重を変える
        if (male.isSelected() == true)
            idealWeight.setText("あなたの理想体重は" + Math.round(_height * _height * 21.5) + "kgです");
        if (female.isSelected() == true)
            idealWeight.setText("あなたの理想体重は" + Math.round(_height * _height * 19.0) + "kgです");

    }
}

class Main {
    public static void main(String[] args) {
        MyApp a = new MyApp();

        a.setTitle("BMI Calculator");
        a.setSize(300, 200);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
}
