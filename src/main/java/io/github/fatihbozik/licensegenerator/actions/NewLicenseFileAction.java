package io.github.fatihbozik.licensegenerator.actions;

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
import io.github.fatihbozik.licensegenerator.LicenseGeneratorBundle;
import io.github.fatihbozik.licensegenerator.command.CreateFileCommandAction;
import io.github.fatihbozik.licensegenerator.license.LicenseType;
import io.github.fatihbozik.licensegenerator.util.Constants;
import io.github.fatihbozik.licensegenerator.util.Utils;
import org.jetbrains.annotations.NotNull;

/**
 * Creates new license file or returns existing one.
 *
 * @author Fatih Bozik
 */
public class NewLicenseFileAction extends AnAction implements DumbAware {
    private final LicenseType licenseType;

    NewLicenseFileAction(@NotNull LicenseType licenseType) {
        this.licenseType = licenseType;
        createPresentation(licenseType);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Project project = e.getRequiredData(CommonDataKeys.PROJECT);
        final IdeView view = e.getRequiredData(LangDataKeys.IDE_VIEW);
        final PsiDirectory directory = view.getOrChooseDirectory();
        if (directory == null) {
            return;
        }

        final PsiFile file = directory.findFile(Constants.LICENSE);
        final VirtualFile virtualFile = getVirtualFile(directory, file);

        if (file == null && virtualFile == null) {
            final PsiFile createdFile = createFile(project, directory);
            if (createdFile != null) {
                Utils.openFile(project, createdFile);
            }
        } else {
            Notifications.Bus.notify(new Notification(
                "License File Detector",
                LicenseGeneratorBundle.message("action.licenseFile.exists"),
                LicenseGeneratorBundle.message("action.licenseFile.exists.in", virtualFile.getPath()),
                NotificationType.INFORMATION
            ), project);
        }
    }

    private PsiFile createFile(Project project, PsiDirectory directory) {
        final CreateFileCommandAction createFileCommandAction = new CreateFileCommandAction(project, directory, licenseType);
        return createFileCommandAction.execute();
    }

    private VirtualFile getVirtualFile(PsiDirectory directory, PsiFile file) {
        if (file == null) {
            return directory.getVirtualFile().findChild(Constants.LICENSE);
        }
        return file.getVirtualFile();
    }

    private void createPresentation(@NotNull LicenseType licenseType) {
        final Presentation templatePresentation = getTemplatePresentation();
        templatePresentation.setText(licenseType.getName());
        templatePresentation.setDescription(getLicenseTypeDescription(licenseType));
    }

    private String getLicenseTypeDescription(@NotNull LicenseType licenseType) {
        return LicenseGeneratorBundle.message("action.licenseFile.description", licenseType.getName());
    }
}
