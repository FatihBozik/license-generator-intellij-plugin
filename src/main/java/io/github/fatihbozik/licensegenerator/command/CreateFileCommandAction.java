package io.github.fatihbozik.licensegenerator.command;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import io.github.fatihbozik.licensegenerator.license.LicenseFactory;
import io.github.fatihbozik.licensegenerator.license.LicenseType;
import org.jetbrains.annotations.NotNull;

/**
 * Command action that creates new file in given directory.
 *
 * @author Fatih Bozik
 */
public class CreateFileCommandAction extends AbstractCommandAction<PsiFile> {
    /** Working directory. */
    private final PsiDirectory directory;

    /** Working license type. */
    private final LicenseType licenseType;

    /**
     * Builds a new instance of {@link CreateFileCommandAction}.
     *
     * @param project     current project
     * @param directory   working directory
     * @param licenseType working license type
     */
    public CreateFileCommandAction(@NotNull Project project,
                                   @NotNull PsiDirectory directory,
                                   @NotNull LicenseType licenseType) {
        super(project);
        this.directory = directory;
        this.licenseType = licenseType;
    }

    /**
     * Creates a new file using
     * {@link LicenseFactory#createFromTemplate(PsiDirectory)}
     * to fill it with content.
     *
     * @return created file
     */
    @Override
    protected PsiFile compute() {
        final LicenseFactory factory = new LicenseFactory(licenseType);
        return factory.createFromTemplate(directory);
    }
}
