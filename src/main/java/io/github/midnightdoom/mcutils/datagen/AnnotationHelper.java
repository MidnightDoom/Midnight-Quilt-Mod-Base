package io.github.midnightdoom.mcutils.datagen;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class AnnotationHelper {

    public static class ValueAnnotationPair<V, A>
    {
        public final V value;
        public final A annotation;
    
        public ValueAnnotationPair(V value, A annotation)
        {
            this.value = value;
            this.annotation = annotation;
        }
    }

    // @SuppressWarnings("unchecked")
    public static <V, A extends Annotation> ArrayList<ValueAnnotationPair<V, A>> getFieldsWithAnnotation(Class<A> annotation, Class<?> clazz, Class<V> fieldClass)
    {
        Field[] fields = clazz.getFields();
        ArrayList<ValueAnnotationPair<V, A>> fs = new ArrayList<>();
        for (Field field : fields)
        {
            if (field.isAnnotationPresent(annotation))
            {
                try
                {
                    Object value = field.get(null);
                    if (fieldClass.isInstance(value))
                    {
                        fs.add(new ValueAnnotationPair<V,A>((V)value, field.getAnnotation(annotation)));
                    }
                }
                catch (IllegalArgumentException e)
                {
                    // template.LOGGER.error("@GenerateItemModel failed. Field is not static", e);
                }
                catch (IllegalAccessException e)
                {
                    // template.LOGGER.error("@GenerateItemModel failed. Field is not public", e);
                }
            }
        }
        return fs;
    }
    
}
