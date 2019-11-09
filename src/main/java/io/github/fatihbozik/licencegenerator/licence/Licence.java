package io.github.fatihbozik.licencegenerator.licence;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * {@link Licence} entity that defines licence fetched from resources
 *
 * @author Fatih Bozik
 */
public class Licence {
    /** Licence type. */
    @NotNull
    private final LicenceType type;

    /** Licence content. */
    @Nullable
    private final String content;

    /**
     * Builds a new instance of {@link Licence}.
     *
     * @param type    licence's type
     * @param content licence's content
     */
    public Licence(@NotNull LicenceType type, @Nullable String content) {
        this.type = type;
        this.content = content;
    }

    @Nullable
    String getContent() {
        return content;
    }

    @NotNull
    LicenceType getType() {
        return type;
    }
}
