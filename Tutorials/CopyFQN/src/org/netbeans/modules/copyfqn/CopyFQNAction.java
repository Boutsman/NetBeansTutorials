/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.copyfqn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.java.source.JavaSource;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.netbeans.modules.copyfqn.CopyFQNAction"
)
@ActionRegistration(
        iconBase = "org/netbeans/modules/copyfqn/icon.png",
        displayName = "#CTL_CopyFQNAction"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_CopyFQNAction=CopyFQN")
public final class CopyFQNAction implements ActionListener {

    private final DataObject context;

    public CopyFQNAction(DataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        FileObject fileObject = context.getPrimaryFile();
        JavaSource javaSource = JavaSource.forFileObject(fileObject);
        if (javaSource == null) {
            StatusDisplayer.getDefault().setStatusText("Not a Java file: " + fileObject.getPath());
        } else {
            StatusDisplayer.getDefault().setStatusText("Hurray! A Java file: " + fileObject.getPath());
        }
    }
    }
