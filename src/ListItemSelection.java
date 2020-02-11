import java.util.List;
import javax.swing.DefaultListModel;
import org.w3c.dom.Document;

public class ListItemSelection extends javax.swing.JFrame {
    private Document tmpContent;
    private final List<String> items;

    ListItemSelection(Document tmpContent, List<String> items) {
        this.tmpContent = tmpContent;
        this.items = items;
        initComponents();
        DefaultListModel lm1 = new DefaultListModel();
        itemList.setModel(lm1);
        for(int i=0;i<items.size();i++){
            lm1.addElement(items.get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList<>();
        removeElement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wybierz element");
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(321, 153));

        itemList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        itemList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(itemList);

        removeElement.setText("Usuń element");
        removeElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeElementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeElement)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeElement)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeElementActionPerformed
        EBookWriter eBookWriter = new EBookWriter();
        tmpContent = eBookWriter.removeNode(tmpContent, "metadata", itemList.getSelectedValue());
        for(int i=0;i<items.size();i++){
            if(items.get(i).equals(itemList.getSelectedValue())){
                items.remove(i);
                break;
            }
        }
        dispose();
    }//GEN-LAST:event_removeElementActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> itemList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeElement;
    // End of variables declaration//GEN-END:variables
}