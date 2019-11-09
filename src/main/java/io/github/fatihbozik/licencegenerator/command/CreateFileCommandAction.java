package io.github.fatihbozik.licencegenerator.command;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import io.github.fatihbozik.licencegenerator.licence.LicenceFactory;
import io.github.fatihbozik.licencegenerator.licence.LicenceType;
import org.jetbrains.annotations.NotNull;

/**
 * Command action that creates new file in given directory.
 *
 * @author Fatih Bozik
 */
public class CreateFileCommandAction extends AbstractCommandAction<PsiFile> {
    /** Working directory. */
    private final PsiDirectory directory;

    /** Working licence type. */
    private final LicenceType licenceType;

    /**
     * Builds a new instance of {@link CreateFileCommandAction}.
     *
     * @param project     current project
     * @param directory   working directory
     * @param licenceType working licence type
     */
    public CreateFileCommandAction(@NotNull Project project,
                                   @NotNull PsiDirectory directory,
                                   @NotNull LicenceType licenceType) {
        super(project);
        this.directory = directory;
        this.licenceType = licenceType;
    }

    /**
     * Creates a new file using
     * {@link LicenceFactory#createFromTemplate(PsiDirectory)}
     * to fill it with content.
     *
     * @return created file
     */
    @Override
    protected PsiFile compute() {
        LicenceFactory factory = new LicenceFactory(licenceType);
        return factory.createFromTemplate(directory);
    }
}
