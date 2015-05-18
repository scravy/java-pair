package de.scravy.pair;

import java.io.Serializable;

import lombok.Value;
import lombok.experimental.Wither;

@Value
public class ComparableSerializablePair<First extends Serializable & Comparable<? super First>, Second extends Serializable & Comparable<? super Second>>
    implements Pair<First, Second>, Comparable<ComparableSerializablePair<First, Second>>, Serializable {

  private static final long serialVersionUID = 1L;
  
  private final @Wither First first;
  private final @Wither Second second;
  
  @Override
  public int compareTo(final ComparableSerializablePair<First, Second> other) {
    return Pairs.compare(first, second, other.first, other.second);
  }
}