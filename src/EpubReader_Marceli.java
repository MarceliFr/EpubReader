import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.text.html.HTMLEditorKit;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class EpubReader_Marceli extends javax.swing.JFrame {
    private final javax.swing.JFileChooser jfc = new JFileChooser();
    private EBook eBook;
    private String path;
    
    public EpubReader_Marceli() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane5 = new javax.swing.JScrollPane();
        eBookText = new javax.swing.JEditorPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        plikiTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        spineList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        guideList = new javax.swing.JList<>();
        mainMenu = new javax.swing.JMenuBar();
        menuPlik = new javax.swing.JMenu();
        plikZnajdzPublikacje = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        plikZamknij = new javax.swing.JMenuItem();
        menuPublikacja = new javax.swing.JMenu();
        publikacjaDodajOkladke = new javax.swing.JMenuItem();
        showMetadane = new javax.swing.JMenuItem();
        publikacjaEdytujMetadane = new javax.swing.JMenuItem();
        menuNawigacja = new javax.swing.JMenu();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EpubReader Marceli");

        jToolBar1.setRollover(true);

        eBookText.setEditable(false);
        eBookText.setEditorKit(kit);
        eBookText.setOpaque(true);
        jScrollPane5.setViewportView(eBookText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(160, 70));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(160, 100));

        jScrollPane1.setViewportView(plikiTree);

        jTabbedPane1.addTab("Pliki", jScrollPane1);

        spineList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        spineList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                spineListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(spineList);

        jTabbedPane1.addTab("Spine", jScrollPane2);

        guideList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        guideList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                guideListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(guideList);

        jTabbedPane1.addTab("Guide", jScrollPane3);

        jSplitPane1.setLeftComponent(jTabbedPane1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        menuPlik.setMnemonic('P');
        menuPlik.setText("Plik");

        plikZnajdzPublikacje.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK));
        plikZnajdzPublikacje.setMnemonic('Z');
        plikZnajdzPublikacje.setText("Znajdź publikację");
        plikZnajdzPublikacje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plikZnajdzPublikacjeActionPerformed(evt);
            }
        });
        menuPlik.add(plikZnajdzPublikacje);

        jMenuItem1.setText("Zamknij publikację");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuPlik.add(jMenuItem1);
        menuPlik.add(jSeparator1);

        plikZamknij.setText("Zamknij");
        plikZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plikZamknijActionPerformed(evt);
            }
        });
        menuPlik.add(plikZamknij);

        mainMenu.add(menuPlik);

        menuPublikacja.setMnemonic('U');
        menuPublikacja.setText("Publikacja");
        if (eBook == null){
            menuPublikacja.setEnabled(false);
        }

        publikacjaDodajOkladke.setText("Dodaj okładkę");
        menuPublikacja.add(publikacjaDodajOkladke);

        showMetadane.setText("Pokaż metadane");
        showMetadane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMetadaneActionPerformed(evt);
            }
        });
        menuPublikacja.add(showMetadane);

        publikacjaEdytujMetadane.setText("Edytuj metadane");
        publikacjaEdytujMetadane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publikacjaEdytujMetadaneActionPerformed(evt);
            }
        });
        menuPublikacja.add(publikacjaEdytujMetadane);

        mainMenu.add(menuPublikacja);

        menuNawigacja.setMnemonic('N');
        menuNawigacja.setText("Nawigacja");
        mainMenu.add(menuNawigacja);

        setJMenuBar(mainMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plikZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plikZamknijActionPerformed
        System.exit(0);
    }//GEN-LAST:event_plikZamknijActionPerformed

    private void plikZnajdzPublikacjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plikZnajdzPublikacjeActionPerformed
        jfc.showOpenDialog(null);
        jfc.setName("Znadjowanie E-Booków");
        path = jfc.getSelectedFile().getAbsolutePath();
        try {
            eBook = new EBook(path);
            List<String> pliki = eBook.wypelnij_plikiTree();
//            for(int i=0;i<pliki.size();i++){
//                System.out.println(pliki.get(i));
//            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultListModel lm1 = new DefaultListModel();
        Set<String> spineKeys = eBook.wypelnij_spine();
        spineList.setModel(lm1);
        spineKeys.forEach((_item) -> {lm1.addElement(_item);
        });
        
        DefaultListModel lm2 = new DefaultListModel();
        Set<String> guideKeys = eBook.wypelnij_guide();
        guideList.setModel(lm2);
        guideKeys.forEach((_item) -> {lm2.addElement(_item);
        });
        
        menuPublikacja.setEnabled(true);
        //jLabel1.setText(eBook.getTitle());
    }//GEN-LAST:event_plikZnajdzPublikacjeActionPerformed

    private void publikacjaEdytujMetadaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publikacjaEdytujMetadaneActionPerformed
        EdytujMetadane edytujMetadane = new EdytujMetadane(eBook);
        edytujMetadane.setVisible(true);
    }//GEN-LAST:event_publikacjaEdytujMetadaneActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        eBook.close();
        menuPublikacja.setEnabled(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void spineListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_spineListValueChanged
        try {
            String text = eBook.readTextFromSpine(((JList)evt.getSource()).getSelectedValue().toString());
            eBookText.setText(text);
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_spineListValueChanged

    private void guideListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_guideListValueChanged
        try {
            String text = eBook.readTextFromGuide(((JList)evt.getSource()).getSelectedValue().toString());
            eBookText.setText(text);
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guideListValueChanged

    private void showMetadaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMetadaneActionPerformed
        PokazMetadane pokazMetadane = new PokazMetadane(eBook);
        pokazMetadane.setVisible(true);
    }//GEN-LAST:event_showMetadaneActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EpubReader_Marceli().setVisible(true);
        });
    }
    private final HTMLEditorKit kit = new HTMLEditorKit();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane eBookText;
    private javax.swing.JList<String> guideList;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenu menuNawigacja;
    private javax.swing.JMenu menuPlik;
    private javax.swing.JMenu menuPublikacja;
    private javax.swing.JMenuItem plikZamknij;
    private javax.swing.JMenuItem plikZnajdzPublikacje;
    private javax.swing.JTree plikiTree;
    private javax.swing.JMenuItem publikacjaDodajOkladke;
    private javax.swing.JMenuItem publikacjaEdytujMetadane;
    private javax.swing.JMenuItem showMetadane;
    private javax.swing.JList<String> spineList;
    // End of variables declaration//GEN-END:variables
}