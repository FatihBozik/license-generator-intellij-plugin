package io.github.fatihbozik.licensegenerator.util;

import io.github.fatihbozik.licensegenerator.license.License;
import io.github.fatihbozik.licensegenerator.license.LicenseType;
import io.netty.util.internal.StringUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * {@link Resources} util class that contains methods that work on plugin resources.
 *
 * @author Fatih Bozik
 */
public final class Resources {

    /** Path to the license files */
    @NonNls
    private static final String LICENSES = "/licenses/";

    /** Private constructor to prevent creating {@link Resources} instance. */
    private Resources() {
    }

    /**
     * Returns license by type.
     *
     * @return Licenses list
     */
    @NotNull
    public static License getLicense(@NotNull LicenseType type) {
        final String path = LICENSES.concat(type.getKey());
        File file = getResource(path);
        if (file != null) {
            String content = getResourceContent(path);
            return new License(type, content);
        }
        return new License(type, StringUtil.EMPTY_STRING);
    }

    /**
     * Returns licenses directory.
     *
     * @return Resources directory
     */
    @Nullable
    private static File getResource(@NotNull String path) {
        URL resource = Resources.class.getResource(path);
        if (resource == null) {
            return null;
        }
        return new File(resource.getPath());
    }

    /**
     * Reads resource file and returns its content as a String.
     *
     * @param path Resource path
     * @return Content
     */
    @Nullable
    private static String getResourceContent(@NotNull String path) {
        return convertStreamToString(Resources.class.getResourceAsStream(path));
    }

    /**
     * Converts InputStream resource to String.
     *
     * @param inputStream Input stream
     * @return Content
     */
    @Nullable
    private static String convertStreamToString(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
