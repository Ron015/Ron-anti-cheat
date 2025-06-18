package ai.idealistic.vacan.functionality.c.a;

import ai.idealistic.vacan.utils.a.e;
import org.bukkit.command.CommandSender;

public class b {
   private static final boolean iY = e.aa("net.md_5.bungee.api.chat.ClickEvent");

   public static boolean a(CommandSender var0, String var1, String var2) {
      return iY ? a.a(var0, var1, var2, (String)null, true) : false;
   }

   public static boolean a(CommandSender var0, String var1, String var2, String var3) {
      return iY ? a.a(var0, var1, var2, var3, true) : false;
   }

   public static boolean b(CommandSender var0, String var1, String var2, String var3) {
      return iY ? a.b(var0, var1, var2, var3, true) : false;
   }
}
