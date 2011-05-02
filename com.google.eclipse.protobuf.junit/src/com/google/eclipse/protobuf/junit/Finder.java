/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.junit;

import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType;

import java.util.List;

import com.google.eclipse.protobuf.protobuf.*;

/**
 * @author alruiz@google.com (Alex Ruiz)
 */
public final class Finder {

  public static Message findMessage(String name, Protobuf root) {
    for (Message message : getAllContentsOfType(root, Message.class))
      if (name.equals(message.getName())) return message;
    return null;
  }

  public static Option findOption(String name, Protobuf root) {
    for (Option option : root.getOptions())
      if (name.equals(option.getName())) return option;
    return null;
  }

  public static Property findProperty(String name, Protobuf root) {
    for (Property property : allProperties(root))
      if (name.equals(property.getName())) return property;
    return null;
  }
  
  public static List<Property> allProperties(Protobuf root) {
    return getAllContentsOfType(root, Property.class);
  }
  
  public static Literal findLiteral(String name, Protobuf root) {
    List<Literal> literals = getAllContentsOfType(root, Literal.class);
    for (Literal literal : literals)
      if (name.equals(literal.getName())) return literal;
        return null;
  }
  
  private Finder() {}
}
