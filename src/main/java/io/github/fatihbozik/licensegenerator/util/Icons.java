package io.github.fatihbozik.licensegenerator.util;

import com.intellij.openapi.util.IconLoader;

import javax.swing.Icon;

/**
 * {@link Icons} class that holds icon resources.
 *
 * @author Fatih Bozik
 */
public final class Icons {
    /** General ignore icon. */
    public static final Icon LICENSE = IconLoader.getIcon("/icons/license.png");

    /** Private constructor to prevent creating {@link Icons} instance. */
    private Icons() {
    }
}
