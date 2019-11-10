package io.github.fatihbozik.licensegenerator.actions;

import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;
import io.github.fatihbozik.licensegenerator.LicenseGeneratorBundle;
import io.github.fatihbozik.licensegenerator.license.LicenseType;
import io.github.fatihbozik.licensegenerator.util.Icons;

import java.util.Arrays;

/**
 * Creates a group of {@link NewLicenseFileAction} instances.
 *
 * @author Fatih Bozik
 */
public class NewLicenseFileGroupAction extends DefaultActionGroup implements DumbAware {

    public NewLicenseFileGroupAction() {
        setPopup(true);
        createPresentation();
        Arrays.stream(LicenseType.values()).map(NewLicenseFileAction::new).forEach(this::add);
    }

    private void createPresentation() {
        Presentation presentation = getTemplatePresentation();
        presentation.setText(LicenseGeneratorBundle.message("action.licenseFile.group"));
        presentation.setIcon(Icons.LICENSE);
    }
}
