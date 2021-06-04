package io.github.fatihbozik.licensegenerator.license;

import org.jetbrains.annotations.NotNull;

/**
 * Describes License type.
 *
 * @author Fatih Bozik
 */
public enum LicenseType {
    AFL_30("afl-3.0", "Academic Free License v3.0"),
    APGL_30("apgl-3.0", "GNU Affero General Public License v3.0"),
    APACHE_20("apache-2.0", "Apache License 2.0"),
    BSD_2_CLAUSE("bsd-2-clause", "BSD 2-Clause \"Simplified\" License"),
    BSD_3_CLAUSE("bsd-3-clause", "BSD 3-Clause \"New\" or \"Revised\" License"),
    CDDL_10("cddl-1.0", "Common Development and Distribution License v1.0"),
    EPL_20("epl-2.0", "Eclipse Public License 2.0"),
    GPL_20("gpl-2.0", "GNU General Public License v2.0"),
    GPL_30("gpl-3.0", "GNU General Public License v3.0"),
    LGPL_21("lgpl-2.1", "GNU Lesser General Public License v2.1"),
    LGPL_30("lgpl-3.0", "GNU Lesser General Public License v3.0"),
    MIT("mit", "MIT License"),
    MPL_20("mpl-2.0", "Mozilla Public License 2.0"),
    THE_UNLICENSE("unlicense", "The Unlicense");

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
