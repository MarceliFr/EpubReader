package EpubReader;

import EBookLib.EBook;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokazMetadane extends javax.swing.JDialog {
    private final EBook eBook;
        
    public PokazMetadane(EBook eBook) {
        this.eBook = eBook;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        creatorsText = new javax.swing.JTextArea();
        creatorsLabel = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        publishersLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        subjectsText = new javax.swing.JTextArea();
        subjectsLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        publishersText = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        rightsText = new javax.swing.JTextArea();
        rightsLabel = new javax.swing.JLabel();
        languageText = new javax.swing.JTextField();
        sourceLabel = new javax.swing.JLabel();
        languageLabel = new javax.swing.JLabel();
        sourceText = new javax.swing.JTextField();
        editButtom = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        datesText = new javax.swing.JTextArea();
        datesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pokaż metadane");
        setResizable(false);
        setSize(new java.awt.Dimension(463, 486));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleLabel.setText("Tytuł");

        creatorsText.setEditable(false);
        creatorsText.setBackground(new java.awt.Color(240, 240, 240));
        creatorsText.setColumns(20);
        creatorsText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        creatorsText.setRows(3);
        creatorsText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        creatorsText.setEnabled(false);
        creatorsText.setMaximumSize(new java.awt.Dimension(284, 64));
        if(eBook.getMetadata().getCreators() != null){
            for(int i=0;i<eBook.getMetadata().getCreators().size();i++){
                if(i == (eBook.getMetadata().getCreators().size())-1){
                    creatorsText.append(eBook.getMetadata().getCreators().get(i));
                }else{
                    creatorsText.append(eBook.getMetadata().getCreators().get(i) + "\n");
                }
            }
        }
        jScrollPane2.setViewportView(creatorsText);

        creatorsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        creatorsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        creatorsLabel.setText("Autorzy");

        titleText.setEditable(false);
        titleText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        titleText.setEnabled(false);
        titleText.setMaximumSize(new java.awt.Dimension(6, 26));
        titleText.setText(eBook.getMetadata().getTitle());

        publishersLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publishersLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        publishersLabel.setText("Wydawcy");

        subjectsText.setEditable(false);
        subjectsText.setBackground(new java.awt.Color(240, 240, 240));
        subjectsText.setColumns(20);
        subjectsText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subjectsText.setRows(3);
        subjectsText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        subjectsText.setEnabled(false);
        if(eBook.getMetadata().getSubjects() != null){
            for(int i=0;i<eBook.getMetadata().getSubjects().size();i++){
                if(i == (eBook.getMetadata().getSubjects().size())-1){
                    subjectsText.append(eBook.getMetadata().getSubjects().get(i));
                }else{
                    subjectsText.append(eBook.getMetadata().getSubjects().get(i) + "\n");
                }
            }
        }
        jScrollPane4.setViewportView(subjectsText);

        subjectsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subjectsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subjectsLabel.setText("Tematy");
        subjectsLabel.setMaximumSize(new java.awt.Dimension(66, 20));
        subjectsLabel.setMinimumSize(new java.awt.Dimension(66, 20));

        publishersText.setEditable(false);
        publishersText.setBackground(new java.awt.Color(240, 240, 240));
        publishersText.setColumns(20);
        publishersText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publishersText.setRows(3);
        publishersText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        publishersText.setEnabled(false);
        publishersText.setMaximumSize(new java.awt.Dimension(284, 64));
        if(eBook.getMetadata().getPublishers()!= null){
            for(int i=0;i<eBook.getMetadata().getPublishers().size();i++){
                if(i == (eBook.getMetadata().getPublishers().size())-1){
                    publishersText.append(eBook.getMetadata().getPublishers().get(i));
                }else{
                    publishersText.append(eBook.getMetadata().getPublishers().get(i) + "\n");
                }
            }
        }
        jScrollPane5.setViewportView(publishersText);

        rightsText.setEditable(false);
        rightsText.setBackground(new java.awt.Color(240, 240, 240));
        rightsText.setColumns(20);
        rightsText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rightsText.setRows(3);
        rightsText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        rightsText.setEnabled(false);
        if(eBook.getMetadata().getRights() != null){
            for(int i=0;i<eBook.getMetadata().getRights().size();i++){
                if(i == (eBook.getMetadata().getRights().size())-1){
                    rightsText.append(eBook.getMetadata().getRights().get(i));
                }else{
                    rightsText.append(eBook.getMetadata().getRights().get(i) + "\n");
                }
            }
        }
        jScrollPane6.setViewportView(rightsText);

        rightsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rightsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rightsLabel.setText("Prawa");
        rightsLabel.setMaximumSize(new java.awt.Dimension(66, 20));
        rightsLabel.setMinimumSize(new java.awt.Dimension(66, 20));

        languageText.setEditable(false);
        languageText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        languageText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        languageText.setEnabled(false);
        languageText.setMaximumSize(new java.awt.Dimension(6, 26));
        languageText.setText(eBook.getMetadata().getLanguage());

        sourceLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sourceLabel.setText("Żródło");

        languageLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        languageLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        languageLabel.setText("Język");

        sourceText.setEditable(false);
        sourceText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sourceText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sourceText.setEnabled(false);
        sourceText.setMaximumSize(new java.awt.Dimension(6, 26));
        sourceText.setText(eBook.getMetadata().getSource());

        editButtom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        editButtom.setText("Edytuj");
        editButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtomActionPerformed(evt);
            }
        });

        datesText.setEditable(false);
        datesText.setBackground(new java.awt.Color(240, 240, 240));
        datesText.setColumns(20);
        datesText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        datesText.setRows(3);
        datesText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        datesText.setEnabled(false);
        datesText.setMaximumSize(new java.awt.Dimension(284, 64));
        if(eBook.getMetadata().getDates() != null){
            for(Object key : eBook.getMetadata().getDates().keySet()){
                datesText.append(key + ": " + eBook.getMetadata().getDates().get(key).toString() + "\n");
            }
        }
        jScrollPane7.setViewportView(datesText);

        datesLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        datesLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        datesLabel.setText("Daty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subjectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creatorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publishersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(languageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rightsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sourceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(languageText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(editButtom))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(creatorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publishersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(subjectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sourceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(languageLabel)
                    .addComponent(editButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(languageText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtomActionPerformed
        try {
            EdytujMetadane edytujMetadane = new EdytujMetadane(eBook);
            edytujMetadane.setVisible(true);
            dispose();
        } catch (IOException | CloneNotSupportedException ex) {
            Logger.getLogger(PokazMetadane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editButtomActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creatorsLabel;
    private javax.swing.JTextArea creatorsText;
    private javax.swing.JLabel datesLabel;
    private javax.swing.JTextArea datesText;
    private javax.swing.JButton editButtom;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JTextField languageText;
    private javax.swing.JLabel publishersLabel;
    private javax.swing.JTextArea publishersText;
    private javax.swing.JLabel rightsLabel;
    private javax.swing.JTextArea rightsText;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JTextField sourceText;
    private javax.swing.JLabel subjectsLabel;
    private javax.swing.JTextArea subjectsText;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}