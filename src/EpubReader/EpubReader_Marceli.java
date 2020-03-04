package EpubReader;

import EBookLib.EBook;
import EBookLib.EBookFactory;
import EBookLib.EBookReader;
import EBookLib.EBookWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class EpubReader_Marceli extends javax.swing.JFrame {
    private EBookReader eBookReader;
    private EBookWriter eBookWriter;
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
        fontColorButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        eBookText = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        spineList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        guideList = new javax.swing.JList<>();
        mainMenu = new javax.swing.JMenuBar();
        menuPlik = new javax.swing.JMenu();
        plikZnajdzPublikacje = new javax.swing.JMenuItem();
        plikZamknijPublikacje = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        plikZamknij = new javax.swing.JMenuItem();
        menuPublikacja = new javax.swing.JMenu();
        publikacjaDodajOkladke = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        publikacjaDodajRozdzial = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        showMetadane = new javax.swing.JMenuItem();
        publikacjaEdytujMetadane = new javax.swing.JMenuItem();
        menuNawigacja = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        fontSizeSpinner.setEnabled(false);
        fontSizeSpinner.setMaximumSize(new java.awt.Dimension(64, 22));
        fontSizeSpinner.setMinimumSize(new java.awt.Dimension(64, 22));
        fontSizeSpinner.setPreferredSize(new java.awt.Dimension(64, 22));
        fontSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fontSizeSpinnerStateChanged(evt);
            }
        });
        fontToolBar.add(fontSizeSpinner);

        fontColorButton.setText("Zmień kolor");
        fontColorButton.setEnabled(false);
        fontColorButton.setFocusable(false);
        fontColorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fontColorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fontColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontColorButtonActionPerformed(evt);
            }
        });
        fontToolBar.add(fontColorButton);

        eBookText.setEditable(false);
        eBookText.setColumns(20);
        eBookText.setRows(5);
        eBookText.setDisabledTextColor(new java.awt.Color(255, 255, 255));
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(160, 70));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(160, 100));

        filesListModel = new DefaultListModel();
        filesList.setModel(filesListModel);
        filesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                filesListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(filesList);

        jTabbedPane1.addTab("Pliki", jScrollPane5);

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

        plikZamknijPublikacje.setText("Zamknij publikację");
        plikZamknijPublikacje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plikZamknijPublikacjeActionPerformed(evt);
            }
        });
        menuPlik.add(plikZamknijPublikacje);
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
        publikacjaDodajOkladke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publikacjaDodajOkladkeActionPerformed(evt);
            }
        });
        menuPublikacja.add(publikacjaDodajOkladke);
        menuPublikacja.add(jSeparator2);

        publikacjaDodajRozdzial.setText("Dodaj rozdział");
        publikacjaDodajRozdzial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publikacjaDodajRozdzialActionPerformed(evt);
            }
        });
        menuPublikacja.add(publikacjaDodajRozdzial);
        menuPublikacja.add(jSeparator3);

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
        if (eBook == null){
            menuNawigacja.setEnabled(false);
        }

        jMenuItem3.setText("Utwórz sekcję Guide");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuNawigacja.add(jMenuItem3);

        jMenuItem1.setText("Edytuj sekcję Spine");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuNawigacja.add(jMenuItem1);

        mainMenu.add(menuNawigacja);

        setJMenuBar(mainMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void plikZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plikZamknijActionPerformed
        try {
            eBook.close();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            EBookFactory eBookFactory = new EBookFactory();
            if(eBookFactory.isEBook(path) == true){
                eBook = eBookFactory.readEBook(path);
            }
            eBookReader = new EBookReader(eBook);
            eBookWriter = new EBookWriter(eBook);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
        load();
        fontToolBar.setEnabled(true);
        fontChoose.setEnabled(true);
        fontSizeSpinner.setEnabled(true);
        fontColorButton.setEnabled(true);
        menuPublikacja.setEnabled(true);
        menuNawigacja.setEnabled(true);
    }//GEN-LAST:event_plikZnajdzPublikacjeActionPerformed
    private void publikacjaEdytujMetadaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publikacjaEdytujMetadaneActionPerformed
        try {
            EdytujMetadane edytujMetadane = new EdytujMetadane(eBook, eBookWriter);
            edytujMetadane.setVisible(true);
        } catch (IOException | CloneNotSupportedException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_publikacjaEdytujMetadaneActionPerformed
    private void plikZamknijPublikacjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plikZamknijPublikacjeActionPerformed
        try {
            filesListModel.removeAllElements();
            spineListModel.removeAllElements();
            guideListModel.removeAllElements();
            fontToolBar.setEnabled(false);
            fontChoose.setEnabled(false);
            fontSizeSpinner.setEnabled(false);
            fontColorButton.setEnabled(false);
            menuPublikacja.setEnabled(false);
            menuNawigacja.setEnabled(false);
            eBookText.setText(null);
            eBook.close();
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_plikZamknijPublikacjeActionPerformed
    private void spineListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_spineListValueChanged
        try {
            if(((javax.swing.JList)evt.getSource()).getSelectedValue() != null){
                String text = eBookReader.readTextFromSpine(((javax.swing.JList)evt.getSource()).getSelectedValue().toString());
                eBookText.setText(text);
            }
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Plik uszkodzony lub odnościk nieczytelny", "Błąd odczytu", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "Plik uszkodzony lub odnościk nieczytelny", "Błąd odczytu", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guideListValueChanged
    private void showMetadaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMetadaneActionPerformed
        PokazMetadane pokazMetadane = new PokazMetadane(eBook, eBookWriter);
        pokazMetadane.setVisible(true);
    }//GEN-LAST:event_showMetadaneActionPerformed
    private void fontSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fontSizeSpinnerStateChanged
        Font textFont = eBookText.getFont();
        Font newTextFont = new Font(eBookText.getFont().getFontName(), eBookText.getFont().getStyle(), (int) fontSizeSpinner.getValue());
        eBookText.setFont(newTextFont);
    }//GEN-LAST:event_fontSizeSpinnerStateChanged
    private void fontChooseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fontChooseItemStateChanged
        String newFontName = fontChoose.getSelectedItem().toString();
        Font newTextFont = new Font(newFontName, eBookText.getFont().getStyle(), eBookText.getFont().getSize());
        eBookText.setFont(newTextFont);
    }//GEN-LAST:event_fontChooseItemStateChanged
    private void publikacjaDodajOkladkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publikacjaDodajOkladkeActionPerformed
        if(!eBook.hasCover()){
            try {
                jfc = new javax.swing.JFileChooser();
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("cover", "jpeg", "jpg");
                jfc.addChoosableFileFilter(fnef);
                jfc.setFileFilter(fnef);
                jfc.showOpenDialog(null);
                jfc.setName("Dodawanie okładki");
                String coverpath = jfc.getSelectedFile().getAbsolutePath();
                BufferedImage bimg = ImageIO.read(new File(coverpath));
                int width = bimg.getWidth();
                int height = bimg.getHeight();
                eBookWriter.createCoverPage(width, height, jfc.getSelectedFile().getName());
                Document tmpContent = (Document) eBook.getContent().cloneNode(true);
                
                Map<String, String> metadataNodeArguments = new HashMap<>();
                metadataNodeArguments.put("name", "cover");
                metadataNodeArguments.put("content", "cover");
                eBookWriter.appendNode(tmpContent, "metadata", "meta", metadataNodeArguments, "", false);
                
                Map<String, String> spineNodeArguments = new HashMap<>();
                spineNodeArguments.put("idref", "cover");
                eBookWriter.appendNode(tmpContent, "spine", "itemref", spineNodeArguments, "", true);
                
                Map<String, String> manifestNodeArguments = new HashMap<>();
                manifestNodeArguments.put("id", "cover");
                manifestNodeArguments.put("href", "cover.xhtml");
                manifestNodeArguments.put("media-type", "application/xhtml+xml");
                
                eBookWriter.appendNode(tmpContent, "manifest", "item", manifestNodeArguments, "", false);
                eBookWriter.saveContentChanges(tmpContent, "content.opf");
                eBookWriter.appendFile(coverpath);
                eBook.addToSpineMap("Cover", jfc.getSelectedFile().getName());
                load();
                
            } catch (IOException | TransformerException | ParserConfigurationException ex) {
                Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Książka ma już okładkę");
        }
    }//GEN-LAST:event_publikacjaDodajOkladkeActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            if(eBook != null){
                eBook.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing
    private void publikacjaDodajRozdzialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publikacjaDodajRozdzialActionPerformed
        AddChapter addChapter = new AddChapter(eBookWriter, eBook);
        addChapter.setVisible(true);
        addChapter.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                load();
            }
        });
    }//GEN-LAST:event_publikacjaDodajRozdzialActionPerformed
    private void fontColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontColorButtonActionPerformed
        Color newColor = null;
        newColor = JColorChooser.showDialog(this, "Choose Background Color", newColor);
        if (newColor != null) {
            eBookText.setForeground(newColor);
        }
    }//GEN-LAST:event_fontColorButtonActionPerformed
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(EBookReader.findNodeByName(eBook.getContent(), "guide", true) == null){
            AddGuide addGuide = new AddGuide(eBookWriter, eBook);
            addGuide.setVisible(true);
            addGuide.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent we) {
                    load();
                }
            });
        }else{
            JOptionPane.showMessageDialog(this, "Ksiązka ma już sekcję guide");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AddToSpine addToSpine = new AddToSpine(eBookWriter, eBook);
        addToSpine.setVisible(true);
        addToSpine.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                load();
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void filesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_filesListValueChanged
        try {
            String text = eBookReader.readTextFromFile(filesList.getSelectedValue());
            eBookText.setText(text);
        } catch (IOException ex) {
            Logger.getLogger(EpubReader_Marceli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filesListValueChanged
    public void load(){
        filesListModel.removeAllElements();
        for(int i=0;i<eBook.getFileList().size();i++){
            String fileName = eBook.getFileList().get(i).substring(eBook.getFileList().lastIndexOf("/")+1, eBook.getFileList().get(i).length());
            filesListModel.addElement(fileName);
        }
        spineListModel.removeAllElements();
        eBook.getSpineMap().keySet().forEach((_item) -> {spineListModel.addElement(_item);
        });
        guideListModel.removeAllElements();
        eBook.getGuideMap().keySet().forEach((_item) -> {guideListModel.addElement(_item);
        });
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EpubReader_Marceli().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea eBookText;
    private javax.swing.JList<String> filesList;
    private javax.swing.JComboBox<String> fontChoose;
    private javax.swing.JButton fontColorButton;
    private javax.swing.JSpinner fontSizeSpinner;
    private javax.swing.JToolBar fontToolBar;
    private javax.swing.JList<String> guideList;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenu menuNawigacja;
    private javax.swing.JMenu menuPlik;
    private javax.swing.JMenu menuPublikacja;
    private javax.swing.JMenuItem plikZamknij;
    private javax.swing.JMenuItem plikZamknijPublikacje;
    private javax.swing.JMenuItem plikZnajdzPublikacje;
    private javax.swing.JMenuItem publikacjaDodajOkladke;
    private javax.swing.JMenuItem publikacjaDodajRozdzial;
    private javax.swing.JMenuItem publikacjaEdytujMetadane;
    private javax.swing.JMenuItem showMetadane;
    private javax.swing.JList<String> spineList;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFileChooser jfc;
    private DefaultListModel filesListModel;
    private DefaultListModel spineListModel;
    private DefaultListModel guideListModel;
    private DefaultComboBoxModel model;
}