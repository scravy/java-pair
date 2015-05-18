package de.scravy.pair;

import java.io.Serializable;

import lombok.Value;
import lombok.experimental.Wither;

@Value
public class SerializablePair<First extends Serializable, Second extends Serializable>
    implements Pair<First, Second>, Serializable {

  private static final long serialVersionUID = 1L;
  
  private final @Wither First first;
  private final @Wither Second second;
}