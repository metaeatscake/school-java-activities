/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ItemController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Item;

/**
 *
 * @author bigjo
 */
public class TableDataLoader {
    
    protected static void fillItemTable(JTable target, ItemController src ){
        
        DefaultTableModel dtm = (DefaultTableModel) target.getModel();
        dtm.setRowCount(0);
        
        ArrayList<Item> data = src.viewAllItems();
        
        data.forEach((Item n) -> dtm.addRow(new Object[]{
            n.getId(),
            n.getName(),
            n.getQty(),
            n.getPrice()
        }));
    }
    
    protected static Map<String, Integer> getMapOfColAndRowID(JTable target, int colID){
        Map<String, Integer> result = null;
        
        DefaultTableModel dtm = (DefaultTableModel) target.getModel();
        int rowCount = dtm.getRowCount();
        if(rowCount > 0){
            result = new HashMap<String,Integer>();
            
            for (int i = 0; i < rowCount; i++) {
                result.put(dtm.getValueAt(i, colID).toString(), i);
            }
        }
        
        return result;
    }
    
    protected static String[] getSelectedRow(JTable source){
        int INVALIDROWID = -1;
        String[] arr = null;
        int selected = source.getSelectedRow();
        
        if (selected != INVALIDROWID) {
            
            DefaultTableModel dtm = (DefaultTableModel) source.getModel();
            arr = new String[dtm.getColumnCount()];
            
            for (int i = 0; i < arr.length; i++) {
                arr[i] = dtm.getValueAt(selected, i).toString();
            }
        }
        
        return arr;
    }
    
    protected static Map<String, Integer> getTableColumnMap(JTable source){
        Map<String, Integer> m = null;
        
        int colnum = source.getColumnCount();
        
        if(colnum != 0){
            m = new HashMap<String, Integer>();
            for (int i = 0; i < colnum; i++) {
                m.put(source.getColumnName(i), i);
            }
        }
        
        return m;
    } 
}
