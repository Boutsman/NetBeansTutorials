/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.copyfqn;

import com.sun.source.tree.ClassTree;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.api.java.source.CompilationController;
import org.netbeans.api.java.source.CompilationInfo;
import org.netbeans.api.java.source.JavaSource;
import org.netbeans.api.java.source.JavaSource.Phase;
import org.netbeans.api.java.source.Task;
import org.openide.awt.*;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.datatransfer.ExClipboard;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

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
    private Clipboard clipboard;

    public CopyFQNAction(DataObject context) {
        this.context = context;
        clipboard = Lookup.getDefault().lookup(ExClipboard.class);
        if (clipboard == null) {
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        }
    }

    private class MemberVisitor extends TreePathScanner<Void, Void> {

        private CompilationInfo info;

        public MemberVisitor(CompilationInfo info) {
            this.info = info;
        }

        @Override
        public Void visitClass(ClassTree t, Void v) {
            try {
                JTextComponent editor = EditorRegistry.lastFocusedComponent();
                if (editor.getDocument() == info.getDocument()) {
                    int dot = editor.getCaret().getDot();
                    TreePath tp = info.getTreeUtilities().pathFor(dot);
                    Element el = info.getTrees().getElement(tp);
                    if (el == null) {
                        StatusDisplayer.getDefault().setStatusText("Cannot resolve class!");
                    } else {
                        InputOutput io = IOProvider.getDefault().getIO("Analysis of " + info.getFileObject().getName(), true);
                        String te = null;
                        if (el.getKind() == ElementKind.CONSTRUCTOR) {
                            te = ((TypeElement) ((ExecutableElement) el).getEnclosingElement()).getQualifiedName().toString();
                            io.getOut().println("Hurray, this is a constructor's qualified name: " + te);
                        } else if (el.getKind() == ElementKind.METHOD) {
                            te = ((ExecutableElement) el).getReturnType().toString();
                            io.getOut().println("Hurray, this is a method's return type: " + te);
                        } else if (el.getKind() == ElementKind.FIELD) {
                            te = ((VariableElement) el).asType().toString();
                            io.getOut().println("Hurray, this is a field's type: " + te);
                        } else {
                            io.getOut().println("Hurray, this is something else: " + el.getSimpleName());
                        }
                        io.getOut().close();
                        setClipboardContents(te);
                    }
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }

            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        FileObject fileObject = context.getPrimaryFile();
        JavaSource javaSource = JavaSource.forFileObject(fileObject);
        if (javaSource == null) {
            StatusDisplayer.getDefault().setStatusText("Not a Java file: " + fileObject.getPath());
        } else {
            //StatusDisplayer.getDefault().setStatusText("Hurray! A Java file: " + fileObject.getPath());
            try {
                javaSource.runUserActionTask(new Task<CompilationController>() {
                    @Override
                    public void run(CompilationController compilationController) throws Exception {
                        //throw new UnsupportedOperationException("Not supported yet.");
                        compilationController.toPhase(Phase.ELEMENTS_RESOLVED);
                        Document document = compilationController.getDocument();
                        if (document != null) {
                            new MemberVisitor(compilationController).scan(compilationController.getCompilationUnit(), null);
                        } else {
                            StatusDisplayer.getDefault().setStatusText("The Java file is closed!");
                        }
                    }
                }, true);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private void setClipboardContents(String content) {
        if (clipboard != null) {
            if (content == null) {
                StatusDisplayer.getDefault().setStatusText("");
                clipboard.setContents(null, null);
            } else {
                StatusDisplayer.getDefault().setStatusText("Clipboard: " + content);
                clipboard.setContents(new StringSelection(content), null);
            }
        }
    }    
}
