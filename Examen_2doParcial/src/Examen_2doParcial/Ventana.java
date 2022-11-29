package Examen_2doParcial;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Sebastián Osornio Araujo
 */
public class Ventana extends JFrame {

    private JPanel panel;
    private JButton boton;
    private JTextField nombre;
    private JTextField apellidoPaterno;
    private JTextField apellidoMaterno;
    private JTextField colonia;
    private JTextField calle;
    private JTextField municipio;
    private JTextField claveElector;
    private JTextField curp;
    private JTextField registro;
    private JTextField estado;
    private JTextField localidad;
    private JTextField noMunicipio;
    private JTextField emision;
    private JTextField seccion;
    private JTextField vigencia;
    

    public Ventana (){
        setSize(650,950); //Establecemos el tamaño de la ventana
        setTitle("Llenado de datos para INE "); //Establecemos el titulo de la ventana
        setLocationRelativeTo(null); //Establecemos la ventana en el centro de la pantalla
        
        //setResizable(false); //Establecemos si la ventana puede cambiar de tamaño o no
        setMinimumSize(new Dimension(200, 200)); //Establecemos el tamaño mínimo
        
        //this.getContentPane().setBackground(Color.GREEN); //Establecemos el color de la ventana
        
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Con esto automaticamente se deja de ejecutar el programa a la hora de cerrar la ventana
    }

    private void iniciarComponentes() {

        colocarPaneles();
        colocarEtiquetas();
        colocarTexto();
        BotonCrear();
        BotonAbrir();
        BotonFinalizar();
    }

    private void colocarPaneles(){
        panel = new JPanel(); //Creación de un panel
        panel.setBackground(Color.MAGENTA); //Establecemos el color del panel
        panel.setLayout(null); //Desactivando el Layout "Diseño"
        this.getContentPane().add(panel); //Agregamos el panel a la ventana
    }

    private void colocarEtiquetas() {
        JLabel etiqueta = new JLabel(); //Creamos una etiqueta
        etiqueta.setText("Ingresa los siguientes datos:"); //Establecemos el texto de la etiqueta
        etiqueta.setBounds(50, 70, 400, 80);
        etiqueta.setForeground(Color.WHITE); //Establecemos el color de la letra
        etiqueta.setFont(new Font("cooper black", Font.PLAIN, 25)); //Establecemos la fuente del texto
        panel.add(etiqueta); //Agregamos la etiqueta al panel
        
        //Etiqueta Imagen - etiqueta tipo imagen
        ImageIcon imagen = new ImageIcon("INE.png");
        JLabel etiquetaImagen = new JLabel();
        etiquetaImagen.setBounds(380, 5, 230, 80);
        etiquetaImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etiquetaImagen);

