package io.github.fatihbozik.licencegenerator.command;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Fatih Bozik
 */
public abstract class CommandAction<T> {
    /** Current project. */
    @NotNull
    private final Project project;

    /**
     * Constructor.
     *
     * @param project current project
     */
    public CommandAction(@NotNull Project project) {
        this.project = project;
    }

    protected abstract T compute() throws Throwable;

    public final T execute() throws Throwable {
        return WriteCommandAction.writeCommandAction(project).compute(CommandAction.this::compute);
    }
}
