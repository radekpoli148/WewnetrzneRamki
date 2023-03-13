package wewnetrzneramki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class WewnetrzneRamki extends JFrame{

    public WewnetrzneRamki()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Zakladki");
        this.setBounds(300, 320, 400, 200);
        
        JInternalFrame wewnRamka = new JInternalFrame("tytuł ramki", true, true, true, true);
        wewnRamka.add(new JButton("test"), BorderLayout.NORTH);
        wewnRamka.setVisible(true);
        wewnRamka.pack();
        //wewnRamka.setFrameIcon(icon);
        wewnRamka.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        JInternalFrame wewnRamka2 = new JInternalFrame("tytuł ramki", true, true, true, true);
        wewnRamka2.add(new JLabel("test"), BorderLayout.NORTH);
        wewnRamka2.setVisible(true);
        wewnRamka2.pack();
        
        wewnRamka.addInternalFrameListener(new InternalFrameListener(){
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                System.out.println("Otwarte");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                String odp = JOptionPane.showInternalInputDialog(e.getInternalFrame(), "wpisz 'wyjscie' by wyjść z prozramu, lub 'zamknij' by zamknąć ramkę");
                
                if(odp != null)
                    if(odp.equalsIgnoreCase("wyjscie"))
                        System.exit(0);
                    else if(odp.equals("zamknij"))
                        e.getInternalFrame().dispose();
                
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                System.out.println("Zamknięcie");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
                System.out.println("Zminimalizowano");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
                System.out.println("Zmaksymalizowano");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                System.out.println("Aktywowano");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
                System.out.println("Dezaktywowano");
            }
        });
        
        desktopPane.add(wewnRamka);
        desktopPane.add(wewnRamka2);
        
        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(3);
    }
    
    private JDesktopPane desktopPane = new JDesktopPane();
    
    public static void main(String[] args) {
        new WewnetrzneRamki().setVisible(true);
    }
    
}
