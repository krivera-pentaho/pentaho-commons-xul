/**
 * 
 */
package org.pentaho.ui.xul.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ResourceBundle;
import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.XulException;
import org.pentaho.ui.xul.XulLoader;
import org.pentaho.ui.xul.components.XulMessageBox;
import org.pentaho.ui.xul.dom.Document;

/**
 * @author OEM
 *
 */
public class XulFragmentContainer extends AbstractXulDomContainer {
  private static final Log logger = LogFactory.getLog(XulFragmentContainer.class);
  private Document fragment;
  
  public XulFragmentContainer(XulLoader xulLoader){
    super();
    this.xulLoader = xulLoader;
  }

  public Document getDocumentRoot(){
    return fragment;
  }

  public void addDocument(Document document){
    this.fragment = document;
  }

  @Override
  public XulMessageBox createMessageBox(String message) {
  	return null;
  }

  @Override
  public void close() {
  }

  public boolean isClosed(){
    return false;
  }

  @Override
  public XulFragmentContainer loadFragment(String xulLocation) throws XulException{
    logger.error("loadFragment not implemented in XulFragmentContainer");
    throw new XulException("loadFragment not implemented in XulFragmentContainer");
  }

  public XulMessageBox createErrorMessageBox(String title, String message, Throwable throwable) {
    return null;
  }

  public XulDomContainer loadFragment(String xulLocation, ResourceBundle res) throws XulException {
    System.out.println("loadFragment not implemented in XulFragmentContainer");
    return null;
  }
    
}
