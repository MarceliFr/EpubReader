public class PokazMetadane extends javax.swing.JFrame {
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
        dateText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        publishersText = new javax.swing.JTextArea();
        date = new javax.swing.JLabel();
        publishers = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        subjectsText = new javax.swing.JTextArea();
        subjects = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokaż metadane");

        title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        title.setText("Tytuł");

        creatorsText.setEditable(false);
        creatorsText.setBackground(new java.awt.Color(240, 240, 240));
        creatorsText.setColumns(20);
        creatorsText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        creatorsText.setRows(3);
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
        titleText.setMaximumSize(new java.awt.Dimension(6, 26));
        titleText.setText(eBook.getMetadata().getTitle());

        dateText.setEditable(false);
        dateText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dateText.setMaximumSize(new java.awt.Dimension(6, 26));
        dateText.setText(eBook.getMetadata().getDate());

        publishersText.setEditable(false);
        publishersText.setBackground(new java.awt.Color(240, 240, 240));
        publishersText.setColumns(20);
        publishersText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publishersText.setRows(3);
        if(eBook.getMetadata().getPublishers() != null){
            for(int i=0;i<eBook.getMetadata().getPublishers().size();i++){
                if(i == (eBook.getMetadata().getPublishers().size())-1){
                    publishersText.append(eBook.getMetadata().getPublishers().get(i));
                }else{
                    publishersText.append(eBook.getMetadata().getPublishers().get(i) + "\n");
                }
            }
        }
        jScrollPane3.setViewportView(publishersText);

        date.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date.setText("Data");

        publishers.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publishers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        publishers.setText("Wydawcy");

        subjectsText.setEditable(false);
        subjectsText.setBackground(new java.awt.Color(240, 240, 240));
        subjectsText.setColumns(20);
        subjectsText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subjectsText.setRows(3);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publishers, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(creators, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(publishers, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creators;
    private javax.swing.JTextArea creatorsText;
    private javax.swing.JLabel date;
    private javax.swing.JTextField dateText;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel publishers;
    private javax.swing.JTextArea publishersText;
    private javax.swing.JLabel subjects;
    private javax.swing.JTextArea subjectsText;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}
