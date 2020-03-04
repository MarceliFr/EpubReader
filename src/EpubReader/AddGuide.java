package EpubReader;

import EBookLib.EBook;
import EBookLib.EBookReader;
import EBookLib.EBookWriter;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

public class AddGuide extends javax.swing.JFrame {
    private final EBookWriter eBookWriter;
    private final EBook eBook;
    private final Document tmpContent;

    AddGuide(EBookWriter eBookWriter, EBook eBook) {
        this.eBookWriter = eBookWriter;
        this.eBook = eBook;
        tmpContent = (Document) eBook.getContent().cloneNode(true);
        eBookWriter.appendNode(tmpContent, "package", "guide", null, "", false);
        
        filesListModel = new DefaultListModel();
        newGuideListModel = new DefaultListModel();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availableFilesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableFilesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        newGuideList = new javax.swing.JList<>();
        addElementButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancellButton = new javax.swing.JButton();
        newGuideLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        availableFilesLabel.setText("Możliwe pliki do wyboru");

        availableFilesList.setModel(filesListModel);
        NodeList manifestNodeFiles = EBookReader.findNodeList(tmpContent, "item");
        for(int i=0;i<manifestNodeFiles.getLength();i++){
            if(manifestNodeFiles.item(i).getAttributes().getNamedItem("media-type").getNodeValue().equals("application/xhtml+xml")){
                filesListModel.addElement(manifestNodeFiles.item(i).getAttributes().getNamedItem("href").getNodeValue());
            }
        }
        jScrollPane1.setViewportView(availableFilesList);

        newGuideList.setModel(newGuideListModel);
        jScrollPane2.setViewportView(newGuideList);

        addElementButton.setText("Dodaj element");
        addElementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElementButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Zapisz");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancellButton.setText("Anuluj");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        newGuideLabel.setText("Nowa sekcja Guide");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(availableFilesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancellButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(newGuideLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addElementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableFilesLabel)
                    .addComponent(newGuideLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addElementButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(cancellButton)))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            eBookWriter.saveContentChanges(tmpContent, "content.opf");
            dispose();
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(AddGuide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    private void addElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElementButtonActionPerformed
        if(availableFilesList.getSelectedValue() != null){
            String fileName = availableFilesList.getSelectedValue();
            String title = JOptionPane.showInputDialog(this, "Podaj tytuł rozdziału", null);
            Map<String, String> guideNodeArguments = new HashMap<>();
            guideNodeArguments.put("href", fileName);
            guideNodeArguments.put("title", title);
            guideNodeArguments.put("type", "text");
            eBookWriter.appendNode(tmpContent, "guide", "reference", guideNodeArguments, "", false);
            newGuideListModel.addElement(title);
            filesListModel.removeElementAt(availableFilesList.getSelectedIndex());
        }
    }//GEN-LAST:event_addElementButtonActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElementButton;
    private javax.swing.JLabel availableFilesLabel;
    private javax.swing.JList<String> availableFilesList;
    private javax.swing.JButton cancellButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newGuideLabel;
    private javax.swing.JList<String> newGuideList;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    DefaultListModel filesListModel;
    DefaultListModel newGuideListModel;
}