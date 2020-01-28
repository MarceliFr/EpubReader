
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

class EdytujMetadane extends javax.swing.JDialog {
    private final EBook eBook;
    private Document tmpContent;
    private final Metadata tmpMetadata;
    private final EBookWriter eBookWriter;
    
    public EdytujMetadane(EBook eBook) throws IOException {
        this.eBook = eBook;
        tmpContent = eBook.getContent();
        tmpMetadata = new Metadata();
        tmpMetadata.setCreators(eBook.getMetadata().getCreators());
        tmpMetadata.setTitle("kurwa");
        tmpMetadata.setPublishers(eBook.getMetadata().getPublishers());
        tmpMetadata.setDate(eBook.getMetadata().getDate());
        tmpMetadata.setSubjects(eBook.getMetadata().getSubjects());
        tmpMetadata.setSource(eBook.getMetadata().getSource());
        tmpMetadata.setRights(eBook.getMetadata().getRights());
        tmpMetadata.setLanguage(eBook.getMetadata().getLanguage());
        eBookWriter = new EBookWriter();
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        creatorLabel = new javax.swing.JLabel();
        addCreator = new javax.swing.JButton();
        removeCreator = new javax.swing.JButton();
        cancellButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edytuj metadane");
        setAlwaysOnTop(true);

        creatorLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        creatorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        creatorLabel.setText("Autor");

        addCreator.setText("Dodaj");
        addCreator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCreatorActionPerformed(evt);
            }
        });

        removeCreator.setText("Usuń");
        removeCreator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCreatorActionPerformed(evt);
            }
        });

        cancellButton.setText("Anuluj");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Zapisz zmiany");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(creatorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCreator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeCreator)
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancellButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addCreator)
                        .addComponent(removeCreator))
                    .addComponent(creatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancellButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCreatorActionPerformed
        String creator = JOptionPane.showInputDialog(this, "Dodaj autora", null);
        tmpMetadata.addCreator(creator);
        tmpContent = eBookWriter.appendNode(tmpContent, "metadata", "dc:creator", creator);
        System.out.println(eBook.getMetadata().getCreators().hashCode());
        System.out.println(tmpMetadata.getCreators().hashCode());
    }//GEN-LAST:event_addCreatorActionPerformed

    private void removeCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCreatorActionPerformed
        ListItemSelection listItemSelection = new ListItemSelection(tmpContent, tmpMetadata.getCreators());
        listItemSelection.setVisible(true);
    }//GEN-LAST:event_removeCreatorActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            eBook.setMetadata(tmpMetadata);
            eBook.getZipFile().close();
            eBookWriter.saveContentChanges(eBook.getPath(), eBook.getContentPath(), tmpContent);
            eBook.setZipFile();
            dispose();
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(EdytujMetadane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        System.out.println(eBook.getMetadata().hashCode());
        System.out.println(tmpMetadata.hashCode());
        System.out.println(eBook.getMetadata().getCreators().toString());
        System.out.println(tmpMetadata.getCreators().toString());
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCreator;
    private javax.swing.JButton cancellButton;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton removeCreator;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}