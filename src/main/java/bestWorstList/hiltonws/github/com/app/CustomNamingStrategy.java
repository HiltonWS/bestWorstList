package bestWorstList.hiltonws.github.com.app;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class CustomNamingStrategy extends ImprovedNamingStrategy {

    @Override
    public String classToTableName(String className) {
        return super.classToTableName(className).toUpperCase();
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return super.propertyToColumnName(propertyName).toUpperCase();
    }
}