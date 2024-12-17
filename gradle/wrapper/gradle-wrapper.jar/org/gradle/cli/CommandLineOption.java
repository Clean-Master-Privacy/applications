    package org.gradle.cli;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class CommandLineOption {
   public final HashSet options = new HashSet();
   public Class argumentType;
   public String description;
   public final HashSet groupWith;

   public CommandLineOption(List var1) {
      this.argumentType = Void.TYPE;
      this.groupWith = new HashSet();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         this.options.add(var2);
      }

   }

   public final HashSet getOptions() {
      return this.options;
   }
}
    
