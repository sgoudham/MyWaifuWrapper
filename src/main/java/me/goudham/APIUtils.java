package me.goudham;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import me.goudham.domain.pagination.PaginationData;
import me.goudham.domain.series.Series;
import me.goudham.domain.waifu.Waifu;

import java.util.List;

/**
 * Includes helper methods to use within {@link APIWrapper}
 *
 */
class APIUtils {

    /**
     * @param model The actual class of the given model. E.g {@link Waifu#getClass()}
     * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link JavaType} of {@link List}
     *
     */
    static <T> JavaType listOf(Class<T> model) {
        return TypeFactory.defaultInstance().constructCollectionType(List.class, model);
    }

    /**
     * @param model The actual class of the given model. E.g {@link Waifu#getClass()}
     * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link JavaType} of {@link PaginationData}
     */
    static <T> JavaType paginationData(Class<T> model) {
        return TypeFactory.defaultInstance().constructParametricType(PaginationData.class, model);
    }
}
