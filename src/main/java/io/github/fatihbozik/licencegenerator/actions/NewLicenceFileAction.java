package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;
import io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle;
import io.github.fatihbozik.licencegenerator.file.LicenceType;
import org.jetbrains.annotations.NotNull;

/**
 * Creates new licence file or returns existing one.
 *
 * @author Fatih Bozik <bozikfatih@gmail.com>
 * @since 0.0.1
 */
public class NewLicenceFileAction extends AnAction implements DumbAware {
    private final LicenceType licenceType;

    NewLicenceFileAction(@NotNull LicenceType licenceType) {
        this.licenceType = licenceType;
        createPresentation(licenceType);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {


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
