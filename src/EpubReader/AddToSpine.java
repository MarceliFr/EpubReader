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
import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

public class AddToSpine extends javax.swing.JFrame {
    private final EBookWriter eBookWriter;
    private final EBook eBook;
    private final Document tmpContent;
    private final NodeList manifestNodes;
    private final NodeList spineNodes;
    
    AddToSpine(EBookWriter eBookWriter, EBook eBook) {
        this.eBookWriter = eBookWriter;
        this.eBook = eBook;
        tmpContent = (Document) eBook.getContent().cloneNode(true);
        eBookWriter.appendNode(tmpContent, "package", "guide", null, "");
        
        filesListModel = new DefaultListModel();
        newSpineListModel = new DefaultListModel();
        
        manifestNodes = EBookReader.findNodeList(tmpContent, "item");
        spineNodes = EBookReader.findNodeList(tmpContent, "itemref");

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availableFilesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableFilesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        newSpineList = new javax.swing.JList<>();
        addElementButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancellButton = new javax.swing.JButton();
        newGuideLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        availableFilesLabel.setText("Możliwe pliki do wyboru");

        availableFilesList.setModel(filesListModel);
        boolean add = true;
        for(int i=0;i<manifestNodes.getLength();i++){
            Node itemId = manifestNodes.item(i).getAttributes().getNamedItem("id");
            for(int j=0;j<spineNodes.getLength();j++){
                Node itemRef = spineNodes.item(j).getAttributes().getNamedItem("idref");
                if(itemId.getNodeValue().equals(itemRef.getNodeValue())){
                    add = false;
                    break;
                }
            }
            if(add == true){
                filesListModel.addElement(manifestNodes.item(i).getAttributes().getNamedItem("href").getNodeValue());
            }
            add = true;
        }
        jScrollPane1.setViewportView(availableFilesList);

        newSpineList.setModel(newSpineListModel);
        for (String key : eBook.getSpineMap().keySet()) {
            newSpineListModel.addElement(key + ": " + eBook.getSpineMap().get(key));
        }
        jScrollPane2.setViewportView(newSpineList);

        addElementButton.setText("Dodaj");
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

        newGuideLabel.setText("Nowa sekcja Spine");

        jButton1.setText("Usuń");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                    .addComponent(newGuideLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addElementButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancellButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addElementButton)
                            .addComponent(jButton1))
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
            eBookWriter.saveContentChanges(tmpContent);
            dispose();
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(AddToSpine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    private void addElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElementButtonActionPerformed
        if(availableFilesList.getSelectedValue() != null){
            String chapterName = JOptionPane.showInputDialog(this, "Podaj nazwę dodawanego rozdziału");
            Map<String, String> spineNodeArguments = new HashMap<>();
            spineNodeArguments.put("idref", chapterName);
            eBookWriter.appendNode(tmpContent, "spine", "itemref", spineNodeArguments, "");
            eBook.getSpineMap().put(chapterName, availableFilesList.getSelectedValue());
            newSpineListModel.addElement(chapterName + ": " + availableFilesList.getSelectedValue());
            filesListModel.removeElementAt(availableFilesList.getSelectedIndex());
        }
    }//GEN-LAST:event_addElementButtonActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(newSpineList.getSelectedValue() != null){
            String fileName = newSpineList.getSelectedValue().substring(newSpineList.getSelectedValue().indexOf(":")+2, newSpineList.getSelectedValue().length());
            String itemref = newSpineList.getSelectedValue().substring(0, newSpineList.getSelectedValue().indexOf(":"));
            eBookWriter.removeNode(tmpContent, EBookReader.findNodeByAttribute(tmpContent, "idref", itemref, true));
            filesListModel.addElement(fileName);
            newSpineListModel.removeElementAt(newSpineList.getSelectedIndex());
            eBook.getSpineMap().remove(itemref);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElementButton;
    private javax.swing.JLabel availableFilesLabel;
    private javax.swing.JList<String> availableFilesList;
    private javax.swing.JButton cancellButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newGuideLabel;
    private javax.swing.JList<String> newSpineList;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    DefaultListModel filesListModel;
    DefaultListModel newSpineListModel;
}