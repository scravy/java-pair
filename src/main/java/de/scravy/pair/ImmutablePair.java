package de.scravy.pair;

import lombok.Value;
import lombok.experimental.Wither;

/**
 * The most simple implementation of an (immutable) Pair.
 * 
 * @author Julian Fleischer
 *
 * @since 1.0.0
 *
 * @param <First> The type of the first (left) component.
 * @param <Second> The type of the second (right) component.
 */
@Value
public class ImmutablePair<First, Second> implements Pair<First, Second> {

  private final @Wither First first;
  private final @Wither Second second;

}
