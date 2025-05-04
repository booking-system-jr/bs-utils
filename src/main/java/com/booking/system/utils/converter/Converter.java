package com.booking.system.utils.converter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Interface for all entity-dto converters
 * @param <E> Entity type
 * @param <D> DTO type
 */
public interface Converter<E, D> {

    /**
     * Converts entity to DTO
     * @param entity source entity
     * @return DTO object
     */
    D toDto(E entity);

    /**
     * Converts DTO to entity
     * @param dto source DTO
     * @return entity object
     */
    E toEntity(D dto);

    /**
     * Updates existing entity with data from DTO
     * @param entity entity to update
     * @param dto DTO with new data
     * @return updated entity
     */
    E updateEntityFromDto(E entity, D dto);

    /**
     * Converts collection of entities to list of DTOs
     * @param entities collection of entities
     * @return List of DTOs
     */
    default List<D> toDtoList(Collection<E> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream().map(this::toDto).toList();
    }

    /**
     * Converts collection of DTOs to list of entities
     * @param dtos collection of DTOs
     * @return List of entities
     */
    default List<E> toEntityList(Collection<D> dtos) {
        if (dtos == null) {
            return Collections.emptyList();
        }
        return dtos.stream().map(this::toEntity).toList();
    }
}
