package bestWorstList.hiltonws.github.com.core.generic;

import bestWorstList.hiltonws.github.com.core.generics.DefaultEntity;

public interface IServiceListener<T extends DefaultEntity> {

    void onCreate();

    void onList();

    void onRemove();
}