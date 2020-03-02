/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiboparpri;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Fibonacci.Fibonacci;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultEditorKit;
public class GUI extends JFrame {
    Fibonacci fb= new Fibonacci();
    public JScrollBar scr;
    public JPanel gui;
    public JButton op;
    public JTextField dato;
    public JComboBox opcio;
    public JTextArea resul;
    public Container contenedor;
    int b=0;
    
    public GUI(){
        contenedor=getContentPane();
       
        
        gui= new JPanel(null);
        opcio= new JComboBox();
        op= new JButton();
        dato= new JTextField(20);
        resul= new JTextArea(25,25);
         scr= new JScrollBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("FiboParPri");
        setSize(400,400);
        setLocationRelativeTo(null);
        disposicion();
    }
    public void disposicion(){
        //panel
        
        gui.setPreferredSize(new Dimension (400,400));
        gui.setSize(400,400);
        //conf del combo box
        
        
        opcio.addItem("Fibonacci");
        opcio.addItem("Pares");
        opcio.addItem("Primos");
        opcio.setBounds(150,25,100,30);   
        
        //conf boton
        op.setText("Calcular");
        op.setSize(120,50);
        op.setBounds(150,140,100,30);
        //Conf del jtex dato
        dato.setBounds(170,90,50,30);
        //jtexar
        //resul.setLocation(250, 200);
        resul.setBounds(80,200,250,100);
        resul.setEditable(false);
         
       
        
        
        
        //scr.setBounds(60,200,15,100);
        //scr.add(resul);
        scr.add(resul);
        contenedor.add(scr);
        
        
        
        
        //añadir componente
        gui.add(opcio);
        gui.add(dato);
        gui.add(op);
        gui.add(resul);
        
        //Añadir contenedor
        contenedor.add(gui);
        //creacion del oyente
        OyenteCalcular oCalcular= new OyenteCalcular();
        
        //Asigancion del oyente
        op.addActionListener((ActionListener)oCalcular);
        
        
        
    }
  
    
    private class OyenteCalcular implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            int numero=Integer.parseInt(dato.getText());
            
            String i=opcio.getSelectedItem().toString();
            int resultado=0;
            

            if(i.equals("Fibonacci")){
                
                    resul.setText("");
                
                    
                    resul.append(" "+fb.fibo(numero));
                   
                    
                
                   /* resul.setText("");
                   int b=0;
                   int c=1;
                    
                    if(numero==1||numero==0||numero<0){
                        resul.setText("0, 1");
                    }
                    resul.append("0");
                    for (int a=1; a<numero; a++){
                    b=c;
                    c=resultado;
                    resultado=b+c;
                    if(a%12==0){
                       resul.append("\n");
                    }
                    resul.append(", "+resultado);
                    
                    }*/
                    
            }else{
                if(i.equals("Pares")){
                    resul.setText("");
                  
                    if(numero<0)
                    {
                       resul.setText("Sólo numeros postitivos");
                    }else{
                        if(numero==1){
                            resul.setText("El numero 1 no es numero par");
                        }else{
                            for(int a=1;numero>=a; a++ ){
                               if(a%21==0){
                                        resul.append("\n");
                                            }
                                if(a%2==0){
                                   
                                   resul.append(a+", ");
                               }
                            }
                                
                        }
                            
                    }
                }else{
                    if(i.equals("Primos")){
                       resul.setText("");
                  
                    if(numero<0)
                    {
                       resul.setText("Sólo numeros postitivos");
                    }else{
                        if(numero==1){
                            resul.setText("El numero 1 no es numero par");
                        }else{
                            for(int a=1;numero>=a; a++ ){
                                if(a%22==0){
                                       resul.append("\n");
                                }
                               if((a/a==1) && (a%2!=0)){
                                   
                                   
                                   resul.append(a+", ");
                               
                            }
                                
                        
                            
                    }
                    }
                }
            }
                
      
    }
   }
    }
  }
}
    
    

