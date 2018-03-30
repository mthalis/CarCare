/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.helper;

import java.awt.Dimension;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.log4j.Logger;

/**
 *
 * @author Dinesh
 */
public class PrintHelper {
    
    private static final Logger logger = Logger.getLogger(PrintHelper.class);
    boolean withoutPreview = true;
    
    public void printReport(JasperPrint jasperPrint, String title){
        
        if(withoutPreview){
            try {
                JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException ex) {
                logger.fatal("Error Occured while generating " + title + "-->" + ex);
            }
        }else{
            JRViewer jv = new JRViewer(jasperPrint);
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.setTitle(title);

            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(900,700));
            jf.setLocation(300,0);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
