package de.scravy.pair;

import java.io.Serializable;

import lombok.Value;
import lombok.experimental.Wither;

/**
 * A {@link Pair} which is {@link Serializable}.
 *
 * @author Julian Fleischer
 *
 * @since 1.0.0
 *
 * @param <First>
 *          The type of the first (left) component.
 * @param <Second>
 *          The type of the second (right) component.
 */
@Value
class ImmutableSerializablePair<First extends Serializable, Second extends Serializable>
    implements SerializablePair<First, Second>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public boolean equals(final Object other) {
    return Pairs.equals(this, other);
  }

  @Override
  public int hashCode() {
    return Pairs.hashCode(this);
  }

  private final @Wither First first;
  private final @Wither Second second;
}