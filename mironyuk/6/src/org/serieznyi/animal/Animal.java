package org.serieznyi.animal;

public final class Animal {
  private final Type type;

  private final String name;

  public Animal(String name, Type type) {
    this.type = type;
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Имя пустое");
    }

    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  enum Type {
    CAT,
    DOG,
    RABBIT,
    DUCK
  }
}
