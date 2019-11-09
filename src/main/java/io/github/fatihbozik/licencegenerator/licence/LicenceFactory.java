package io.github.fatihbozik.licencegenerator.licence;

import com.github.hypfvieh.util.StringUtil;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.intellij.openapi.fileTypes.UnknownFileType;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.IncorrectOperationException;
import io.github.fatihbozik.licencegenerator.util.Constants;
import io.github.fatihbozik.licencegenerator.util.Resources;
import org.jetbrains.annotations.Nullable;

import java.time.Year;

/**
 * Licences factory that generates licence file and its content.
 *
 * @author Fatih Bozik
 */
public class LicenceFactory implements FileTemplateGroupDescriptorFactory {

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
        String content = StringUtil.defaultIfBlank(licence.getContent(), "");

        if (licence.getType() == LicenceType.MIT) {
            content = replaceParametricValues(content);
        }

        final PsiFile file = factory.createFileFromText(Constants.LICENCE, UnknownFileType.INSTANCE, content);
        return (PsiFile) directory.add(file);
    }

    private String replaceParametricValues(String content) {
        final int year = Year.now().getValue();
        content = content.replace("[year]", String.valueOf(year));
        final String userName = System.getProperty("user.name");
        content = content.replace("[fullname]", userName);
        return content;
    }
}
