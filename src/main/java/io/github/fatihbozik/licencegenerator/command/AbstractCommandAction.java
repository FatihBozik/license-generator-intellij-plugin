package io.github.fatihbozik.licencegenerator.command;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Fatih Bozik
 */
public abstract class AbstractCommandAction<T> {
    /** Current project. */
    @NotNull
    private final Project project;

    /**
     * Constructor.
     *
     * @param project current project
     */
    AbstractCommandAction(@NotNull Project project) {
        this.project = project;
    }

    protected abstract T compute();

    public final T execute() {
        return WriteCommandAction.writeCommandAction(project).compute(AbstractCommandAction.this::compute);
    }
}
