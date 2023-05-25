package org.example;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.awt.*;
import java.io.File;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class App {
    private JFrame loginFrame;
    private JFrame privateAccessFrame;
    private JTextField userField;
    private JPasswordField passwordField;
    private Random random;
    private Map<String, Boolean> coordenadasAtacadas;

    public static void main(String[] args) {
        App app = new App();
        app.crearVentanaLogin();
    }

    public App() {
        random = new Random();
        coordenadasAtacadas = new HashMap<>();
    }
    private void crearVentanaLogin() {
        loginFrame = new JFrame("Login - Área restringida - Uso exclusivo del ejercito");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(450, 640);
        loginFrame.getContentPane().setBackground(Color.GRAY);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.GRAY);

        ImageIcon imagen = new ImageIcon("src/main/java/org/example/banderas/EJERCITO.png");
        JLabel imagenLabel = new JLabel(imagen);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentro.setBackground(Color.GRAY);

        JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelUsuario.setBackground(Color.GRAY);
        JLabel userLabel = new JLabel("Usuario:");
        userField = new JTextField(10); // Corregir: asignar valor a la variable de instancia
        panelUsuario.add(userLabel);
        panelUsuario.add(userField);

        JPanel panelContraseña = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelContraseña.setBackground(Color.GRAY);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(10); // Corregir: asignar valor a la variable de instancia
        panelContraseña.add(passwordLabel);
        panelContraseña.add(passwordField);

        panelCentro.add(panelUsuario);
        panelCentro.add(panelContraseña);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(Color.GRAY);
        JButton loginButton = new JButton("Iniciar sesión");
        panelInferior.add(loginButton);

        // Agrega la acción del botón de inicio de sesión
        ActionListener loginActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("ucrania") && password.equals("ucrania")) {
                    loginFrame.dispose();
                    crearVentanaAccesoPrivado();
                } else if (username.equals("toni") && password.equals("toni")) {
                    loginFrame.dispose();
                    crearVentanaSecreta();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrectos.");
                }
            }
        };

        loginButton.addActionListener(loginActionListener);

        // Agrega la acción al presionar la tecla "Enter" en los campos de usuario y contraseña
        KeyListener enterKeyListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginActionListener.actionPerformed(null);
                }
            }
        };

        userField.addKeyListener(enterKeyListener);
        passwordField.addKeyListener(enterKeyListener);

        JLabel advertenciaLabel = new JLabel("USALO BAJO TU PROPIA RESPONSABILIDAD");
        advertenciaLabel.setForeground(Color.RED);
        advertenciaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        advertenciaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panelPrincipal.add(imagenLabel, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        panelPrincipal.add(advertenciaLabel, BorderLayout.PAGE_END);

        loginFrame.add(panelPrincipal);
        loginFrame.setVisible(true);
    }


