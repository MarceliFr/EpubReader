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

        title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        creatorsText = new javax.swing.JTextArea();
        creators = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        publishers = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        subjectsText = new javax.swing.JTextArea();
        subjects = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        publishersText = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        rightsText = new javax.swing.JTextArea();
        rights = new javax.swing.JLabel();
        languageText = new javax.swing.JTextField();
        source = new javax.swing.JLabel();
        language = new javax.swing.JLabel();
        sourceText = new javax.swing.JTextField();
        editButtom = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        datesText = new javax.swing.JTextArea();
        dates = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pokaż metadane");
        setResizable(false);
        setSize(new java.awt.Dimension(463, 486));

        title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        title.setText("Tytuł");

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

        creators.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        creators.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        creators.setText("Autorzy");

        titleText.setEditable(false);
        titleText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        titleText.setEnabled(false);
        titleText.setMaximumSize(new java.awt.Dimension(6, 26));
        titleText.setText(eBook.getMetadata().getTitle());

        publishers.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publishers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        publishers.setText("Wydawcy");

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

        subjects.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subjects.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subjects.setText("Tematy");
        subjects.setMaximumSize(new java.awt.Dimension(66, 20));
        subjects.setMinimumSize(new java.awt.Dimension(66, 20));

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

        rights.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rights.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rights.setText("Prawa");
        rights.setMaximumSize(new java.awt.Dimension(66, 20));
        rights.setMinimumSize(new java.awt.Dimension(66, 20));

        languageText.setEditable(false);
        languageText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        languageText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        languageText.setEnabled(false);
        languageText.setMaximumSize(new java.awt.Dimension(6, 26));
        languageText.setText(eBook.getMetadata().getLanguage());

        source.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        source.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        source.setText("Żródło");

        language.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        language.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        language.setText("Język");

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
            for(int i=0;i<eBook.getMetadata().getDates().size();i++){
                if(i == (eBook.getMetadata().getDates().size())-1){
                    datesText.append(eBook.getMetadata().getDates().get(i));
                }else{
                    datesText.append(eBook.getMetadata().getDates().get(i) + "\n");
                }
            }
        }
        jScrollPane7.setViewportView(datesText);

        dates.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dates.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dates.setText("Daty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creators, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publishers, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(language, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rights, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(source, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(languageText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(editButtom))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dates, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(creators, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publishers, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dates, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(source, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rights, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(language)
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
        } catch (IOException ex) {
            Logger.getLogger(PokazMetadane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editButtomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creators;
    private javax.swing.JTextArea creatorsText;
    private javax.swing.JLabel dates;
    private javax.swing.JTextArea datesText;
    private javax.swing.JButton editButtom;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel language;
    private javax.swing.JTextField languageText;
    private javax.swing.JLabel publishers;
    private javax.swing.JTextArea publishersText;
    private javax.swing.JLabel rights;
    private javax.swing.JTextArea rightsText;
    private javax.swing.JLabel source;
    private javax.swing.JTextField sourceText;
    private javax.swing.JLabel subjects;
    private javax.swing.JTextArea subjectsText;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}