package EpubReader;

import EBookLib.EBook;
import EBookLib.EBookReader;
import EBookLib.EBookWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

public class AddChapter extends javax.swing.JFrame {
    private final EBookWriter eBookWriter;
    private final EBook eBook;
    
    public AddChapter(EBookWriter eBookWriter, EBook eBook) {
        this.eBookWriter = eBookWriter;
        this.eBook = eBook;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chapterFileChooser = new javax.swing.JFileChooser();
        chapterNameText = new javax.swing.JTextField();
        addToGuideCheckBox = new javax.swing.JCheckBox();
        cancellButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        chapterFileChooser.setControlButtonsAreShown(false);
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("html files", "html");
        chapterFileChooser.addChoosableFileFilter(fnef);
        chapterFileChooser.setFileFilter(fnef);

        chapterNameText.setMaximumSize(new java.awt.Dimension(99, 22));
        chapterNameText.setMinimumSize(new java.awt.Dimension(99, 22));

        addToGuideCheckBox.setText("Dołącz do guide");

        cancellButton.setText("Anuluj");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        addButton.setText("Dodaj");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setLabelFor(chapterNameText);
        jLabel1.setText("Nazwa rozdziału");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chapterFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chapterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addToGuideCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancellButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chapterFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chapterNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addToGuideCheckBox)
                        .addComponent(addButton)
                        .addComponent(cancellButton)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(chapterFileChooser.getSelectedFile() == null){
            JOptionPane.showMessageDialog(this, "Nie wybrano pliku!", "Błąd odczytu", JOptionPane.ERROR_MESSAGE);
        }else{
            String filePath = chapterFileChooser.getSelectedFile().getAbsolutePath();
            if(chapterNameText.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Wprowadź nazwę rozdziału!", "Błąd wprowadzania", JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    String chapterName = chapterNameText.getText();
                    Document tmpContent = eBook.getContent();
                    Map<String, String> spineNodeArguments = new HashMap<>();
                    spineNodeArguments.put("idref", chapterName);
                    eBookWriter.appendNode(tmpContent, "spine", "itemref", spineNodeArguments, "");
                    eBook.getSpineMap().put(chapterName, chapterFileChooser.getSelectedFile().getName());
                    
                    Map<String, String> manifestNodeArguments = new HashMap<>();
                    manifestNodeArguments.put("id", chapterName);
                    manifestNodeArguments.put("href", chapterFileChooser.getSelectedFile().getName());
                    manifestNodeArguments.put("media-type", "application/xhtml+xml");
                    eBookWriter.appendNode(tmpContent, "manifest", "item", manifestNodeArguments, "");
                                        
                    if(addToGuideCheckBox.isSelected()){
                        if(EBookReader.findNodeByName(tmpContent, "guide", true) != null){
                            Map<String, String> guideNodeArguments = new HashMap<>();
                            guideNodeArguments.put("href", chapterFileChooser.getSelectedFile().getName());
                            guideNodeArguments.put("title", chapterName);
                            guideNodeArguments.put("type", "text");
                            eBookWriter.appendNode(tmpContent, "guide", "reference", guideNodeArguments, "");
                            eBook.getGuideMap().put(chapterName, chapterFileChooser.getSelectedFile().getName());
                        }else{
                            JOptionPane.showMessageDialog(this, "Ksiązka nie ma guide. \n Element nie zostanie dodany.");
                        }
                    }
                    eBookWriter.saveContentChanges(tmpContent);
                    eBookWriter.appendFile(filePath);
                    eBook.addToSpineMap(chapterName, chapterFileChooser.getSelectedFile().getName());
                } catch (IOException | TransformerException ex) {
                    Logger.getLogger(AddChapter.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBox addToGuideCheckBox;
    private javax.swing.JButton cancellButton;
    private javax.swing.JFileChooser chapterFileChooser;
    private javax.swing.JTextField chapterNameText;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
