package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle;
import io.github.fatihbozik.licencegenerator.command.CreateFileCommandAction;
import io.github.fatihbozik.licencegenerator.licence.LicenceType;
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
        try {
            final CreateFileCommandAction createFileCommandAction = new CreateFileCommandAction(project, directory, licenceType);
            final PsiFile file = createFileCommandAction.execute();
            Utils.openFile(project, file);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void createPresentation(@NotNull LicenceType licenceType) {
        final Presentation templatePresentation = getTemplatePresentation();
        templatePresentation.setText(licenceType.getName());
        templatePresentation.setDescription(getLicenceTypeDescription(licenceType));
    }

    private String getLicenceTypeDescription(@NotNull LicenceType licenceType) {
        return LicenceGeneratorBundle.message("action.newFile.description", licenceType.getName());
    }
}
