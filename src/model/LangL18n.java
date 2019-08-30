package model;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangL18n {
    private Locale locale;
    private ResourceBundle bundle;

    public LangL18n() {
        locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("ride", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
