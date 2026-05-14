import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

void main() {
    JFrame tela = new JFrame("tela de cadatro ");
    tela.setSize(500,400);
    tela.setLayout(null);

    JLabel labelNome = new JLabel ("Nome");
    labelNome.setBounds(20,50,250,40);
    tela.add(labelNome);

    JTextField nome = new JTextField();
    nome.setBounds(20,80,250,40);
    tela.add(nome);


    JLabel labelEmail = new JLabel ("Email");
    labelEmail.setBounds(20,120,250,40);
    tela.add(labelEmail);

    JTextField email = new JTextField();
    email.setBounds(20,150,250,40);
    tela.add(email);

    JButton enviar = new JButton("enviar");
    enviar.setBounds(70,200,150,40);
    tela.add(enviar);

    enviar.addActionListener(e -> {
        String Sql = "INSERT INTO usuario(nome,email) VALUES (?,?)";
        String nomecompleto = nome.getText();
        String emailUsuario = email.getText();

        try {
        //conexão com o banco

            PreparedStatement ps = conexao.conectar().prepareStatement(Sql);

            ps.setString(1,nomecompleto);
            ps.setString(2,emailUsuario);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuario calvo com sucesso ");
            ps.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    });

    tela.setVisible(true);
}
