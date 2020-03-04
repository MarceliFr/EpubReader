package EpubReader;

import EBookLib.EBook;
import EBookLib.EBookWriter;
import EBookLib.Metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

class EdytujMetadane extends javax.swing.JDialog {
    private final EBook eBook;
    private final Document tmpContent;
    private final Metadata tmpMetadata;
    private final EBookWriter eBookWriter;
    
    public EdytujMetadane(EBook eBook, EBookWriter eBookWriter) throws IOException, CloneNotSupportedException {
        this.eBook = eBook;
        tmpContent = (Document) eBook.getContent().cloneNode(true);
        tmpMetadata = (Metadata)eBook.getMetadata().clone();
        this.eBookWriter = eBookWriter;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        creatorLabel = new javax.swing.JLabel();
        addCreatorButton = new javax.swing.JButton();
        removeCreatorButton = new javax.swing.JButton();
        cancellButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        publisherLabel = new javax.swing.JLabel();
        addPublisherButton = new javax.swing.JButton();
        removePublisherButton = new javax.swing.JButton();
        removeDateButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        addDateButton = new javax.swing.JButton();
        removeSubjectButton = new javax.swing.JButton();
        subjectsLabel = new javax.swing.JLabel();
        addSubjectButton = new javax.swing.JButton();
        sourceLabel = new javax.swing.JLabel();
        sourceText = new javax.swing.JTextField();
        removeRightButton = new javax.swing.JButton();
        rightsLabel = new javax.swing.JLabel();
        addRightButton = new javax.swing.JButton();
        languageLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox<>();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edytuj metadane");
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 348));

        creatorLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        creatorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        creatorLabel.setText("Autorzy");

        addCreatorButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addCreatorButton.setText("Dodaj");
        addCreatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCreatorButtonActionPerformed(evt);
            }
        });

        removeCreatorButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removeCreatorButton.setText("Usuń");
        removeCreatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCreatorButtonActionPerformed(evt);
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

        addPublisherButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addPublisherButton.setText("Dodaj");
        addPublisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherButtonActionPerformed(evt);
            }
        });

        removePublisherButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removePublisherButton.setText("Usuń");
        removePublisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePublisherButtonActionPerformed(evt);
            }
        });

        removeDateButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removeDateButton.setText("Usuń");
        removeDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDateButtonActionPerformed(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateLabel.setText("Daty");

        addDateButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addDateButton.setText("Dodaj");
        addDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDateButtonActionPerformed(evt);
            }
        });

        removeSubjectButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removeSubjectButton.setText("Usuń");
        removeSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSubjectButtonActionPerformed(evt);
            }
        });

        subjectsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subjectsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subjectsLabel.setText("Tematyka");

        addSubjectButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addSubjectButton.setText("Dodaj");
        addSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectButtonActionPerformed(evt);
            }
        });

        sourceLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sourceLabel.setText("Żródło");

        sourceText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sourceText.setText(eBook.getMetadata().getSource());

        removeRightButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removeRightButton.setText("Usuń");
        removeRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRightButtonActionPerformed(evt);
            }
        });

        rightsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rightsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rightsLabel.setText("Uprawnienia");

        addRightButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addRightButton.setText("Dodaj");
        addRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRightButtonActionPerformed(evt);
            }
        });

        languageLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        languageLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        languageLabel.setText("Język");

        languageComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        for(String lang : Locale.getISOLanguages()) {
            languageComboBox.addItem(lang.toUpperCase());
            if (lang.toUpperCase().equals(tmpMetadata.getLanguage())){
                languageComboBox.setSelectedItem(tmpMetadata.getLanguage());
            }
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancellButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addPublisherButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removePublisherButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(subjectsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(creatorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addDateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeDateButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addCreatorButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeCreatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addSubjectButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeSubjectButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(languageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rightsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sourceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addRightButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeRightButton))
                                    .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(creatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addCreatorButton)
                        .addComponent(removeCreatorButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPublisherButton)
                    .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removePublisherButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDateButton)
                    .addComponent(removeDateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSubjectButton)
                    .addComponent(removeSubjectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRightButton)
                    .addComponent(removeRightButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancellButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addCreatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCreatorButtonActionPerformed
        String creator = JOptionPane.showInputDialog(this, "Dodaj autora", null);
        tmpMetadata.addCreator(creator);
        eBookWriter.appendNode(tmpContent, "metadata", "dc:creator", null, creator, false);
    }//GEN-LAST:event_addCreatorButtonActionPerformed
    private void removeCreatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCreatorButtonActionPerformed
        if(tmpMetadata.getCreators().isEmpty()){
            JOptionPane.showMessageDialog(this, "Brak elemantów do usunięcia!");
        }else{
            ListItemSelection listItemSelection = new ListItemSelection(tmpContent, eBookWriter, tmpMetadata.getCreators());
            listItemSelection.setVisible(true);
        }
    }//GEN-LAST:event_removeCreatorButtonActionPerformed
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            if(!titleText.getText().equals(eBook.getMetadata().getTitle())){
                tmpMetadata.setTitle(titleText.getText());
                eBookWriter.updateNode(tmpContent, "metadata", "dc:title", titleText.getText());
            }
            if(!sourceText.getText().equals(eBook.getMetadata().getSource())){
                tmpMetadata.setSource(sourceText.getText());
                eBookWriter.updateNode(tmpContent, "metadata", "dc:source", sourceText.getText());
            }
            if(!(languageComboBox.getSelectedItem().toString().equals(tmpMetadata.getLanguage()))){
                tmpMetadata.setLanguage(languageComboBox.getSelectedItem().toString());
                eBookWriter.updateNode(tmpContent, "metadata", "dc:language", languageComboBox.getSelectedItem().toString().toLowerCase());
            }
            eBook.setMetadata(tmpMetadata);
            eBookWriter.saveContentChanges(tmpContent, "content.opf");
            dispose();
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(EdytujMetadane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void addPublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherButtonActionPerformed
        String publisher = JOptionPane.showInputDialog(this, "Dodaj wydawcę", null);
        tmpMetadata.addPublisher(publisher);
        eBookWriter.appendNode(tmpContent, "metadata", "dc:publisher", null, publisher, false);
    }//GEN-LAST:event_addPublisherButtonActionPerformed
    private void removePublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePublisherButtonActionPerformed
        if(tmpMetadata.getPublishers().isEmpty()){
            JOptionPane.showMessageDialog(this, "Brak elemantów do usunięcia!");
        }else{
            ListItemSelection listItemSelection = new ListItemSelection(tmpContent, eBookWriter, tmpMetadata.getPublishers());
            listItemSelection.setVisible(true);
        }
    }//GEN-LAST:event_removePublisherButtonActionPerformed
    private void removeDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDateButtonActionPerformed
        if(tmpMetadata.getDates().isEmpty()){
            JOptionPane.showMessageDialog(this, "Brak elemantów do usunięcia!");
        }else{
            Collection<String> dates = tmpMetadata.getDates().values();
            List<String> datesOnly = new ArrayList<>();
            dates.forEach((_item) -> {datesOnly.add(_item);
            });
            ListItemSelection listItemSelection = new ListItemSelection(tmpContent, eBookWriter, datesOnly);
            listItemSelection.setVisible(true);
        }
    }//GEN-LAST:event_removeDateButtonActionPerformed
    private void addDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDateButtonActionPerformed
        DateInput di = new DateInput(tmpContent, eBookWriter, tmpMetadata);
        di.setVisible(true);
    }//GEN-LAST:event_addDateButtonActionPerformed
    private void removeSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSubjectButtonActionPerformed
        if(tmpMetadata.getSubjects().isEmpty()){
            JOptionPane.showMessageDialog(this, "Brak elemantów do usunięcia!");
        }else{
            ListItemSelection listItemSelection = new ListItemSelection(tmpContent, eBookWriter, tmpMetadata.getSubjects());
            listItemSelection.setVisible(true);
        }
    }//GEN-LAST:event_removeSubjectButtonActionPerformed
    private void addSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectButtonActionPerformed
        String subject = JOptionPane.showInputDialog(this, "Dodaj temat", null);
        tmpMetadata.addSubject(subject);
        eBookWriter.appendNode(tmpContent, "metadata", "dc:subject", null, subject, false);
    }//GEN-LAST:event_addSubjectButtonActionPerformed
    private void removeRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRightButtonActionPerformed
        if(tmpMetadata.getRights().isEmpty()){
            JOptionPane.showMessageDialog(this, "Brak elemantów do usunięcia!");
        }else{
            ListItemSelection listItemSelection = new ListItemSelection(tmpContent, eBookWriter, tmpMetadata.getRights());
            listItemSelection.setVisible(true);
        }
    }//GEN-LAST:event_removeRightButtonActionPerformed
    private void addRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRightButtonActionPerformed
        String right = JOptionPane.showInputDialog(this, "Dodaj uprawnienie", null);
        tmpMetadata.addRight(right);
        eBookWriter.appendNode(tmpContent, "metadata", "dc:right", null, right, false);
    }//GEN-LAST:event_addRightButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCreatorButton;
    private javax.swing.JButton addDateButton;
    private javax.swing.JButton addPublisherButton;
    private javax.swing.JButton addRightButton;
    private javax.swing.JButton addSubjectButton;
    private javax.swing.JButton cancellButton;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JButton removeCreatorButton;
    private javax.swing.JButton removeDateButton;
    private javax.swing.JButton removePublisherButton;
    private javax.swing.JButton removeRightButton;
    private javax.swing.JButton removeSubjectButton;
    private javax.swing.JLabel rightsLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JTextField sourceText;
    private javax.swing.JLabel subjectsLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}