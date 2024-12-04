package main.view;

import main.main;
import main.controller.TreinoController;
import main.model.Professor;
import main.model.Treino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Objects;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AtualizarExcluirTreino implements ActionListener {
    private JButton voltarhomep, btnAtualizar, btnExcluir;
    private JTextArea instrucoes;
    private JTextArea objetivo;
    private JTextArea treino;
    private JTextField txtNome;
    private JComboBox<String> especialidadeTreinos; 
    private Professor professor;
    private String idTreino;
    
    JFrame frame = new JFrame("Registro Treino");

    public AtualizarExcluirTreino() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1280, 800);  
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
     // Layout nulo para posicionamento manual
    frame.setLayout(null);

    //definindo botões
    voltarhomep = new JButton("<");
    voltarhomep.setBounds(10, 30, 50, 40);
    frame.add(voltarhomep);
    
    btnAtualizar = new JButton("Atualizar");
    btnAtualizar.setBounds(200, 710, 326, 46);
    frame.add(btnAtualizar);

    btnExcluir = new JButton("Excluir");
    btnExcluir.setBounds(600, 710, 326, 46);
    frame.add(btnExcluir);


    //definindo os JtextArea
    objetivo = new JTextArea();  
    objetivo.setBounds(50, 550, 500, 100);

    txtNome = new JTextField();
    txtNome.setBounds(50,130,300,30);


    instrucoes = new JTextArea();  
    instrucoes.setBounds(50, 200, 300, 300);

    treino = new JTextArea();  
    treino.setBounds(700, 99, 500, 600);

    frame.add(objetivo);
    frame.add(instrucoes);
    frame.add(treino);
    frame.add(txtNome);

     // Criar o JComboBox para selecionar a especialidade
     String[] especialidades = {
        "Treino para Hipertrofia Muscular",
        "Treino para Perda de Peso",
        "FullBody"
    };
    especialidadeTreinos = new JComboBox<>(especialidades);
    especialidadeTreinos.setBounds(460, 30, 500, 30);  // Ajustar a posição e o tamanho
    frame.add(especialidadeTreinos);


    voltarhomep.addActionListener(this);
    btnAtualizar.addActionListener(this);
    btnExcluir.addActionListener(this);


    // Ajustando a imagem de fundo
    ImageIcon imagemFundo = new ImageIcon("src/main/view/img/RegistroTreinoProfessor.jpg");  //caminho da imagem
    Image imagem = imagemFundo.getImage();
    Image imagemRedimensionada = imagem.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
    imagemFundo = new ImageIcon(imagemRedimensionada);

    // Definir a imagem de fundo no frame
    JLabel fundo = new JLabel(imagemFundo);
    fundo.setBounds(0, 0, frame.getWidth(), frame.getHeight());  // Faz a imagem ocupar toda a janela
    frame.add(fundo);

    frame.addWindowFocusListener(new java.awt.event.WindowAdapter() 
        {
            public void windowGainedFocus(java.awt.event.WindowEvent e) 
            {
                frame.getContentPane().requestFocusInWindow();
            }
        });
    
    // Exibir o frame
    frame.setVisible(true);
    }

    public AtualizarExcluirTreino(Professor professor, String idTreino) {
        this.idTreino = idTreino;
    this.professor = professor;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == voltarhomep) {
         new HomeProf(professor);
     }
    }

    public static void main(String[] args) {
        new AtualizarExcluirTreino();
    }
}


