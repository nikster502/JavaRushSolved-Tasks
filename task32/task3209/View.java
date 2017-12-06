package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nik on 25.09.2017.
 */
public class View extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;
    public void update(){

htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(),"It hard to be God", "Information",JOptionPane.INFORMATION_MESSAGE);
    }
public void selectHtmlTab(){
tabbedPane.setSelectedIndex(0);
resetUndo();
}
public boolean isHtmlTabSelected(){
return tabbedPane.getSelectedIndex()==0;
}
    public View(){
        try {

            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
           ExceptionHandler.log(e);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }


public void undo(){

    try {
        undoManager.undo();
    } catch (CannotUndoException e) {
        ExceptionHandler.log(e);
    }
}
public  void redo(){
    try {
        undoManager.redo();
    } catch (CannotRedoException e) {
        ExceptionHandler.log(e);
    }
}
    public boolean  canRedo(){

        return undoManager.canRedo();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public boolean canUndo(){
      return undoManager.canUndo();
    }
    public void init(){
        initGui();
       FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public void initMenuBar(){

        //Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
        JMenuBar jMenuBar = new JMenuBar();

 MenuHelper.initFileMenu(this,jMenuBar);
 MenuHelper.initEditMenu(this,jMenuBar);
 MenuHelper.initStyleMenu(this,jMenuBar);
 MenuHelper.initAlignMenu(this,jMenuBar);
 MenuHelper.initColorMenu(this,jMenuBar);
 MenuHelper.initFontMenu(this,jMenuBar);
 MenuHelper.initHelpMenu(this,jMenuBar);

 getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPane1 = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollPane1);
        JScrollPane scrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPane2);
        tabbedPane.setPreferredSize(new Dimension(500,500));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void exit(){
controller.exit();
    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex()==0){
controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex() ==1){
            plainTextPane.setText(controller.getPlainText());
        }
resetUndo();
    }
}
