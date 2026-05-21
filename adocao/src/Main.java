import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

void main() {

    JFrame tela = new JFrame("Tela de Cadastro");
    tela.setSize(500, 600);
    tela.setLayout(null);

    JLabel labelNome = new JLabel("Nome");
    labelNome.setBounds(20, 30, 250, 30);
    tela.add(labelNome);

    JTextField nome = new JTextField();
    nome.setBounds(20, 60, 250, 30);
    tela.add(nome);

    JLabel labelIdade = new JLabel("Idade");
    labelIdade.setBounds(20, 100, 250, 30);
    tela.add(labelIdade);

    JTextField idade = new JTextField();
    idade.setBounds(20, 130, 250, 30);
    tela.add(idade);

    JLabel labeltipo = new JLabel("Tipo");
    labeltipo.setBounds(20, 170, 250, 30);
    tela.add(labeltipo);

    JComboBox escolhaTipo = new JComboBox(Tipo.values());
    escolhaTipo.setBounds(20, 200, 350, 30);
    tela.add(escolhaTipo);

    JLabel labelRaca = new JLabel("Raça");
    labelRaca.setBounds(20, 240, 250, 30);
    tela.add(labelRaca);

    JTextField raca = new JTextField();
    raca.setBounds(20, 270, 250, 30);
    tela.add(raca);

    JLabel labelEndereco = new JLabel("Endereço");
    labelEndereco.setBounds(20, 310, 250, 30);
    tela.add(labelEndereco);

    JTextField endereco = new JTextField();
    endereco.setBounds(20, 340, 250, 30);
    tela.add(endereco);

    JLabel labelTelefone = new JLabel("Telefone");
    labelTelefone.setBounds(20, 380, 250, 30);
    tela.add(labelTelefone);

    JTextField telefone = new JTextField();
    telefone.setBounds(20, 410, 250, 30);
    tela.add(telefone);

    JButton enviar = new JButton("Enviar");
    enviar.setBounds(70, 450, 150, 40);
    tela.add(enviar);

    enviar.addActionListener(event -> {
        String sql = "INSERT INTO adocao(nome, idade, tipo, raca, endereco, telefone) VALUES (?, ?, ?, ?, ?,?)";
        String nomeCompleto = nome.getText();
        String idadeAnimal = idade.getText();
        String enderecoTexto = endereco.getText();
        String telefoneTexto = telefone.getText();
        Tipo tipos = (Tipo) escolhaTipo.getSelectedItem();
        String racaText = raca.getText();

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nomeCompleto);
            ps.setString(2, idadeAnimal);;
            ps.setString(3, tipos.name());
            ps.setString(4, raca.getText());
            ps.setString(5, enderecoTexto);
            ps.setString(6, telefoneTexto);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario calvo com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    });

    tela.setVisible(true);
}