/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.myeditor;

import java.awt.BorderLayout;
import org.myorg.myapi.Event;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

@TopComponent.Description(preferredID = "MyEditorTopComponent", persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.myorg.myeditor.MyEditorTopComponent")
@ActionReference(path = "Menu/Window")
@TopComponent.OpenActionRegistration(displayName = "#CTL_MyEditorAction")
@NbBundle.Messages({"CTL_MyEditorAction=MyEditor"})

public class MyEditor extends TopComponent implements ExplorerManager.Provider {

    //private final InstanceContent content = new InstanceContent();    

    /**
     * Creates new form MyEditor
     */
    public MyEditor() {
        initComponents();
        //Event obj = new Event();
        //associateLookup(Lookups.singleton(obj));
        //jTextField1.setText("Event #" + obj.getIndex());
        //jTextField2.setText("Created: " + obj.getDate());
        //setDisplayName("MyEditor " + obj.getIndex());

        //associateLookup (new AbstractLookup (content));

        Event obj = new Event();
        //associateLookup(new AbstractLookup(content));
        associateLookup(ExplorerUtils.createLookup(mgr, getActionMap()));
        setLayout(new BorderLayout());
        add(new BeanTreeView(), BorderLayout.CENTER);
        //setDisplayName("MyEditor " + obj.getIndex());
        
        //mgr.setRootContext(new AbstractNode(Children.create(new EventChildFactory(), true)));
        
        mgr.setRootContext(new EventNode());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private final ExplorerManager mgr = new ExplorerManager();
    
    @Override
    public ExplorerManager getExplorerManager() {
        return mgr;
    }
}
