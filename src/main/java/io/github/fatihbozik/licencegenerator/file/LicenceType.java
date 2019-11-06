package io.github.fatihbozik.licencegenerator.file;

import org.jetbrains.annotations.NotNull;

/**
 * Describes Licence type.
 *
 * @author Fatih Bozik
 * @since 0.0.1
 */
public enum LicenceType {
    APACHE("Apache Licence 2.0"),
    GNU("GNU General Public License v3.0"),
    MIT("MIT Licence");

    /** Licence type name **/
    @NotNull
    private final String name;

    /**
     * Private constructor
     *
     * @param name Licence type name
     */
    LicenceType(@NotNull String name) {
        this.name = name;
    }

    /**
     * Returns the name of the licence type.
     *
     * @return The licence type name.
     */
    @NotNull
    public String getName() {
        return name;
    }
}
