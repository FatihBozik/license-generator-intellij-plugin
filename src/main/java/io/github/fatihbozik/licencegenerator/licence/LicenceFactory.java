package io.github.fatihbozik.licencegenerator.licence;

import com.github.hypfvieh.util.StringUtil;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.intellij.openapi.fileTypes.UnknownFileType;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.IncorrectOperationException;
import io.github.fatihbozik.licencegenerator.util.Resources;
import org.jetbrains.annotations.Nullable;

/**
 * Licences factory that generates licence file and its content.
 *
 * @author Fatih Bozik
 */
public class LicenceFactory implements FileTemplateGroupDescriptorFactory {
    /** Licence file name **/
    private static final String LICENCE_FILE_NAME = "LICENCE";

    /** Current licence type. */
    private final LicenceType licenceType;

    /** Builds a new instance of {@link LicenceFactory}. */
    public LicenceFactory(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    @Override
    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        throw new UnsupportedOperationException("#getFileTemplatesDescriptor()");
    }

    /**
     * Creates new licence file
     *
     * @param directory working directory
     * @return file
     */
    @Nullable
    public PsiFile createFromTemplate(final PsiDirectory directory) throws IncorrectOperationException {
        final String filename = licenceType.getKey();
        final PsiFile currentFile = directory.findFile(filename);
        if (currentFile != null) {
            return currentFile;
        }
        final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());

        final Licence licence = Resources.getLicence(licenceType);
        final String content = StringUtil.defaultIfBlank(licence.getContent(), "");
        final PsiFile file = factory.createFileFromText(LICENCE_FILE_NAME, UnknownFileType.INSTANCE, content);
        return (PsiFile) directory.add(file);
    }
}
