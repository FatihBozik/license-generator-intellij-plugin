package io.github.fatihbozik.licencegenerator.util;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * {@link Utils} class that contains various methods.
 *
 * @author Fatih Bozik
 */
public final class Utils {
    /** Private constructor to prevent creating {@link Utils} instance. */
    private Utils() {
    }

    /**
     * Opens given file in editor.
     *
     * @param project current project
     * @param file    file to open
     */
    public static void openFile(@NotNull Project project, @NotNull PsiFile file) {
        FileEditorManager.getInstance(project).openFile(file.getVirtualFile(), true);
    }
}
