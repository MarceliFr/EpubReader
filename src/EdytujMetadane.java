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
        tmpMetadata.setTitle(eBook.getMetadata().getTitle());
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
        titleLabel = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        publisherLabel = new javax.swing.JLabel();
        addPublisher = new javax.swing.JButton();
        removePublisher = new javax.swing.JButton();

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

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleLabel.setText("Tytuł");

        titleText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleText.setText(eBook.getMetadata().getTitle());

        publisherLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publisherLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        publisherLabel.setText("Wydawcy");

        addPublisher.setText("Dodaj");
        addPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherActionPerformed(evt);
            }
        });

        removePublisher.setText("Usuń");
        removePublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePublisherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(creatorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancellButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addCreator)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeCreator))
                                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPublisher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removePublisher)
                        .addGap(150, 150, 150)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCreator)
                    .addComponent(removeCreator)
                    .addComponent(creatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPublisher)
                    .addComponent(removePublisher)
                    .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancellButton)
                    .addComponent(saveButton))
                .addGap(18, 18, 18))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCreatorActionPerformed
        String creator = JOptionPane.showInputDialog(this, "Dodaj autora", null);
        tmpMetadata.addCreator(creator);
        tmpContent = eBookWriter.appendNode(tmpContent, "metadata", "dc:creator", creator);
    }//GEN-LAST:event_addCreatorActionPerformed
    private void removeCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCreatorActionPerformed
        ListItemSelection listItemSelection = new ListItemSelection(tmpContent, tmpMetadata.getCreators());
        listItemSelection.setVisible(true);
    }//GEN-LAST:event_removeCreatorActionPerformed
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            if(!titleText.getText().equals(eBook.getMetadata().getTitle())){
                tmpMetadata.setTitle(titleText.getText());
            }
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
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void addPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherActionPerformed
        String publisher = JOptionPane.showInputDialog(this, "Dodaj wydawcę", null);
        tmpMetadata.addPublisher(publisher);
        tmpContent = eBookWriter.appendNode(tmpContent, "metadata", "dc:publisher", publisher);
    }//GEN-LAST:event_addPublisherActionPerformed
    private void removePublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePublisherActionPerformed
        ListItemSelection listItemSelection = new ListItemSelection(tmpContent, tmpMetadata.getPublishers());
        listItemSelection.setVisible(true);
    }//GEN-LAST:event_removePublisherActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCreator;
    private javax.swing.JButton addPublisher;
    private javax.swing.JButton cancellButton;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JButton removeCreator;
    private javax.swing.JButton removePublisher;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}