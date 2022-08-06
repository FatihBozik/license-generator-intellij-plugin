package io.github.fatihbozik.licensegenerator.util;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * {@link Icons} class that holds icon resources.
 *
 * @author Fatih Bozik
 */
public final class Icons {
    /** General ignore icon. */
    public static final Icon LICENSE = IconLoader.getIcon("/icons/license.png", Icons.class);

    /** Private constructor to prevent creating {@link Icons} instance. */
    private Icons() {
    }
}
