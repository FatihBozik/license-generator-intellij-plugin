package io.github.fatihbozik.licencegenerator;

/**
 * @author Fatih Bozik
 */
public enum Licence {
    APACHE("Apache Licence 2.0", "apache-2.0"),
    GNU("GNU General Public License v3.0", "gpl-3.0"),
    MIT("MIT Licence", "mit");

    private String name;
    private String keyword;

    Licence(String name, String keyword) {
        this.name = name;
        this.keyword = keyword;
    }

    public String getName() {
        return name;
    }

    public String getKeyword() {
        return keyword;
    }
}
