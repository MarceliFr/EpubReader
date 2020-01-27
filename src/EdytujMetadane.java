
import java.io.IOException;
import javax.swing.JOptionPane;

class EdytujMetadane extends javax.swing.JDialog {
    private final EBook eBook;
    private final EBookWriter eBookWriter;
    
    public EdytujMetadane(EBook eBook) throws IOException {
        this.eBook = eBook;
        eBookWriter = new EBookWriter(eBook);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        creatorLabel = new javax.swing.JLabel();
        addCreator = new javax.swing.JButton();
        removeCreator = new javax.swing.JButton();

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
                .addContainerGap(310, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCreatorActionPerformed
        String creator = JOptionPane.showInputDialog(this, "Dodaj autora", null);
        eBook.getMetadata().addCreator(creator);
        eBookWriter.appendNode("metadata", "dc:creator", creator);
        //eBookWriter.saveMetadata();
    }//GEN-LAST:event_addCreatorActionPerformed

    private void removeCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCreatorActionPerformed
        ListItemSelection listItemSelection = new ListItemSelection(eBook, eBook.getMetadata().getCreators());
        listItemSelection.setVisible(true);
    }//GEN-LAST:event_removeCreatorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCreator;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton removeCreator;
    // End of variables declaration//GEN-END:variables
}