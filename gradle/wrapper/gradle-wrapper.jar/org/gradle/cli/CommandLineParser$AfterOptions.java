    package org.gradle.cli;

public final class CommandLineParser$AfterOptions extends CommandLineParser$ParserState {
   public final ParsedCommandLine commandLine;

   public CommandLineParser$AfterOptions(ParsedCommandLine var1) {
      super(0);
      this.commandLine = var1;
   }

   public final boolean maybeStartOption(String var1) {
      return false;
   }

   public final CommandLineParser$OptionParserState onStartOption(String var1, String var2) {
      return new CommandLineParser$UnknownOptionParserState(var1, this.commandLine, this);
   }

   public final CommandLineParser$ParserState onNonOption(String var1) {
      this.commandLine.extraArguments.add(var1);
      return this;
   }
}
    
