package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;
import io.github.fatihbozik.licencegenerator.file.Licence;
import org.jetbrains.annotations.NotNull;

import static io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle.message;

/**
 * Creates new file or returns existing one.
 *
 * @author Fatih Bozik <bozikfatih@gmail.com>
 * @since 0.0.1
 */
public class NewFileAction extends AnAction implements DumbAware {
    private final Licence licence;

    NewFileAction(@NotNull Licence licence) {
        this.licence = licence;
        createPresentation(licence);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }

    private void createPresentation(@NotNull Licence aLicence) {
        final Presentation templatePresentation = getTemplatePresentation();
        templatePresentation.setText(aLicence.getName());
        templatePresentation.setDescription(message("action.newFile.description", licence.getName()));
    }
}
