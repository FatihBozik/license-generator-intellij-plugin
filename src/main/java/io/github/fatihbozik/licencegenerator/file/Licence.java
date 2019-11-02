package io.github.fatihbozik.licencegenerator.file;

/**
 * @author Fatih Bozik
 */
public enum Licence {
    APACHE("Apache Licence 2.0"),
    GNU("GNU General Public License v3.0"),
    MIT("MIT Licence");

    private String name;

    Licence(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
