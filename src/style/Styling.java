package style;

//import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Font;
import java.util.Enumeration;
import javax.swing.UIManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dinesh
 */
public class Styling {

    static final Logger logger = Logger.getLogger(Styling.class);
    
    public void styl() {
        try{
            //UIManager.setLookAndFeel(new GTKLookAndFeel());
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            setGlobalFont(new Font("Verdana", Font.PLAIN, 12));
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            //UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel");
            //UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel");
        }catch(Exception e){
            logger.fatal("Erro occured while loading styl-> "+e);
        }

    }

    public int setLocationwith() {
        int a = 160;
        return a;
    }

    public int setLocationhight() {
        int a = 8;
        return a;
    }
    
    public static void setGlobalFont(Font font ) {
        Enumeration enum1 = UIManager.getDefaults().keys();
        while ( enum1.hasMoreElements() ) {
            Object key = enum1.nextElement();
            Object value = UIManager.get( key );
            if ( value instanceof Font ) {
                UIManager.put( key, font );
            }
        }
    }

}

