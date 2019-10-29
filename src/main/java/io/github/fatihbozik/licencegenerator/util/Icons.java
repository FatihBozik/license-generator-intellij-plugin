package io.github.fatihbozik.licencegenerator.util;

import com.intellij.openapi.util.IconLoader;

import javax.swing.Icon;

/**
 * {@link Icons} class that holds icon resources.
 *
 * @author Fatih Bozik <bozikfatih@gmail.com>
 * @since 0.0.1
 */
public final class Icons {
    /** Private constructor to prevent creating {@link Icons} instance. */
    private Icons() {
        throw new AssertionError("No io.github.fatihbozik.licencegenerator.util.Icons instances for you");
    }

    /** General ignore icon. */
    public static final Icon LICENCE = IconLoader.getIcon("/icons/licence.png");
}
