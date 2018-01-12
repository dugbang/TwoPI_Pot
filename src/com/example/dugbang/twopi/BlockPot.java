package com.example.dugbang.twopi;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Iterator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import au.com.bytecode.opencsv.CSVReader;


public class BlockPot extends JFrame{
	private SimpleSocketClient client;
//    private static ArrayList<String> smartBlockKey;
    private static HashMap<String, Integer> smartBlockMap;

    BlockPot(String strAddress){
//    	String strAddress = "192.168.0.37";
//    	String strAddress = "localhost";
    	
        this.setTitle("투파이앱 시뮬레이터; " + strAddress);
        //this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(5,5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        Container container = this.getContentPane();
        MyActionListener listener = new MyActionListener();

        smartBlockMap = new HashMap<String, Integer>();
    	client = new SimpleSocketClient(strAddress);

//    	baseBlockIdDesc = contentsFileList.getBlockIdDesc();
//    	Iterator<Integer> keySetIterator = baseBlockIdDesc.keySet().iterator();
        
        JButton [] btn = new JButton [baseBlockIdDesc.size()];
    	Iterator<Integer> keySetIterator = baseBlockIdDesc.keySet().iterator();
    	
		for (int i = 0; keySetIterator.hasNext(); i++) {
			Integer key = keySetIterator.next();
			btn[i] = new JButton(baseBlockIdDesc.get(key));
        	btn[i].addActionListener(listener);
        	container.add(btn[i]);
        	smartBlockMap.put(baseBlockIdDesc.get(key), key);
        	System.out.println("key: " + key + " value: " + baseBlockIdDesc.get(key));
		}
        setSize(600,600);
        setVisible(true);
    }

    
    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            client.send(b.getText() + "," + smartBlockMap.get(b.getText()));
        }
    }
    
//    private static List<HashMap<Integer, String>> list_map;
//    private static List<ArrayList<Integer>> list_key;
    
//	private ContentsPath contentsPath;
//	private static ContentsFileList contentsFileList;
	private static HashMap<Integer, String> baseBlockIdDesc = new HashMap<Integer, String>();
 
	

    private static void readBlockIdCsvFile(String fileName) {
        System.out.println("read csv file; " + fileName);
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String[] s;
            ArrayList<Integer> blockIds = new ArrayList<Integer>();
            while ((s = reader.readNext()) != null) {
                blockIds.add(Integer.parseInt(s[0]));
                baseBlockIdDesc.put(Integer.parseInt(s[0]), s[1]);
            }
//            baseBlockIdMap.put(getContentsCsvFile(fileName), blockIds);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {

//    	contentsPath = new PcContentsPath();
//    	contentsFileList = new ContentsFileList(new PcContentsPath());
    	
    	String fileName = "D:/BlockId_100.csv";
    	readBlockIdCsvFile(fileName);
    	
    	new BlockPot("192.168.0.37");	// "192.168.0.37" / localhost
    }
}
