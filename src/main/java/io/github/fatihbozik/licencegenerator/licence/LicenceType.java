package io.github.fatihbozik.licencegenerator.licence;

import org.jetbrains.annotations.NotNull;

/**
 * Describes Licence type.
 *
 * @author Fatih Bozik
 */
public enum LicenceType {
    APACHE("apache-2.0", "Apache Licence 2.0"),
    GNU("gpl-2.0", "GNU General Public License v3.0"),
    MIT("mit", "MIT Licence");

    /** Licence type key **/
    @NotNull
    private final String key;

    /** Licence type name **/
    @NotNull
    private final String name;

    /**
     * Private constructor
     *
     * @param name Licence type name
     * @param key  Licence type key
     */
    LicenceType(@NotNull String key, @NotNull String name) {
        this.key = key;
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

    /**
     * Returns the key of the licence type.
     *
     * @return The licence type key.
     */
    @NotNull
    public String getKey() {
        return key;
    }
}
