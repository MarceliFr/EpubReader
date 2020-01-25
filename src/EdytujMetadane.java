class EdytujMetadane extends javax.swing.JDialog {
    private final EBook eBook;
    
    public EdytujMetadane(EBook eBook) {
        this.eBook = eBook;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        publisherLabel = new javax.swing.JLabel();
        temetyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edytuj metadane");
        setAlwaysOnTop(true);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleLabel.setText("Tytył");

        titleText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleText.setText(eBook.getMetadata().getTitle());

        authorLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        authorLabel.setText("Autor");

        publisherLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        publisherLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        publisherLabel.setText("Publisher");

        temetyLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        temetyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        temetyLabel.setText("Tematyka");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publisherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addGap(292, 292, 292))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(temetyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addGap(292, 292, 292))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(authorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(publisherLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temetyLabel)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JLabel temetyLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}