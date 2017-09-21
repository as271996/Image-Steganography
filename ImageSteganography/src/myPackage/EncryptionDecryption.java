package myPackage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static java.sql.JDBCType.NULL;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;


public class EncryptionDecryption extends javax.swing.JFrame {

    private boolean pictureLoaded;
    File imageFile = null;
    BufferedImage image = null;
   
    public EncryptionDecryption() {
        
        super("HideSeek");
        initComponents();
        
    }

   public  boolean inspection(String parts[]){
       int g=-1;
       while(g<0){
           String password=JOptionPane.showInputDialog(null,"Enter Your KeyWprd To Decrypt","Confirmation KeyWord", JOptionPane.INFORMATION_MESSAGE);
            if(password.length()>0)
            {
                g++;
                int i=1;
                while(i<=3)
                {
                    if(i<=1)
                    {
                        if(password.equals(parts))
                        {
                            return true;
                        } 
                        else
                        {
                             JOptionPane.showMessageDialog(null,"2 more chance \n Enter Valid KeyWords","Error",JOptionPane.ERROR);
                                
                                }      
                    }
                }
                if(i>1){
                    password=JOptionPane.showInputDialog(null,"Enter Your KeyWprd To Decrypt","Confirmation KeyWord", JOptionPane.INFORMATION_MESSAGE);
                    if(password.equals(parts)){
                      return true;  
                    } else
                        {
                             JOptionPane.showMessageDialog(null,"1 more chance \n Enter Valid KeyWords","Error",JOptionPane.ERROR);
                                
                          }   
                }
                if(i>=3)
                {
                    System.exit(0);
                }
            
            i++;
            } else {
                inspection(parts);
            }
            
       }
    return false;   
   };
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        PicturePanel = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        hide = new javax.swing.JButton();
        seek = new javax.swing.JButton();
        load = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reset.setText("reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        PicturePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("load Image");
        label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PicturePanelLayout = new javax.swing.GroupLayout(PicturePanel);
        PicturePanel.setLayout(PicturePanelLayout);
        PicturePanelLayout.setHorizontalGroup(
            PicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PicturePanelLayout.setVerticalGroup(
            PicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );

        hide.setText("hide");
        hide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideActionPerformed(evt);
            }
        });

        seek.setText("seek");
        seek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seekActionPerformed(evt);
            }
        });

        load.setText("load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PicturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(load)
                        .addGap(18, 18, 18)
                        .addComponent(hide)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seek)
                        .addGap(18, 18, 18)
                        .addComponent(reset)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(seek)
                    .addComponent(hide)
                    .addComponent(load))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
                    setTitle("HideSeek");
                    image = null;
                    jTextArea1.setText("");
              
                    label.setIcon(null);
                    jTextArea1.setText(null);
                    
                    hide.setEnabled(false);
                    seek.setEnabled(false);
                    reset.setEnabled(false);
                    load.setEnabled(true);
    }//GEN-LAST:event_resetActionPerformed

    private void seekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seekActionPerformed
                    jTextArea1.setText("seeking...");
                    String message = MessageHideSeek.extractStringFromImage(image);
                   // try{
                       // BufferedReader br=new BufferedReader(new FileReader(message));
                       // String currentLine;
                      //  while((currentLine=br.readLine())!="&")
                       // {
                       //   String text=currentLine.getText();  
                       // }
                  //  }catch(Exception e){
                   //     e.printStackTrace();
                  //  }
                    String parts[]=message.split("&");    
                   
                  
                 // jTextArea1=parts[0].getText();
                //for(int i=0;i<2;i++)
                // {
                     inspection(parts);
                 // jTextArea1.setText(parts[1]);
               //  }
                  // jTextArea1.setText(parts[1]);
                    jTextArea1.append("\n" + "complete" + "\n" + "hidden message: " +  parts[1]);
                    hide.setEnabled(false);
                    seek.setEnabled(false);
                    reset.setEnabled(true);
                    load.setEnabled(false);
    }//GEN-LAST:event_seekActionPerformed

    private void hideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideActionPerformed
                File messageFile = MessageHideSeek.getFile();
                String message = MessageHideSeek.loadMessage(messageFile);
                setTitle(getTitle() + " <- [" + messageFile.getName() + "]");
                jTextArea1.append("\n" + "hiding... " + getTitle().substring(8));
                byte[] imageAsBytes = MessageHideSeek.imageToBytes(image);
                byte[] messageAsBytes = MessageHideSeek.messageToBytes(message);
                byte[] messageAsBytesLengthAsBytes =  MessageHideSeek.messageAsBytesLengthToBytes(messageAsBytes);
                byte[] augmentedMessageAsBytes = MessageHideSeek.augmentByteArrays(messageAsBytesLengthAsBytes, messageAsBytes);
                MessageHideSeek.alterLSB(imageAsBytes, augmentedMessageAsBytes);
                String outputFileName = MessageHideSeek.saveImage(image, imageFile);
                jTextArea1.append("\n" + "complete");
                jTextArea1.append("\n" + "message hidden in file: " + outputFileName);
                hide.setEnabled(false);
                seek.setEnabled(false);
                reset.setEnabled(true);
                load.setEnabled(false);
    }//GEN-LAST:event_hideActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
         
          
                imageFile = MessageHideSeek.getFile();
                image = MessageHideSeek.loadImage(imageFile);
                setTitle("HideSeek [" + imageFile.getName() + "]");
                jTextArea1.setText("loading: " + imageFile.getName());
                jTextArea1.append("\n" + "complete");
               
                ImageIcon icon;
                icon=new ImageIcon(image);
                label.setIcon(icon);
           
                load.setEnabled(true);
                seek.setEnabled(true);
                reset.setEnabled(true);
                load.setEnabled(false);
            
         
    }//GEN-LAST:event_loadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EncryptionDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptionDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptionDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptionDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptionDecryption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PicturePanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton hide;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label;
    private javax.swing.JButton load;
    private javax.swing.JButton reset;
    private javax.swing.JButton seek;
    // End of variables declaration//GEN-END:variables
}
