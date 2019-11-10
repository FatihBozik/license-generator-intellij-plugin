package io.github.fatihbozik.licensegenerator.license;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * {@link License} entity that defines license fetched from resources
 *
 * @author Fatih Bozik
 */
public class License {
    /** License type. */
    @NotNull
    private final LicenseType type;

    /** License content. */
    @Nullable
    private final String content;

    /**
     * Builds a new instance of {@link License}.
     *
     * @param type    license's type
     * @param content license's content
     */
    public License(@NotNull LicenseType type, @Nullable String content) {
        this.type = type;
        this.content = content;
    }

    @Nullable
    String getContent() {
        return content;
    }

    @NotNull
    LicenseType getType() {
        return type;
    }
}