//VENTANA LOGUEANDO COMO TONI
    private void crearVentanaSecreta() {
        privateAccessFrame = new JFrame("Área de acceso privado - Logged in as: toni - Administración oculta del Ejercito V2");
        privateAccessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        privateAccessFrame.setSize(640, 360);
        privateAccessFrame.setLayout(new BorderLayout());
        privateAccessFrame.getContentPane().setBackground(Color.GRAY);



        JLabel welcomeLabel = new JLabel("¡Hola Toni! Bienvenido al panel oculto de la administracion del Ejercito.");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        JPanel panelBotones = new JPanel(new GridLayout(2, 2));
        ImageIcon iconoDESTRUIR = new ImageIcon("src/main/java/org/example/banderas/destruir.png");
        JButton botonCerrar = new JButton("BOTON DEL PANICO - DESTRUIR TODO EL MUNDO", iconoDESTRUIR);
        botonCerrar.setBackground(Color.WHITE);
        botonCerrar.setForeground(Color.BLACK);

        ImageIcon icono1 = new ImageIcon("src/main/java/org/example/banderas/cni.png");
        ImageIcon icono2 = new ImageIcon("src/main/java/org/example/banderas/fbi.png");

        JButton boton1 = new JButton("Asuntos secretos del CNI", icono1);
        JButton boton2 = new JButton("Asuntos secretos del FBI", icono2);

        boton1.setBackground(Color.RED);
        boton1.setForeground(Color.WHITE);
        boton2.setBackground(Color.RED);
        boton2.setForeground(Color.WHITE);

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaToni("CNI");
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaToni("FBI");
            }
        });

        panelBotones.add(boton1);
        panelBotones.add(boton2);

        privateAccessFrame.add(welcomeLabel, BorderLayout.NORTH);
        privateAccessFrame.add(panelBotones, BorderLayout.CENTER);
        privateAccessFrame.add(botonCerrar, BorderLayout.SOUTH);

        privateAccessFrame.setVisible(true);
    }



    private void crearVentanaAccesoPrivado() {
        privateAccessFrame = new JFrame("Área de acceso privado - Logged in as: ucrania - Administración del Ejercito V2");
        privateAccessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        privateAccessFrame.setSize(950, 390);
        privateAccessFrame.setLayout(new BorderLayout());
        privateAccessFrame.getContentPane().setBackground(Color.GRAY);



        JLabel welcomeLabel = new JLabel("Bienvenido al panel de administración del ejercito de Ucrania");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        JPanel panelBotones = new JPanel(new GridLayout(2, 2));
        ImageIcon iconoDESTRUIR = new ImageIcon("src/main/java/org/example/banderas/destruir.png");
        JButton botonCerrar = new JButton("ESTADISTICAS DE GUERRA - INFORMACION ADICIONAL", iconoDESTRUIR);
        botonCerrar.setBackground(Color.WHITE);
        botonCerrar.setForeground(Color.BLACK);

        ImageIcon iconoRUSIA = new ImageIcon("src/main/java/org/example/banderas/rusiaflag.jpg");
        ImageIcon iconoUSA = new ImageIcon("src/main/java/org/example/banderas/usaflag.png");
        ImageIcon iconoCHINA = new ImageIcon("src/main/java/org/example/banderas/chinaflag.png");
        ImageIcon iconoESPANA = new ImageIcon("src/main/java/org/example/banderas/españaflag.jpg");

        JButton boton1 = new JButton("Enviar misil a Rusia", iconoRUSIA);
        JButton boton2 = new JButton("Enviar misil a EE.UU", iconoUSA);
        JButton boton3 = new JButton("Enviar misil a China", iconoCHINA);
        JButton boton4 = new JButton("Enviar misil a España", iconoESPANA);
        JButton boton5 = new JButton("Enviar misil a Corea del Sur", new ImageIcon("src/main/java/org/example/banderas/coreasurflag.png"));
        JButton boton6 = new JButton(" ☻ Vigilancia IES Caminas", new ImageIcon("src/main/java/org/example/banderas/videovigilancia.jpg"));

        // DEFINIR COLORES BANDERA UCRANIA
        // BOTONES DEL 4 AL 6 BACKGROUND AMARILLO FOREGROUND AZUL CLARITO
        boton4.setBackground(Color.YELLOW);
        boton4.setForeground(Color.BLUE);
        boton5.setBackground(Color.YELLOW);
        boton5.setForeground(Color.BLUE);
        boton6.setBackground(Color.YELLOW);
        boton6.setForeground(Color.BLUE);
        // BOTONES DEL 1 AL 3 BACKGROUND AZUL CLARITO FOR
        boton1.setBackground(Color.BLUE);
        boton1.setForeground(Color.YELLOW);
        boton2.setBackground(Color.BLUE);
        boton2.setForeground(Color.YELLOW);
        boton3.setBackground(Color.BLUE);
        boton3.setForeground(Color.YELLOW);

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {



            }
        });

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("Rusia");
            }
        });


        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("EE.UU");
            }
        });

        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("China");
            }
        });

        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("España");
            }
        });

        boton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("Corea-Del-Sur");
            }
        });

        boton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVideovigilancia();
            }
        });



        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        panelBotones.add(boton6);

        privateAccessFrame.add(welcomeLabel, BorderLayout.NORTH);
        privateAccessFrame.add(panelBotones, BorderLayout.CENTER);
        privateAccessFrame.add(botonCerrar, BorderLayout.SOUTH);

        privateAccessFrame.setVisible(true);
    }

    private void abrirVideovigilancia() {
        JFrame videoFrame = new JFrame("Videovigilancia IES Caminas");
        videoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        videoFrame.setSize(800, 600);

        // Panel principal
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 750));

        // Foto del profesor arriba en el panel principal
        ImageIcon mainPhotoIcon = new ImageIcon("src/main/java/org/example/banderas/caminas.jpeg");
        Image mainScaledImage = mainPhotoIcon.getImage().getScaledInstance(800, 750, Image.SCALE_SMOOTH);
        ImageIcon mainScaledIcon = new ImageIcon(mainScaledImage);
        JLabel mainPhotoLabel = new JLabel(mainScaledIcon);
        mainPhotoLabel.setBounds(0, 0, 800, 750);
        layeredPane.add(mainPhotoLabel, JLayeredPane.DEFAULT_LAYER);

