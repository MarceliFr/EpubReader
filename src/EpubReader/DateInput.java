package EpubReader;

import EBookLib.EBookWriter;
import EBookLib.Metadata;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.w3c.dom.Document;

public class DateInput extends javax.swing.JFrame {
    private final Document tmpContent;
    private final EBookWriter eBookWriter;
    private final Metadata tmpMetadata;
    private final DateFormat df;
    
    DateInput(Document tmpContent, EBookWriter eBookWriter, Metadata tmpMetadata) {
        this.tmpContent = tmpContent;
        this.eBookWriter = eBookWriter;
        this.tmpMetadata = tmpMetadata;
        df = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateText = new javax.swing.JFormattedTextField(df);
        datePropertyText = new javax.swing.JTextField();
        datePropertyLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        cancellButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodawanie daty");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        dateText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dateText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateTextKeyTyped(evt);
            }
        });

        datePropertyText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        datePropertyLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        datePropertyLabel.setText("Właściwość");

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dateLabel.setText("Data");

        cancellButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cancellButton.setText("Anuluj");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        saveButton.setText("Dodaj");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(datePropertyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancellButton))
                    .addComponent(dateText)
                    .addComponent(datePropertyText, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePropertyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePropertyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancellButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void dateTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateTextKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
            (c == KeyEvent.VK_BACK_SPACE) ||
            (c == KeyEvent.VK_DELETE) || (c == '-'))){
        //JOptionPane.showMessageDialog(null, "Wprowadź poprawną datę");
            evt.consume();
        }
    }//GEN-LAST:event_dateTextKeyTyped
    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if("".equals(datePropertyText.getText())){
            JOptionPane.showMessageDialog(this, "Data musi zawierać właściwość");
        }else{
            try {
                Date date = df.parse(dateText.getText());
                tmpMetadata.addDate(datePropertyText.getText(), date.toString());
                Map<String, String> dateMap = new HashMap<>();
                dateMap.put("opf:event", datePropertyText.getText());
                eBookWriter.appendNode(tmpContent, "metadata", "dc:date", dateMap, df.format(date), false);
                dispose();
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "nieprawidłowy format daty");
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancellButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel datePropertyLabel;
    private javax.swing.JTextField datePropertyText;
    private javax.swing.JFormattedTextField dateText;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}