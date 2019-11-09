package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;
import io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle;
import io.github.fatihbozik.licencegenerator.licence.LicenceType;
import io.github.fatihbozik.licencegenerator.util.Icons;

import java.util.Arrays;

/**
 * Creates a group of {@link NewLicenceFileAction} instances.
 *
 * @author Fatih Bozik
 */
public class NewLicenceFileGroupAction extends DefaultActionGroup implements DumbAware {

    public NewLicenceFileGroupAction() {
        setPopup(true);
        createPresentation();
        Arrays.stream(LicenceType.values()).map(NewLicenceFileAction::new).forEach(this::add);
    }

    private void createPresentation() {
        Presentation presentation = getTemplatePresentation();
        presentation.setText(LicenceGeneratorBundle.message("action.licenceFile.group"));
        presentation.setIcon(Icons.LICENCE);
    }
}