        //Etiqueta 1 - Apellido Paterno
        JLabel etiqueta1 = new JLabel(); //Creamos una etiqueta
        etiqueta1.setText("Apellido Parterno: "); //Establecemos el texto de la etiqueta
        etiqueta1.setBounds(50, 150, 200, 80);
        etiqueta1.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta1.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta1);  //Agregamos la etiqueta al panel

        //Etiqueta 2 - Apellido Materno
        JLabel etiqueta2 = new JLabel(); //Creamos una etiqueta
        etiqueta2.setText("Apellido Materno: "); //Establecemos el texto de la etiqueta
        etiqueta2.setBounds(50, 190, 200, 80);
        etiqueta2.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta2.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta2); //Agregamos la etiqueta al panel

        //Etiqueta 3 - Nombre
        JLabel etiqueta3 = new JLabel(); //Creamos una etiqueta
        etiqueta3.setText("Nombre: "); //Establecemos el texto de la etiqueta
        etiqueta3.setBounds(50, 230, 200, 80);
        etiqueta3.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta3.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta3); //Agregamos la etiqueta al panel

        //Etiqueta 4 - Calle y Número
        JLabel etiqueta4 = new JLabel(); //Creamos una etiqueta
        etiqueta4.setText("Calle y No.: "); //Establecemos el texto de la etiqueta
        etiqueta4.setBounds(50, 270, 200, 80);
        etiqueta4.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta4.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta4); //Agregamos la etiqueta al panel

        //Etiqueta 5 - Colonia y Codigo Postal
        JLabel etiqueta5 = new JLabel(); //Creamos una etiqueta
        etiqueta5.setText("Colonia y C.P.: "); //Establecemos el texto de la etiqueta
        etiqueta5.setBounds(50, 310, 220, 80);
        etiqueta5.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta5.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta5); //Agregamos la etiqueta al panel

        //Etiqueta 6 - Municipio
        JLabel etiqueta6 = new JLabel(); //Creamos una etiqueta
        etiqueta6.setText("Municipio: "); //Establecemos el texto de la etiqueta
        etiqueta6.setBounds(50, 350, 200, 80);
        etiqueta6.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta6.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta6); //Agregamos la etiqueta al panel

        //Etiqueta 7 - Clave de Elector
        JLabel etiqueta7 = new JLabel(); //Creamos una etiqueta
        etiqueta7.setText("Clave de Elector: "); //Establecemos el texto de la etiqueta
        etiqueta7.setBounds(50, 390, 200, 80);
        etiqueta7.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta7.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta7); //Agregamos la etiqueta al panel

        //Etiqueta 8 - Curp
        JLabel etiqueta8 = new JLabel(); //Creamos una etiqueta
        etiqueta8.setText("Curp: "); //Establecemos el texto de la etiqueta
        etiqueta8.setBounds(50, 430, 200, 80);
        etiqueta8.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta8.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta8); //Agregamos la etiqueta al panel

        //Etiqueta 9 - Año de Registo
        JLabel etiqueta9 = new JLabel(); //Creamos una etiqueta
        etiqueta9.setText("Año de Registro: "); //Establecemos el texto de la etiqueta
        etiqueta9.setBounds(50, 470, 200, 80);
        etiqueta9.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta9.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta9); //Agregamos la etiqueta al panel
        
        //Etiqueta 10 - Número de Estado
        JLabel etiqueta10 = new JLabel(); //Creamos una etiqueta
        etiqueta10.setText("No. Estado: "); //Establecemos el texto de la etiqueta
        etiqueta10.setBounds(50, 510, 200, 80);
        etiqueta10.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta10.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta10); //Agregamos la etiqueta al panel
        
        //Etiqueta 11 - Númeor de Localidad
        JLabel etiqueta11 = new JLabel(); //Creamos una etiqueta
        etiqueta11.setText("No. Localidad: "); //Establecemos el texto de la etiqueta
        etiqueta11.setBounds(50, 550, 200, 80);
        etiqueta11.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta11.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta11); //Agregamos la etiqueta al panel
        
        //Etiqueta 12 - Número de Municipio
        JLabel etiqueta12 = new JLabel(); //Creamos una etiqueta
        etiqueta12.setText("No. Municipio: "); //Establecemos el texto de la etiqueta
        etiqueta12.setBounds(50, 590, 200, 80);
        etiqueta12.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta12.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta12); //Agregamos la etiqueta al panel
        
        //Etiqueta 13 - Emisión
        JLabel etiqueta13 = new JLabel(); //Creamos una etiqueta
        etiqueta13.setText("Emsión: "); //Establecemos el texto de la etiqueta
        etiqueta13.setBounds(50, 630, 200, 80);
        etiqueta13.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta13.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta13); //Agregamos la etiqueta al panel
        
        //Etiqueta 14 - Sección
        JLabel etiqueta14 = new JLabel(); //Creamos una etiqueta
        etiqueta14.setText("Sección: "); //Establecemos el texto de la etiqueta
        etiqueta14.setBounds(50, 670, 200, 80);
        etiqueta14.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta14.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta14); //Agregamos la etiqueta al panel
        
        //Etiqueta 15 - Vigencia
        JLabel etiqueta15 = new JLabel(); //Creamos una etiqueta
        etiqueta15.setText("Vigencia: "); //Establecemos el texto de la etiqueta
        etiqueta15.setBounds(50, 710, 200, 80);
        etiqueta15.setForeground(Color.black); //Establecemos el color de la letra
        etiqueta15.setFont(new Font("Calibri Light", Font.ITALIC, 22)); //Establecemos la fuente del texto
        panel.add(etiqueta15); //Agregamos la etiqueta al panel

    }

    private void colocarTexto() {

        //Apellido Paterno
        apellidoPaterno = new JTextField();
        apellidoPaterno.setBounds(230, 165, 300, 35);
        panel.add(apellidoPaterno);

        //Apellido Materno
        apellidoMaterno = new JTextField();
        apellidoMaterno.setBounds(230, 205, 300, 35);
        panel.add(apellidoMaterno);

        //Nombre
        nombre = new JTextField();
        nombre.setBounds(230, 245, 300, 35);
        panel.add(nombre);

        //Calle
        calle = new JTextField();
        calle.setBounds(230, 285, 300, 35);
        panel.add(calle);

        //Colonia y Codigo Postal
        colonia = new JTextField();
        colonia.setBounds(230, 325, 300, 35);
        panel.add(colonia);

        //Municipio
        municipio = new JTextField();
        municipio.setBounds(230, 365, 300, 35);
        panel.add(municipio);

        //Clave de Elector
        claveElector = new JTextField();
        claveElector.setBounds(230, 405, 300, 35);
        panel.add(claveElector);

        //Curp
        curp = new JTextField();
        curp.setBounds(230, 445, 300, 35);
        panel.add(curp);

        //Año de Registro
        registro = new JTextField();
        registro.setBounds(230, 485, 300, 35);
        panel.add(registro);
        
        //Número de Estado
        estado = new JTextField();
        estado.setBounds(230, 525, 300, 35);
        panel.add(estado);
        
        //Númeor de Localidad
        localidad = new JTextField();
        localidad.setBounds(230, 565, 300, 35);
        panel.add(localidad);
        
        //Númeor de Municipio
        noMunicipio = new JTextField();
        noMunicipio.setBounds(230, 605, 300, 35);
        panel.add(noMunicipio);
        
        //Emisión
        emision = new JTextField();
        emision.setBounds(230, 645, 300, 35);
        panel.add(emision);
        
        //Sección
        seccion = new JTextField();
        seccion.setBounds(230, 685, 300, 35);
        panel.add(seccion);
        
        //Vigencia
        vigencia = new JTextField();
        vigencia.setBounds(230, 725, 300, 35);
        panel.add(vigencia);
    }

    private void BotonCrear() {
        boton = new JButton("Crear INE");
        boton.setBounds(100, 815, 120, 40);
        boton.setForeground(java.awt.Color.black);
        boton.setFont(new java.awt.Font("Baskerville", java.awt.Font.CENTER_BASELINE, 15));
        boton.setEnabled(true);
        panel.add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String imagen = "C:\\Users\\sebas\\Desktop\\INE.jpg";
                String imagen2 = "C:\\Users\\sebas\\Desktop\\Avatar.jpeg";
                
                try {
                    PDDocument documento = new PDDocument();
                    PDRectangle mypage = new PDRectangle(900, 600);
                    PDPage pagina = new PDPage(mypage);
                    documento.addPage(pagina);

                    PDImageXObject image = PDImageXObject.createFromFile(imagen, documento);
                    PDImageXObject image2 = PDImageXObject.createFromFile(imagen2, documento);
                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                    // contenido.drawImage(image, 4.5f, 0.3f);
                    contenido.drawImage(image, 70, 40, 600, 450);
                    contenido.drawImage(image2, 255, 260, 120, 135);
                    
                    //Apellido Paterno
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                    //   contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(380, pagina.getMediaBox().getHeight() - 208);
                    contenido.showText(apellidoPaterno.getText());
                    contenido.endText();

                    //Apellido Materno
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(380, pagina.getMediaBox().getHeight() - 220);
                    contenido.showText(apellidoMaterno.getText());
                    contenido.endText();

                    //Nombre
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(380, pagina.getMediaBox().getHeight() - 230);
                    contenido.showText(nombre.getText());
                    contenido.endText();

                    //Calle
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(380, pagina.getMediaBox().getHeight() - 255);
                    contenido.showText(calle.getText());
                    contenido.endText();

                    //Colonia y Codigo Postal
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(380, pagina.getMediaBox().getHeight() - 266);
                    contenido.showText(colonia.getText());
                    contenido.endText();

                    //Municipio
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(380, pagina.getMediaBox().getHeight() - 278);
                    contenido.showText(municipio.getText());
                    contenido.endText();

                    //Clave de Elector
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(460, pagina.getMediaBox().getHeight() - 296);
                    contenido.showText(claveElector.getText());
                    contenido.endText();

                    //Curp
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(405, pagina.getMediaBox().getHeight() - 311);
                    contenido.showText(curp.getText());
                    contenido.endText();
                    
                    //Año de Registro
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 9);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(620, pagina.getMediaBox().getHeight() - 310);                   
                    contenido.showText(registro.getText()); 
                    contenido.endText();
                    
                    //Número de Estado
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(430, pagina.getMediaBox().getHeight() - 328);                   
                    contenido.showText(estado.getText()); 
                    contenido.endText();
                    
                    //Número de Localidad
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(428, pagina.getMediaBox().getHeight() - 345);                   
                    contenido.showText(localidad.getText()); 
                    contenido.endText();
                    
                    //Número de Municipio
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(512, pagina.getMediaBox().getHeight() - 329);                   
                    contenido.showText(noMunicipio.getText()); 
                    contenido.endText();
                    
                    //Emision
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(513, pagina.getMediaBox().getHeight() - 345);                   
                    contenido.showText(emision.getText()); 
                    contenido.endText();
                    
                    //Sección
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(584, pagina.getMediaBox().getHeight() - 329);                   
                    contenido.showText(seccion.getText()); 
                    contenido.endText();
                    
                    //Vigencia
                    contenido.beginText();
                    contenido.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                  //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(586, pagina.getMediaBox().getHeight() - 345);                   
                    contenido.showText(vigencia.getText()); 
                    contenido.endText();

                    contenido.close();

                    documento.save("C:\\Users\\sebas\\Desktop\\INE.pdf");

                } catch (Exception x) {
                    System.out.println("Error: " + x.getMessage().toString());
                }

            }
        });

    }

    private void BotonAbrir() {

        boton = new JButton("Abrir INE");
        boton.setBounds(100, 865, 120, 40);
        boton.setForeground(java.awt.Color.black);
        boton.setFont(new java.awt.Font("Baskerville", java.awt.Font.CENTER_BASELINE, 15));
        boton.setEnabled(true);

        panel.add(boton);

        ActionListener accion = new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                try {
                    File path = new File("C:\\Users\\sebas\\Desktop\\INE.pdf");
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        };

        boton.addActionListener(accion);

    }

    private void BotonFinalizar() {
        boton = new JButton("Finalizar");
        boton.setBounds(450, 835, 120, 40);
        boton.setForeground(java.awt.Color.BLUE);
        boton.setFont(new java.awt.Font("Baskerville", java.awt.Font.CENTER_BASELINE, 18));
        boton.setEnabled(true);

        panel.add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                System.exit(0);

            }
        });
    }

}
