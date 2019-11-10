package io.github.fatihbozik.licensegenerator.license;

import com.github.hypfvieh.util.StringUtil;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.intellij.openapi.fileTypes.UnknownFileType;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.IncorrectOperationException;
import io.github.fatihbozik.licensegenerator.util.Constants;
import io.github.fatihbozik.licensegenerator.util.Resources;
import org.jetbrains.annotations.Nullable;

import java.time.Year;

/**
 * Licenses factory that generates license file and its content.
 *
 * @author Fatih Bozik
 */
public class LicenseFactory implements FileTemplateGroupDescriptorFactory {

    /** Current license type. */
    private final LicenseType licenseType;

    /** Builds a new instance of {@link LicenseFactory}. */
    public LicenseFactory(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    @Override
    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        throw new UnsupportedOperationException("#getFileTemplatesDescriptor()");
    }

    /**
     * Creates new license file
     *
     * @param directory working directory
     * @return file
     */
    @Nullable
    public PsiFile createFromTemplate(final PsiDirectory directory) throws IncorrectOperationException {
        final String filename = licenseType.getKey();
        final PsiFile currentFile = directory.findFile(filename);
        if (currentFile != null) {
            return currentFile;
        }
        final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());

        final License license = Resources.getLicense(licenseType);
        String content = StringUtil.defaultIfBlank(license.getContent(), "");

        if (license.getType() == LicenseType.MIT) {
            content = replaceParametricValues(content);
        }

        final PsiFile file = factory.createFileFromText(Constants.LICENSE, UnknownFileType.INSTANCE, content);
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
