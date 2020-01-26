
import javax.swing.JOptionPane;

class EdytujMetadane extends javax.swing.JDialog {
    private final Metadata metadata;
    
    public EdytujMetadane(Metadata metadata) {
        this.metadata = metadata;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authorLabel = new javax.swing.JLabel();
        addAuthor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edytuj metadane");
        setAlwaysOnTop(true);

        authorLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        authorLabel.setText("Autor");

        addAuthor.setText("Dodaj");
        addAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addAuthor)
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(308, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAuthorActionPerformed
        String author = JOptionPane.showInputDialog(this, "Dodaj autora", null);
        
    }//GEN-LAST:event_addAuthorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAuthor;
    private javax.swing.JLabel authorLabel;
    // End of variables declaration//GEN-END:variables
}