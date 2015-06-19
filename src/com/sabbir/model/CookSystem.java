package com.sabbir.model;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class CookSystem extends JPanel{
	
	private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);
	private static final String ADD_BUTTON_LABEL = ">>";
	private static final String REMOVE_BUTTON_LABEL = "<<";
	
	private JList sourceList;
	private SortedListModel sourceListModel;
	private JList destList;
	private SortedListModel destListModel;
	
	private JButton addButton;
	private JButton removeButton;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openMi, saveMi, exitMi;
	private ImageIcon exitIcon, openIcon, saveIcon;
	
	public CookSystem(JFrame f){
		createMenuBar(f);
		createLayout();
	}

	private void createMenuBar(JFrame f) {
		menuBar = new JMenuBar();
		
		exitIcon = new ImageIcon("resource/exit.png");
		openIcon = new ImageIcon("resource/Open_file.png");
		saveIcon = new ImageIcon("resource/stock_data_save.png");
		
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
        openMi = new JMenuItem("Load", openIcon);
        openMi.setMnemonic(KeyEvent.VK_O);
        saveMi = new JMenuItem("Save", saveIcon);
		saveMi.setMnemonic(KeyEvent.VK_S);
        exitMi = new JMenuItem("Exit", exitIcon);
        exitMi.setToolTipText("Exit application");
        exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, 
        		ActionEvent.CTRL_MASK));
        exitMi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
		fileMenu.add(openMi);
		fileMenu.add(saveMi);
		fileMenu.add(exitMi);
		
		menuBar.add(fileMenu);
		f.setJMenuBar(menuBar);
	}
	
	private void createLayout() {
		setBorder(BorderFactory.createEtchedBorder());
	    setLayout(new GridBagLayout());
	    
	    sourceListModel = new SortedListModel();
	    sourceList = new JList(sourceListModel);
        add(new JScrollPane(sourceList), new GridBagConstraints(0, 1, 1, 5, .5,
            1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            EMPTY_INSETS, 0, 0));

        addButton = new JButton(ADD_BUTTON_LABEL);
        add(addButton, new GridBagConstraints(1, 0, 1, 2, 0, .25,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            EMPTY_INSETS, 0, 0));
        addButton.addActionListener(new AddListener());
        removeButton = new JButton(REMOVE_BUTTON_LABEL);
        add(removeButton, new GridBagConstraints(1, 1, 1, 2, 0, .25,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                70, 5, 0, 5), 0, 0));
        removeButton.addActionListener(new RemoveListener());

        destListModel = new SortedListModel();
        destList = new JList(destListModel);
        add(new JScrollPane(destList), new GridBagConstraints(2, 1, 1, 5, .5,
            1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            EMPTY_INSETS, 0, 0));
	}
	
	private class AddListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	Object selected[] = sourceList.getSelectedValues();
	    	addDestinationElements(selected);
	    	clearSourceSelected();
	    }
	}

	private class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selected[] = destList.getSelectedValues();
			addSourceElements(selected);
			clearDestinationSelected();
		}
	}

	public void addSourceElements(Object[] selected) {
		sourceListModel.addAll(selected);
	}

	public void clearSourceSelected() {
		Object selected[] = sourceList.getSelectedValues();
	    for (int i = selected.length - 1; i >= 0; --i) {
	    	sourceListModel.removeElement(selected[i]);
	    }
	    sourceList.getSelectionModel().clearSelection();
	}
	
	public void addDestinationElements(Object[] selected) {
		destListModel.addAll(selected);
	}
	
	public void clearDestinationSelected() {
		Object selected[] = destList.getSelectedValues();
	    for (int i = selected.length - 1; i >= 0; --i) {
	    	destListModel.removeElement(selected[i]);
	    }
	    destList.getSelectionModel().clearSelection();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("PC Part Builder");
		f.setSize(400, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CookSystem cs = new CookSystem(f);		
		
		cs.addSourceElements(new String[] {"Case", "Motherboard", "CPU"});
		cs.addSourceElements(new String[] {"GPU", "PSU", "RAM", "HDD"});
		
		f.getContentPane().add(cs, BorderLayout.CENTER);
		f.setVisible(true);
	}
}
