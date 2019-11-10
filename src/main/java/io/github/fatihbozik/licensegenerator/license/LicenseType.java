package io.github.fatihbozik.licensegenerator.license;

import org.jetbrains.annotations.NotNull;

/**
 * Describes License type.
 *
 * @author Fatih Bozik
 */
public enum LicenseType {
    APACHE("apache-2.0", "Apache License 2.0"),
    GNU("gpl-2.0", "GNU General Public License v3.0"),
    MIT("mit", "MIT License");

    /** License type key **/
    @NotNull
    private final String key;

    /** License type name **/
    @NotNull
    private final String name;

    /**
     * Private constructor
     *
     * @param name License type name
     * @param key  License type key
     */
    LicenseType(@NotNull String key, @NotNull String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Returns the name of the license type.
     *
     * @return The license type name.
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Returns the key of the license type.
     *
     * @return The license type key.
     */
    @NotNull
    public String getKey() {
        return key;
    }
}
