package org.pentaho.ui.xul.html.tags.transmenu;

import org.pentaho.ui.xul.XulComponent;
import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.containers.XulMenubar;
import org.pentaho.ui.xul.dom.Element;
import org.pentaho.ui.xul.html.IHtmlElement;

public class HtmlMenubar extends HtmlElement implements XulMenubar {

	public HtmlMenubar(Element self, XulComponent parent, XulDomContainer domContainer, String tagName) {
	    super( tagName );

	  }
	
	  public void getHtml( StringBuilder sb ) {
		  
		  // first add the div
		  sb.append( "<div id=\"" ) //$NON-NLS-1$
		  .append( getId() )
		  .append("\">\n"); //$NON-NLS-1$
		  
		  for( XulComponent component : children ) {
			  if( component instanceof HtmlMenu ) {
				  ((IHtmlElement)component).getHtml(sb);
			  }
		  }

		  sb.append( "</div>\n" ); //$NON-NLS-1$
		  
		  // now add the script
		  getScript( sb );
		  
	  }

	  public void getScript( StringBuilder sb ) {
		  sb.append( "<script language=\"javascript\">\n" ) //$NON-NLS-1$
		  .append( 	"if (TransMenu.isSupported()) {\n" ) //$NON-NLS-1$
		  .append( 		"var topLevelMenuItems = new Array();\n" ) //$NON-NLS-1$
		  .append( 		"var ms = new TransMenuSet(TransMenu.direction.down, 1, 0, TransMenu.reference.bottomLeft);\n" ); //$NON-NLS-1$

		  for( XulComponent component : children ) {
			  if( component instanceof HtmlMenu ) {
				  ((HtmlMenu)component).getScript(sb);
			  }
		  }

		  sb.append( 		"TransMenu.renderAll();\n" ); //$NON-NLS-1$
		  sb.append( 	"}\n" ); //$NON-NLS-1$
		  sb.append( "</script>\n" ); //$NON-NLS-1$

	  }
	  
	public void addComponent(XulComponent c) {
		    super.addComponent(c);
	}

	public void addComponentAt(XulComponent c, int idx) {
		super.addComponentAt(c, idx);
	}

}
