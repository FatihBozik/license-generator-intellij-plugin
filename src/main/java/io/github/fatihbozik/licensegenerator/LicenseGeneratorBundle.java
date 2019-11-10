package io.github.fatihbozik.licensegenerator;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

/**
 * {@link ResourceBundle}/localization utils for the plugin.
 *
 * @author Fatih Bozik
 */
public final class LicenseGeneratorBundle {
    /** The {@link ResourceBundle} path. */
    @NonNls
    private static final String BUNDLE_NAME = "messages.LicenseGeneratorBundle";

    /** The {@link ResourceBundle} instance. */
    @NotNull
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    /**
     * Loads a {@link String} from the {@link #BUNDLE} {@link ResourceBundle}.
     *
     * @param key    the key of the resource
     * @param params the optional parameters for the specific resource
     * @return the {@link String} value or {@code null} if no resource found for the key
     */
    @NotNull
    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE_NAME) String key, Object... params) {
        return CommonBundle.message(BUNDLE, key, params);
    }

    /** {@link LicenseGeneratorBundle} is a non-instantiable static class. */
    private LicenseGeneratorBundle() {
    }
}
