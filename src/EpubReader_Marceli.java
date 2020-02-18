import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class EpubReader_Marceli extends javax.swing.JFrame {
    private EBookReader eBookReader;
    private EBook eBook;
    private String path;
    
    public EpubReader_Marceli() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        fontToolBar = new javax.swing.JToolBar();
        fontChoose = new javax.swing.JComboBox<>();
        fontSizeSpinner = new javax.swing.JSpinner();
        fontColor = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        eBookText = new javax.swing.JTextArea();
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

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EpubReader Marceli");

        fontToolBar.setRollover(true);
        fontToolBar.setEnabled(false);

        fontChoose.setEnabled(false);
        fontChoose.setMaximumSize(new java.awt.Dimension(128, 22));
        fontChoose.setMinimumSize(new java.awt.Dimension(128, 22));
        fontChoose.setPreferredSize(new java.awt.Dimension(128, 22));
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(int i=0; i<fonts.length; i++ ){
            fontChoose.addItem(fonts[i]);
        }
        fontChoose.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fontChooseItemStateChanged(evt);
            }
        });
        fontToolBar.add(fontChoose);

        fontSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(14, 8, 150, 2));
        fontSizeSpinner.setToolTipText("Rozmiar czcionki");
        fontSizeSpinner.setMaximumSize(new java.awt.Dimension(64, 22));
        fontSizeSpinner.setMinimumSize(new java.awt.Dimension(64, 22));
        fontSizeSpinner.setPreferredSize(new java.awt.Dimension(64, 22));
        fontSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fontSizeSpinnerStateChanged(evt);
            }
        });
        fontToolBar.add(fontSizeSpinner);

        fontColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fontColor.setMaximumSize(new java.awt.Dimension(64, 22));
        fontToolBar.add(fontColor);

        eBookText.setColumns(20);
        eBookText.setRows(5);
        eBookText.setLineWrap(true);
        eBookText.setWrapStyleWord(true);
        jScrollPane4.setViewportView(eBookText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fontToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(fontToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(160, 70));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(160, 100));

        jScrollPane1.setViewportView(plikiTree);

        jTabbedPane1.addTab("Pliki", jScrollPane1);

        spineList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spineListModel = new DefaultListModel();
        spineList.setModel(spineListModel);
        spineList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                spineListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(spineList);

        jTabbedPane1.addTab("Spine", jScrollPane2);

        guideList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        guideListModel = new DefaultListModel();
        guideList.setModel(guideListModel);
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
        jfc = new javax.swing.JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("eBook", "epub", "zip");
        jfc.addChoosableFileFilter(fnef);
        jfc.setFileFilter(fnef);
        jfc.showOpenDialog(null);
        jfc.setName("Znadjowanie E-Booków");
        path = jfc.getSelectedFile().getAbsolutePath();
        try {
            eBookReader = new EBookReader(path);
            if(eBookReader.isEBook(path) == true){
                eBook = eBookReader.readEBook();
            }
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<String> spineKeys = eBook.getSpineKeys();
        spineKeys.forEach((_item) -> {spineListModel.addElement(_item);
        });
        Set<String> guideKeys = eBook.getGuideKeys();
        guideKeys.forEach((_item) -> {guideListModel.addElement(_item);
        });
        fontToolBar.setEnabled(true);
        fontChoose.setEnabled(true);
        fontSizeSpinner.setEnabled(true);
        menuPublikacja.setEnabled(true);
    }//GEN-LAST:event_plikZnajdzPublikacjeActionPerformed
    private void publikacjaEdytujMetadaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publikacjaEdytujMetadaneActionPerformed
        try {
            EdytujMetadane edytujMetadane = new EdytujMetadane(eBook);
            edytujMetadane.setVisible(true);
        } catch (IOException | CloneNotSupportedException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_publikacjaEdytujMetadaneActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            spineListModel.removeAllElements();
            guideListModel.removeAllElements();
            fontToolBar.setEnabled(false);
            fontChoose.setEnabled(false);
            fontSizeSpinner.setEnabled(false);
            menuPublikacja.setEnabled(false);
            eBookText.setText(null);
            eBook.close();
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void spineListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_spineListValueChanged
        try {
            if(((javax.swing.JList)evt.getSource()).getSelectedValue() != null){
                System.out.println();
                String text = eBookReader.readTextFromSpine(((javax.swing.JList)evt.getSource()).getSelectedValue().toString());
                eBookText.setText(text);
            }
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Plik uszkodzony lub odnościk nieczytelny");
        }
    }//GEN-LAST:event_spineListValueChanged
    private void guideListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_guideListValueChanged
        try {
            if(((javax.swing.JList)evt.getSource()).getSelectedValue() != null){
                String text = eBookReader.readTextFromGuide(((javax.swing.JList)evt.getSource()).getSelectedValue().toString());
                eBookText.setText(text);
            }
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Plik uszkodzony lub odnościk nieczytelny");
        }
    }//GEN-LAST:event_guideListValueChanged
    private void showMetadaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMetadaneActionPerformed
        PokazMetadane pokazMetadane = new PokazMetadane(eBook);
        pokazMetadane.setVisible(true);
    }//GEN-LAST:event_showMetadaneActionPerformed
    private void fontSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fontSizeSpinnerStateChanged
        Font textFont = eBookText.getFont();
        Font newTextFont = new Font(eBookText.getFont().getFontName(), eBookText.getFont().getStyle(), (int) fontSizeSpinner.getValue());
        eBookText.setFont(newTextFont);
    }//GEN-LAST:event_fontSizeSpinnerStateChanged
    private void fontChooseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fontChooseItemStateChanged
        String newFontName = fontChoose.getSelectedItem().toString();
        System.out.println(newFontName);
        Font newTextFont = new Font(newFontName, eBookText.getFont().getStyle(), eBookText.getFont().getSize());
        eBookText.setFont(newTextFont);
    }//GEN-LAST:event_fontChooseItemStateChanged
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EpubReader_Marceli().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea eBookText;
    private javax.swing.JComboBox<String> fontChoose;
    private javax.swing.JComboBox<String> fontColor;
    private javax.swing.JSpinner fontSizeSpinner;
    private javax.swing.JToolBar fontToolBar;
    private javax.swing.JList<String> guideList;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JFileChooser jfc;
    private DefaultListModel spineListModel;
    private DefaultListModel guideListModel;
}