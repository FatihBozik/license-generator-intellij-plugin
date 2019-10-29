package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;
import io.github.fatihbozik.licencegenerator.file.Licence;
import io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle;
import io.github.fatihbozik.licencegenerator.util.Icons;

import java.util.Arrays;

/**
 * Creates a group of {@link NewFileAction} instances.
 *
 * @author Fatih Bozik <bozikfatih@gmail.com>
 * @since 0.0.1
 */
public class NewFileGroupAction extends DefaultActionGroup implements DumbAware {

    public NewFileGroupAction() {
        setPopup(true);
        createPresentation();
        Arrays.stream(Licence.values()).map(NewFileAction::new).forEach(this::add);
    }

    private void createPresentation() {
        Presentation presentation = getTemplatePresentation();
        presentation.setText(LicenceGeneratorBundle.message("action.newFile.group"));
        presentation.setIcon(Icons.LICENCE);
    }
}
