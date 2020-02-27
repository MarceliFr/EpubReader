package EpubReader;

import EBookLib.EBookWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddChapter extends javax.swing.JFrame {
    private final EBookWriter eBookWriter;
    
    public AddChapter(EBookWriter eBookWriter) {
        this.eBookWriter = eBookWriter;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chapterFileChooser = new javax.swing.JFileChooser();
        chapterNameTextField = new javax.swing.JTextField();
        addToGuideCheckBox = new javax.swing.JCheckBox();
        cancellButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        chapterFileChooser.setControlButtonsAreShown(false);
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("cover", "html");
        chapterFileChooser.addChoosableFileFilter(fnef);
        chapterFileChooser.setFileFilter(fnef);

        chapterNameTextField.setText("Nazwa rozdziały");
        chapterNameTextField.setMinimumSize(new java.awt.Dimension(99, 22));

        addToGuideCheckBox.setText("Dołącz do guide");

        cancellButton.setText("Anuluj");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        addButton.setText("Dodaj");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Nazwa rozdziału");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chapterFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chapterNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToGuideCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancellButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chapterFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chapterNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToGuideCheckBox)
                    .addComponent(cancellButton)
                    .addComponent(addButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBox addToGuideCheckBox;
    private javax.swing.JButton cancellButton;
    private javax.swing.JFileChooser chapterFileChooser;
    private javax.swing.JTextField chapterNameTextField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
