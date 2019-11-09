package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.ide.IdeView;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle;
import io.github.fatihbozik.licencegenerator.command.CreateFileCommandAction;
import io.github.fatihbozik.licencegenerator.licence.LicenceType;
import io.github.fatihbozik.licencegenerator.util.Constants;
import io.github.fatihbozik.licencegenerator.util.Utils;
import org.jetbrains.annotations.NotNull;

/**
 * Creates new licence file or returns existing one.
 *
 * @author Fatih Bozik
 */
public class NewLicenceFileAction extends AnAction implements DumbAware {
    private final LicenceType licenceType;

    NewLicenceFileAction(@NotNull LicenceType licenceType) {
        this.licenceType = licenceType;
        createPresentation(licenceType);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Project project = e.getRequiredData(CommonDataKeys.PROJECT);
        final IdeView view = e.getRequiredData(LangDataKeys.IDE_VIEW);
        final PsiDirectory directory = view.getOrChooseDirectory();
        if (directory == null) {
            return;
        }

        final PsiFile file = directory.findFile(Constants.LICENCE);
        final VirtualFile virtualFile = getVirtualFile(directory, file);

        if (file == null && virtualFile == null) {
            final PsiFile createdFile = createFile(project, directory);
            if (createdFile != null) {
                Utils.openFile(project, createdFile);
            }
        } else {
            Notifications.Bus.notify(new Notification(
                "Licence File Detector",
                LicenceGeneratorBundle.message("action.licenceFile.exists"),
                LicenceGeneratorBundle.message("action.licenceFile.exists.in", virtualFile.getPath()),
                NotificationType.INFORMATION
            ), project);
        }
    }

    private PsiFile createFile(Project project, PsiDirectory directory) {
        final CreateFileCommandAction createFileCommandAction = new CreateFileCommandAction(project, directory, licenceType);
        return createFileCommandAction.execute();
    }

    private VirtualFile getVirtualFile(PsiDirectory directory, PsiFile file) {
        if (file == null) {
            return directory.getVirtualFile().findChild(Constants.LICENCE);
        }
        return file.getVirtualFile();
    }

    private void createPresentation(@NotNull LicenceType licenceType) {
        final Presentation templatePresentation = getTemplatePresentation();
        templatePresentation.setText(licenceType.getName());
        templatePresentation.setDescription(getLicenceTypeDescription(licenceType));
    }

    private String getLicenceTypeDescription(@NotNull LicenceType licenceType) {
        return LicenceGeneratorBundle.message("action.licenceFile.description", licenceType.getName());
    }
}