// Panel central con el texto "Cámara de Vigilancia 001 Pasillo Central Piso 2"
        JLabel camLabel = new JLabel("Cámara de Vigilancia 001 Pasillo Central Piso 2");
        camLabel.setHorizontalAlignment(SwingConstants.CENTER);
        camLabel.setFont(new Font("Arial", Font.BOLD, 20));
        camLabel.setForeground(Color.WHITE);
        camLabel.setBounds(0, 0, 800, 30);
        layeredPane.add(camLabel, JLayeredPane.PALETTE_LAYER);


        // Panel inferior con el texto "Profesor de guardia: Victor Ponz"
        JLabel guardLabel = new JLabel("Profesor de guardia:");
        guardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        guardLabel.setFont(new Font("Arial", Font.BOLD, 16));
        guardLabel.setForeground(Color.WHITE);
        guardLabel.setBounds(0, 550, 800, 20);
        layeredPane.add(guardLabel, JLayeredPane.PALETTE_LAYER);

        // Panel inferior con la foto del profesor y su nombre
        JPanel photoPanel = new JPanel(new BorderLayout());
        photoPanel.setBackground(Color.WHITE);
        photoPanel.setBounds(325, 570, 150, 150);

        ImageIcon photoIcon = new ImageIcon("src/main/java/org/example/banderas/victor.jpg");
        Image scaledImage = photoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel photoLabel = new JLabel(scaledIcon, SwingConstants.CENTER);
        photoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel nameLabel = new JLabel("Victor Ponz", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        photoPanel.add(photoLabel, BorderLayout.CENTER);
        photoPanel.add(nameLabel, BorderLayout.SOUTH);
        layeredPane.add(photoPanel, JLayeredPane.PALETTE_LAYER);

        videoFrame.getContentPane().add(layeredPane);
        videoFrame.pack();
        videoFrame.setVisible(true);
    }


    private void abrirVentanaToni(String nombrefoto) {
        JFrame mapaFrame = new JFrame("Secretos del " + nombrefoto);
        mapaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mapaFrame.setSize(600, 400);
        mapaFrame.setLayout(new BorderLayout());

        JLabel mapaLabel = new JLabel(new ImageIcon("src/main/java/org/example/banderas/" + nombrefoto.toLowerCase() + ".png"));

        mapaFrame.add(mapaLabel, BorderLayout.CENTER);
    }




    private void abrirVentanaMapa(String pais) {
        JFrame mapaFrame = new JFrame("Mapa de " + pais);
        mapaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mapaFrame.setSize(600, 400);
        mapaFrame.setLayout(new BorderLayout());

        JLabel mapaLabel = new JLabel(new ImageIcon("src/main/java/org/example/banderas/" + pais.toLowerCase() + ".png"));

        mapaFrame.add(mapaLabel, BorderLayout.CENTER);

        JPanel panelCampos = new JPanel(new FlowLayout());
        JLabel longitudLabel = new JLabel("Longitud:");
        JTextField longitudField = new JTextField(10);
        JLabel latitudLabel = new JLabel("Latitud:");
        JTextField latitudField = new JTextField(10);
        JButton enviarAtaqueButton = new JButton("Enviar ataque");

        mapaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double latitud = generarCoordenadaAleatoria();
                double longitud = generarCoordenadaAleatoria();
                latitudField.setText(String.valueOf(latitud));
                longitudField.setText(String.valueOf(longitud));

                String coordenada = latitud + "-" + longitud;
                if (coordenadasAtacadas.containsKey(coordenada) && coordenadasAtacadas.get(coordenada)) {
                    JOptionPane.showMessageDialog(mapaFrame,
                            "Ya has enviado un misil en esta zona, actualmente no hay nadie vivo, por favor, selecciona otra coordenada.");
                    return;
                }

                coordenadasAtacadas.put(coordenada, true);

                JOptionPane.showMessageDialog(mapaFrame,
                        "Enviando misil a " + pais + " Longitud: " + longitud + " Latitud: " + latitud);

                // Muestra una ventana con el gif del misil lanzado
                JFrame gifFrame = new JFrame("Camara de la Estacion de Cohetes");
                gifFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gifFrame.setSize(400, 400);

                int randomRocket = random.nextInt(4) + 1;
                String gifPath = "src/main/java/org/example/banderas/cohete" + randomRocket + ".gif";
                JLabel gifLabel = new JLabel(new ImageIcon(gifPath));
                gifFrame.add(gifLabel);
                gifFrame.setVisible(true);
                // Cierra la ventana del gif después de 7 segundos
                Timer timer = new Timer(7000, new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        gifFrame.dispose();
                        if (randomRocket == 4) {
                            int choice = JOptionPane.showOptionDialog(mapaFrame,
                                    "El misil ha explotado y no ha llegado a su destino. ¿Desea lanzar otro misil?",
                                    "Error de lanzamiento", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.ERROR_MESSAGE, null, null, null);
                            if (choice == JOptionPane.YES_OPTION) {
                                // Vuelve a lanzar otro misil
                                enviarAtaqueButton.doClick();

                            } else {

                            }
                        }

                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        enviarAtaqueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double latitud = Double.parseDouble(latitudField.getText());
                double longitud = Double.parseDouble(longitudField.getText());
                String coordenada = latitud + "-" + longitud;

                if (coordenadasAtacadas.containsKey(coordenada) && coordenadasAtacadas.get(coordenada)) {
                    JOptionPane.showMessageDialog(mapaFrame,
                            "Ya has enviado un misil en esta zona, actualmente no hay nadie vivo, por favor, selecciona otra coordenada.");
                    return;
                }

                coordenadasAtacadas.put(coordenada, true);

                JOptionPane.showMessageDialog(mapaFrame,
                        "Enviando misil a " + pais + " Longitud: " + longitud + " Latitud: " + latitud);

                // Muestra una ventana con el gif del misil lanzado
                JFrame gifFrame = new JFrame("Camara de la Estacion de Cohetes");
                gifFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gifFrame.setSize(400, 400);

                int randomRocket = random.nextInt(4) + 1;



                String gifPath = "src/main/java/org/example/banderas/cohete" + randomRocket + ".gif";
                JLabel gifLabel = new JLabel(new ImageIcon(gifPath));
                gifFrame.add(gifLabel);
                gifFrame.setVisible(true);
                // Cierra la ventana del gif después de 7 segundos
                Timer timer = new Timer(7000, new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        gifFrame.dispose();
                        if (randomRocket == 4) {
                            int choice = JOptionPane.showOptionDialog(mapaFrame,
                                    "El misil ha explotado y no ha llegado a su destino. ¿Desea lanzar otro misil?",
                                    "Error de lanzamiento", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.ERROR_MESSAGE, null, null, null);
                            if (choice == JOptionPane.YES_OPTION) {
                                // Vuelve a lanzar otro misil
                                enviarAtaqueButton.doClick();

                            } else {

                            }
                        }

                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        panelCampos.add(longitudLabel);
        panelCampos.add(longitudField);
        panelCampos.add(latitudLabel);
        panelCampos.add(latitudField);
        panelCampos.add(enviarAtaqueButton);


        mapaFrame.add(panelCampos, BorderLayout.SOUTH);

        mapaFrame.setVisible(true);
    }
    private double generarCoordenadaAleatoria() {
        double min = -90.0;
        double max = 90.0;
        return min + Math.random() * (max - min);
    }
}